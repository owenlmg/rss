/**
 * @Title: UserFeedDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.UserFeedDAO;
import com.lmg.rss.feed.model.UserFeed;

/***********************************
 * @ClassName: UserFeedDAOImpl.java
 * @Description: UserFeedDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:40:57
 ***********************************/

@Repository("userFeedDAO")
public class UserFeedDAOImpl extends BaseDAOImpl<UserFeed> implements UserFeedDAO {
    
}
