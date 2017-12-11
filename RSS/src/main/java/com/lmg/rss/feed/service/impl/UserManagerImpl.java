/**
 * @Title: UserManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.UserDAO;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.model.UserFeed;
import com.lmg.rss.feed.model.UserItem;
import com.lmg.rss.feed.service.FeedManager;
import com.lmg.rss.feed.service.ItemManager;
import com.lmg.rss.feed.service.UserFeedManager;
import com.lmg.rss.feed.service.UserItemManager;
import com.lmg.rss.feed.service.UserManager;
import com.lmg.rss.util.HttpRequest;
import com.lmg.rss.util.MD5Util;

/***********************************
 * @ClassName: UserManagerImpl.java
 * @Description: UserService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:18:46
 ***********************************/

@Service("userManager")
public class UserManagerImpl extends BaseManagerImpl<User> implements UserManager {
    
    @Autowired
    private Environment     env;
    
    @Autowired
    private UserManager     userManager;
    @Autowired
    private FeedManager     feedManager;
    @Autowired
    private ItemManager     itemManager;
    @Autowired
    private UserFeedManager userFeedManager;
    @Autowired
    private UserItemManager userItemManager;
    
    
    @Resource(name = "userDAO")
    public void setUserDAO(UserDAO userDAO) {
        super.baseDAO = userDAO;
    }
    
    
    public UserDAO getUserDAO() {
        return (UserDAO) super.baseDAO;
    }
    
    
    /**
     * @Title: getSession
     * @Description: TODO
     * @param code
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月1日下午4:30:31
     */
    @Override
    public String getSession(String code) {
        StringBuilder url = new StringBuilder(env.getProperty("wx.url"));
        url.append("?appid=");
        url.append(env.getProperty("wx.appId"));
        url.append("&secret=");
        url.append(env.getProperty("wx.appSecret"));
        url.append("&js_code=");
        url.append(code);
        url.append("&grant_type=");
        url.append("authorization_code");
        String result = HttpRequest.sendGet(url.toString(), Charset.forName("UTF-8"));
        String openId = "";
        String sessionKey = "";
        String unionid = "";
        try{
            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject.has("openid")){
                openId = jsonObject.getString("openid");
            }
            if (jsonObject.has("session_key")){
                sessionKey = jsonObject.getString("session_key");
            }
            if (jsonObject.has("unionid")){
                unionid = jsonObject.getString("unionid");
            }
            String session = MD5Util.getMd5(openId + sessionKey);
            // 检查openid存不存在
            User queryUser = new User();
            queryUser.setOpenId(openId);
            List<User> users = userManager.selectByModel(queryUser);
            if (users.size() > 0){
                return users.get(0).getSession();
            }
            User user = new User();
            user.setOpenId(openId);
            user.setSessionKey(sessionKey);
            user.setSession(session);
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setLastUseTime(user.getCreateTime());
            
            userManager.save(user);
            return session;
        } catch (JSONException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    /**
     * @Title: subscribe
     * @Description: TODO
     * @param userId
     * @param url
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月1日下午4:30:31
     */
    @Override
    public Feed subscribe(Integer userId, String url) {
        User user = userManager.get(userId);
        if (user == null){
            return null;
        }
        // first,check feed data
        // second,check user_feed data
        Feed feed = new Feed();
        feed.setUrl(url);
        List<Feed> feedList = feedManager.selectByModel(feed);
        if (feedList.size() > 0){
            feed = feedList.get(0);
            UserFeed uf = new UserFeed(userId, feed.getId());
            if (userFeedManager.get(uf) != null){
                uf.setSubscribeTime(new Date());
                userFeedManager.save(uf);
            }
        } else{
            feed = feedManager.addFeed(url);
            if (feed != null){
                UserFeed uf = new UserFeed(userId, feed.getId());
                uf.setSubscribeTime(new Date());
                userFeedManager.save(uf);
            }
        }
        return feed;
    }
    
    
    /**
     * @Title: unSubscribe
     * @Description: TODO
     * @param userId
     * @param feed
     * @createdBy:Luomingguo
     * @createaAt:2017年12月1日下午4:30:31
     */
    @Override
    public void unSubscribe(Integer userId, Integer feedId) {
        UserFeed uf = new UserFeed(feedId, userId);
        uf = userFeedManager.get(uf);
        if (uf != null){
            
            userFeedManager.delete(uf);
            Feed feed = feedManager.get(feedId);
            if (feed != null){
                feed.setReferCount(feed.getReferCount() - 1);
                feedManager.update(feed);
            }
        }
    }
    
    
    /**
     * @Title: like
     * @Description: TODO
     * @param userId
     * @param itemId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月1日下午4:30:31
     */
    @Override
    public Item like(Integer userId, Integer itemId) {
        User user = userManager.get(userId);
        if (user == null){
            return null;
        }
        Item item = itemManager.get(itemId);
        if (item == null){
            return null;
        }
        UserItem ui = new UserItem(userId, itemId);
        if (userItemManager.get(ui) != null){
            userItemManager.save(ui);
        }
        
        return item;
    }
}
