/**
 * @Title: UserService.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.List;
import java.util.Set;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;

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
    
    
    Set<User> findByFeedsId(Integer feedId);
    
    
    Feed subscribe(Integer userId, String url);
    
    
    void unSubscribe(Integer userId, Integer feed);
    
    
    Item like(Integer userId, Integer itemId);
    
    
    /**
     * @Title: getSession
     * @Description: TODO
     * @param code
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月28日下午5:03:29
     */
    String getSession(String code);
}
