/**
 * @Title: UserServiceImpl.java
 * @Package com.lmg.springboot.sys.service
 */
package com.lmg.rss.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.rss.feed.dao.UserFeedRepository;
import com.lmg.rss.feed.dao.UserRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.model.UserFeed;

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
    @Autowired
    private UserFeedRepository userFeedRepository;
    @Autowired
    private FeedService        feedService;
    
    
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
     * @Title: findByUserId
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月9日下午1:45:52
     */
    @Override
    public List<Feed> findByUserId(Integer userId) {
        return userFeedRepository.findByUserId(userId);
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
    public UserFeed subscribe(Integer userId, String url) {
        Feed feed = feedService.addFeed(url);
        UserFeed userFeed = new UserFeed(userId, feed.getId());
        return userFeedRepository.save(userFeed);
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
        UserFeed userFeed = new UserFeed(userId, feed);
        userFeedRepository.delete(userFeed);
        // 引用值减小
        Feed oldFeed = feedService.findOne(feed);
        if (oldFeed != null){
            oldFeed.setReferCount(oldFeed.getReferCount() - 1);
            feedService.save(oldFeed);
        }
    }
    
}
