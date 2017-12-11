/**
 * @Title: UserFeedManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.UserFeedDAO;
import com.lmg.rss.feed.model.UserFeed;
import com.lmg.rss.feed.service.UserFeedManager;

/***********************************
 * @ClassName: UserFeedManagerImpl.java
 * @Description: UserFeedService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:40:57
 ***********************************/

@Service("userFeedManager")
public class UserFeedManagerImpl extends BaseManagerImpl<UserFeed> implements UserFeedManager {
    
    @Resource(name = "userFeedDAO")
    public void setUserFeedDAO(UserFeedDAO userFeedDAO) {
        super.baseDAO = userFeedDAO;
    }
    
    
    public UserFeedDAO getUserFeedDAO() {
        return (UserFeedDAO) super.baseDAO;
    }
}
