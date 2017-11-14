/**
 * @Title: UserServiceImpl.java
 * @Package com.lmg.springboot.sys.service
 */
package com.lmg.rss.feed.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
        List<User> users = userRepository.findByLoginName(user.getLoginName());
        if (users.size() > 0){
            user.setCreateTime(users.get(0).getCreateTime());
            user.setLastUseTime(users.get(0).getLastUseTime());
        } else{
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setLastUseTime(new Timestamp(System.currentTimeMillis()));
        }
        return userRepository.save(user);
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
}
