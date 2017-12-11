/**
 * @Title: UserItemDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.UserItemDAO;
import com.lmg.rss.feed.model.UserItem;

/***********************************
 * @ClassName: UserItemDAOImpl.java
 * @Description: UserItemDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:40:57
 ***********************************/

@Repository("userItemDAO")
public class UserItemDAOImpl extends BaseDAOImpl<UserItem> implements UserItemDAO {
    
}
