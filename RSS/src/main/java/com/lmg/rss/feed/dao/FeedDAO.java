/**
 * @Title: FeedDAO.java
 * @Package com.lmg.rss.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;
import java.util.Map;

import com.lmg.rss.common.dao.BaseDAO;
import com.lmg.rss.feed.model.Feed;

/***********************************
 * @ClassName: FeedDAO.java
 * @Description: FeedDAO接口
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:03:18
 ***********************************/

public interface FeedDAO extends BaseDAO<Feed> {
    
    /**
     * @Title: getFeedsByUser
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午10:41:24
     */
    List<Feed> selectFeedsByUser(Map<String, Object> queryMap);
    
}
