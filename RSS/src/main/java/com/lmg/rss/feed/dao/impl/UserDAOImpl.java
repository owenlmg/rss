/**
 * @Title: UserDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.UserDAO;
import com.lmg.rss.feed.model.User;

/***********************************
 * @ClassName: UserDAOImpl.java
 * @Description: UserDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:18:46
 ***********************************/

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    
}
