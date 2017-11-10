/**
 * @Title: UserFeedRepository.java
 * @Package com.lmg.springboot.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.UserFeed;

/***********************************
 * @ClassName: UserFeedRepository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:43:54
 ***********************************/

public interface UserFeedRepository extends CrudRepository<UserFeed, Integer> {
    
    List<Feed> findByUserId(Integer userId);
}
