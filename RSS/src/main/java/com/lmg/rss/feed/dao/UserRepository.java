/**
 * @Title: RssRepository.java
 * @Package com.lmg.springboot.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.lmg.rss.feed.model.User;

/***********************************
 * @ClassName: RssRepository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:43:54
 ***********************************/

public interface UserRepository extends CrudRepository<User, Integer> {
    
    List<User> findByLoginName(String loginName);
    
    
    List<User> findByOpenId(String openId);
    
    
    Set<User> findByFeeds_id(Integer feedId);
    
}
