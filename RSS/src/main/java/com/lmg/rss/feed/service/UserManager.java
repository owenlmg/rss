/**
 * @Title: UserManager.java
 * @Package com.lmg.rss.feed.service
 */
package com.lmg.rss.feed.service;

import com.lmg.rss.common.service.BaseManager;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;

/***********************************
 * @ClassName: UserManager.java
 * @Description: UserService接口
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:18:46
 ***********************************/

public interface UserManager extends BaseManager<User> {
    String getSession(String code);
    
    
    Feed subscribe(Integer userId, String url);
    
    
    void unSubscribe(Integer userId, Integer feed);
    
    
    Item like(Integer userId, Integer itemId);
}
