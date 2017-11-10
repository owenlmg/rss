/**
 * @Title: BusinessController.java
 * @Package com.lmg.springboot.feed.web
 */
package com.lmg.rss.feed.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.model.UserFeed;
import com.lmg.rss.feed.service.FeedService;
import com.lmg.rss.feed.service.ItemService;
import com.lmg.rss.feed.service.UserService;

/***********************************
 * @ClassName: BusinessController.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:47:35
 ***********************************/

@RestController
public class BusinessController {
    
    @Autowired
    private FeedService feedService;
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private UserService userService;
    
    
    /**
     * 
     * @Title: addUser
     * @Description: 增加用户
     * @param user
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午8:54:21
     */
    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
    public User addUser(User user) {
        return userService.save(user);
    }
    
    
    /**
     * 
     * @Title: subscribe
     * @Description: 订阅
     * @param user
     * @param url
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午8:54:31
     */
    @RequestMapping(value = "/subscribe/{user}", method = RequestMethod.PUT)
    public UserFeed subscribe(@PathVariable Integer user, String url) {
        return userService.subscribe(user, url);
    }
    
    
    /**
     * 
     * @Title: unSubscribe
     * @Description: 取消订阅
     * @param user
     * @param feed
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午8:54:38
     */
    @RequestMapping(value = "/unsubscribe/{user}/{feed}", method = RequestMethod.DELETE)
    public void unSubscribe(@PathVariable Integer user, @PathVariable Integer feed) {
        userService.unSubscribe(user, feed);
    }
    
    
    /**
     * 
     * @Title: getFeeds
     * @Description: 获取所有订阅
     * @param user
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午8:54:47
     */
    @RequestMapping(value = "/feeds/{user}", method = RequestMethod.GET)
    public List<Feed> getFeeds(@PathVariable Integer user) {
        return userService.findByUserId(user);
    }
    
    
    @RequestMapping(value = "/items/{feed}/{page}", method = RequestMethod.GET)
    public Page<Item> getItems(@PathVariable Integer feed, @PathVariable Integer page) {
        Pageable pageable = new PageRequest(page, 10);
        return itemService.findByFeedIdOrderByPubDateDesc(feed, pageable);
    }
}
