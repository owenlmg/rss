/**
 * @Title: RssService.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.List;

import com.lmg.rss.feed.model.Feed;

/***********************************
 * @ClassName: RssService.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:46:52
 ***********************************/

public interface FeedService {
    Feed save(Feed rss);
    
    
    Feed findOne(Integer id);
    
    
    List<Feed> findByLink(String link);
    
    
    Feed addFeed(String url);
    
    // Set<Feed> findByUsersId(Integer id);
}
