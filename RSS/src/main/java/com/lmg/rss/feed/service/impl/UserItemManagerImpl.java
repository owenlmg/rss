/**
 * @Title: UserItemManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.UserItemDAO;
import com.lmg.rss.feed.model.UserItem;
import com.lmg.rss.feed.service.UserItemManager;

/***********************************
 * @ClassName: UserItemManagerImpl.java
 * @Description: UserItemService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:40:57
 ***********************************/

@Service("userItemManager")
public class UserItemManagerImpl extends BaseManagerImpl<UserItem> implements UserItemManager {
    
    @Resource(name = "userItemDAO")
    public void setUserItemDAO(UserItemDAO userItemDAO) {
        super.baseDAO = userItemDAO;
    }
    
    
    public UserItemDAO getUserItemDAO() {
        return (UserItemDAO) super.baseDAO;
    }
}
