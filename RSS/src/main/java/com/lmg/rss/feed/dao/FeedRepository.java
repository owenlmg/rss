/**
 * @Title: RssRepository.java
 * @Package com.lmg.springboot.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lmg.rss.feed.model.Feed;

/***********************************
 * @ClassName: RssRepository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:43:54
 ***********************************/

public interface FeedRepository extends CrudRepository<Feed, Integer> {
    
    List<Feed> findByLink(String link);
    
    
    List<Feed> findByUrl(String url);
    
    
    List<Feed> findByReferCountGreaterThan(Integer referCount);
    
}
