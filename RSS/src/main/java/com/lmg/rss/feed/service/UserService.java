/**
 * @Title: UserService.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.List;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.model.UserFeed;

/***********************************
 * @ClassName: UserService.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:46:52
 ***********************************/

public interface UserService {
    User save(User user);
    
    
    User findOne(Integer id);
    
    
    List<User> findByLoginName(String loginName);
    
    
    List<User> findByOpenId(String openId);
    
    
    List<Feed> findByUserId(Integer userId);
    
    
    UserFeed subscribe(Integer userId, String url);
    
    
    void unSubscribe(Integer userId, Integer feed);
}
