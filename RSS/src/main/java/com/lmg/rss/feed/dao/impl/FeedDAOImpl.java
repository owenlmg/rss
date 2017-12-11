/**
 * @Title: FeedDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.FeedDAO;
import com.lmg.rss.feed.model.Feed;

/***********************************
 * @ClassName: FeedDAOImpl.java
 * @Description: FeedDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:03:18
 ***********************************/

@Repository("feedDAO")
public class FeedDAOImpl extends BaseDAOImpl<Feed> implements FeedDAO {
    
    /**
     * @Title: getFeedsByUser
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午10:41:33
     */
    @Override
    public List<Feed> selectFeedsByUser(Map<String, Object> queryMap) {
        return getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + "selectFeedsByUser", queryMap);
    }
    
}
