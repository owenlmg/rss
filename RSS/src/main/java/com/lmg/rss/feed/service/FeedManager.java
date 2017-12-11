/**
 * @Title: FeedManager.java
 * @Package com.lmg.rss.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.List;
import java.util.Map;

import com.lmg.rss.common.service.BaseManager;
import com.lmg.rss.feed.model.Feed;

/***********************************
 * @ClassName: FeedManager.java
 * @Description: FeedService接口
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:03:18
 ***********************************/

public interface FeedManager extends BaseManager<Feed> {
    public Feed addFeed(String url);
    
    
    public List<Feed> selectFeedsByUser(Map<String, Object> queryMap);
}
