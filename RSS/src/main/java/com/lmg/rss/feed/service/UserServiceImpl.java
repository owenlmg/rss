/**
 * @Title: UserServiceImpl.java
 * @Package com.lmg.springboot.sys.service
 */
package com.lmg.rss.feed.service;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.rss.feed.dao.FeedRepository;
import com.lmg.rss.feed.dao.ItemRepository;
import com.lmg.rss.feed.dao.UserFeedRepository;
import com.lmg.rss.feed.dao.UserRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.model.UserFeed;
import com.lmg.rss.feed.model.UserFeedPK;
import com.lmg.rss.util.HttpRequest;
import com.lmg.rss.util.MD5Util;

/***********************************
 * @ClassName: UserServiceImpl.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月9日下午1:32:15
 ***********************************/

@Component("userSerive")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository     userRepository;
    // @Autowired
    // private UserFeedRepository userFeedRepository;
    @Autowired
    private FeedService        feedService;
    @Autowired
    private UserFeedRepository userFeedRepository;
    @Autowired
    private FeedRepository     feedRepository;
    @Autowired
    private ItemRepository     itemRepository;
    @Autowired
    private Environment        env;
    
    
    /**
     * @Title: save
     * @Description: TODO
     * @param user
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:32:15
     */
    @Override
    public User save(User user) {
        List<User> users = userRepository.findBySession(user.getSession());
        if (users.size() > 0){
            User saveUser = users.get(0);
            
            saveUser.setHeadImgUrl(user.getHeadImgUrl());
            saveUser.setCity(user.getCity());
            saveUser.setCountry(user.getCountry());
            saveUser.setSex(user.getSex());
            saveUser.setLanguage(user.getLanguage());
            saveUser.setNickname(user.getNickname());
            saveUser.setProvince(user.getProvince());
            
            return userRepository.save(saveUser);
        }
        return null;
    }
    
    
    /**
     * @Title: findOne
     * @Description: TODO
     * @param id
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:32:15
     */
    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }
    
    
    /**
     * @Title: findByLoginName
     * @Description: TODO
     * @param loginName
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:32:15
     */
    @Override
    public List<User> findByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }
    
    
    /**
     * @Title: findByOpenId
     * @Description: TODO
     * @param openId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:32:15
     */
    @Override
    public List<User> findByOpenId(String openId) {
        return userRepository.findByOpenId(openId);
    }
    
    
    /**
     * @Title: findByFeedsId
     * @Description: TODO
     * @param feedId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月14日上午11:10:07
     */
    @Override
    public Set<User> findByFeedsId(Integer feedId) {
        return userRepository.findByFeeds_id(feedId);
    }
    
    
    /**
     * @Title: subscribe
     * @Description: TODO
     * @param userId
     * @param url
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:48:38
     */
    @Override
    public Feed subscribe(Integer userId, String url) {
        User user = userRepository.findOne(userId);
        if (user == null){
            return null;
        }
        Set<Feed> feeds = user.getFeeds();
        for (Feed feed : feeds){
            if (url.equalsIgnoreCase(feed.getUrl())){
                return feed;
            }
        }
        Feed feed = feedService.addFeed(url);
        feeds.add(feed);
        user.setFeeds(feeds);
        user = userRepository.save(user);
        // 引用加1
        feed.setReferCount(feed.getReferCount() + 1);
        
        return feedRepository.save(feed);
    }
    
    
    /**
     * @Title: unSubscribe
     * @Description: TODO
     * @param userId
     * @param url
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:48:38
     */
    @Override
    public void unSubscribe(Integer userId, Integer feed) {
        UserFeedPK userFeedPK = new UserFeedPK(userId, feed);
        UserFeed userFeed = userFeedRepository.findOne(userFeedPK);
        if (userFeed != null){
            userFeedRepository.delete(userFeedPK);
            // 引用值减小
            Feed oldFeed = feedRepository.findOne(feed);
            if (oldFeed != null){
                oldFeed.setReferCount(oldFeed.getReferCount() - 1);
                feedRepository.save(oldFeed);
            }
        }
    }
    
    
    /**
     * @Title: like
     * @Description: TODO
     * @param user
     * @param item
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月14日下午2:30:44
     */
    @Override
    public Item like(Integer userId, Integer itemId) {
        User user = userRepository.findOne(userId);
        if (user == null){
            return null;
        }
        Item item = itemRepository.findOne(itemId);
        if (item == null){
            return null;
        }
        Set<Item> items = user.getItems();
        for (Item it : items){
            if (itemId.equals(it.getId())){
                return it;
            }
        }
        items.add(item);
        user.setItems(items);
        user = userRepository.save(user);
        
        return item;
    }
    
    
    /**
     * @Title: getSession
     * @Description: TODO
     * @param code
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月28日下午5:03:39
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
            List<User> users = userRepository.findByOpenId(openId);
            if (users.size() > 0){
                return users.get(0).getSession();
            }
            User user = new User();
            user.setOpenId(openId);
            user.setSessionKey(sessionKey);
            user.setSession(session);
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setLastUseTime(user.getCreateTime());
            
            userRepository.save(user);
            return session;
        } catch (JSONException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
