/**
 * @Title: BusinessController.java
 * @Package com.lmg.springboot.feed.web
 */
package com.lmg.rss.feed.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
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
    @RequestMapping(value = "/getSession/{code}")
    public String getSession(@PathVariable String code) {
        return userService.getSession(code);
    }
    
    
    @RequestMapping(value = "/user")
    public User addUser(@RequestBody User user) {
        // User user = new User();
        // user.setHeadImgUrl(avatarUrl);
        // user.setCity(city);
        // user.setCountry(country);
        // user.setSex(gender);
        // user.setLanguage(language);
        // user.setNickname(nickName);
        // user.setProvince(province);
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
    @RequestMapping(value = "/subscribe")
    public Feed subscribe(@RequestParam(value = "user", required = true) Integer user,
            @RequestParam(value = "url", required = true) String url) {
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
    @RequestMapping(value = "/unsubscribe/{user}/{feed}")
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
    @RequestMapping(value = "/feeds/{user}")
    public Set<Feed> getFeeds(@PathVariable Integer user) {
        User u = userService.findOne(user);
        return u.getFeeds();
    }
    
    
    /**
     * 
     * @Title: getItems
     * @Description: 分页方式获取指定feed的内容
     * @param feed
     * @param page
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月14日下午1:23:54
     */
    @RequestMapping(value = "/items/{feed}/{page}/{size}")
    public Page<Item> getItems(@PathVariable Integer feed, @PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageable = new PageRequest(page, size);
        if (feed == 0){
            return itemService.findByUserIdOrderByPubDateDesc(1, pageable);
        }
        return itemService.findByFeedIdOrderByPubDateDesc(feed, pageable);
    }
    
    
    @RequestMapping(value = "/item/{item}")
    public Item getItem(@PathVariable Integer item) {
        return itemService.findOne(item);
    }
    
    
    @RequestMapping(value = "/like/{user}/{item}")
    public Item like(@PathVariable Integer user, @PathVariable Integer item) {
        return userService.like(user, item);
    }
    
    
    /**
     * 
     * @Title: getLikes
     * @Description: 分页方式获取指定feed的内容
     * @param feed
     * @param page
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月14日下午1:23:54
     */
    @RequestMapping(value = "/likes/{user}/{page}")
    public Set<Item> getLikes(@PathVariable Integer user, @PathVariable Integer page) {
        Pageable pageable = new PageRequest(page, 10);
        return userService.findOne(user).getItems();
    }
    
    
    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "success";
    }
}
