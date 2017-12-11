/**
 * @Title: BusinessController.java
 * @Package com.lmg.springboot.feed.web
 */
package com.lmg.rss.feed.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.service.FeedManager;
import com.lmg.rss.feed.service.ItemManager;
import com.lmg.rss.feed.service.UserManager;
import com.lmg.rss.util.CommonUtils;
import com.lmg.rss.util.Result;

/***********************************
 * @ClassName: BusinessController.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:47:35
 ***********************************/

@RestController
public class BusinessController {
    private Logger      Logger = org.slf4j.LoggerFactory.getLogger(getClass());
    
    @Autowired
    private FeedManager feedManager;
    
    @Autowired
    private ItemManager itemManager;
    
    @Autowired
    private UserManager userManager;
    
    
    /**
     * 
     * @Title: addUser
     * @Description: 生成session
     * @param user
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午8:54:21
     */
    @RequestMapping(value = "/getSession/{code}")
    public Result<?> getSession(@PathVariable String code) {
        String session;
        if ((session = userManager.getSession(code)) != null){
            return Result.success(session);
        }
        return Result.fail("获取session失败");
    }
    
    
    /**
     * 
     * @Title: addUser
     * @Description: 完善用户信息
     * @param user
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月29日上午9:43:04
     */
    @RequestMapping(value = "/user")
    public Result<?> addUser(HttpServletRequest request, @RequestBody User user) {
        Integer userId = (Integer) request.getAttribute("userId");
        user.setId(userId);
        try{
            userManager.save(user);
            return Result.success(true);
        } catch (Exception e){
            Logger.error("用户信息保存失败", e);
            return Result.fail("用户信息保存失败");
        }
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
    public Result<?> subscribe(HttpServletRequest request, @RequestParam(value = "url", required = true) String url) {
        Integer userId = (Integer) request.getAttribute("userId");
        try{
            Feed feed = userManager.subscribe(userId, url);
            return Result.success(feed);
        } catch (Exception e){
            Logger.error("订阅失败", e);
            return Result.fail("订阅失败");
            
        }
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
    @RequestMapping(value = "/unsubscribe/{feed}")
    public Result<?> unSubscribe(HttpServletRequest request, @PathVariable Integer feed) {
        Integer userId = (Integer) request.getAttribute("userId");
        try{
            userManager.unSubscribe(userId, feed);
            return Result.success(true);
        } catch (Exception e){
            Logger.error("取消订阅失败", e);
            return Result.fail("取消订阅失败");
            
        }
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
    @RequestMapping(value = "/feeds")
    public Result<?> getFeeds(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        try{
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("userId", userId);
            List<Feed> feeds = feedManager.selectFeedsByUser(queryMap);
            return Result.success(feeds);
        } catch (Exception e){
            Logger.error("获取订阅失败", e);
            return Result.fail("获取订阅失败");
            
        }
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
    public Result<?> getItems(HttpServletRequest request, @PathVariable Integer feed, @PathVariable Integer page,
            @PathVariable Integer size) {
        Integer userId = (Integer) request.getAttribute("userId");
        Map<String, Object> paramMap = CommonUtils.requestToQueryMap(request);
        paramMap.put("userId", userId);
        // 0表示获取所有关注的feed的内容
        if (feed != 0){
            paramMap.put("feedId", feed);
        }
        try{
            int total = itemManager.countByUser(paramMap);
            List<Item> items = itemManager.selectByUser(paramMap);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("total", total);
            resultMap.put("rows", items);
            return Result.success(resultMap);
        } catch (Exception e){
            Logger.error("获取源失败", e);
            return Result.fail("获取源失败");
        }
    }
    
    
    @RequestMapping(value = "/item/{item}")
    public Result<?> getItem(@PathVariable Integer item) {
        try{
            return Result.success(itemManager.get(item));
        } catch (Exception e){
            Logger.error("获取文章失败", e);
            return Result.fail("获取文章失败");
        }
    }
    
    
    @RequestMapping(value = "/like/{item}")
    public Result<?> like(HttpServletRequest request, @PathVariable Integer item) {
        Integer userId = (Integer) request.getAttribute("userId");
        try{
            return Result.success(userManager.like(userId, item));
        } catch (Exception e){
            Logger.error("喜欢文章失败", e);
            return Result.fail("喜欢文章失败");
        }
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
    @RequestMapping(value = "/likes/{page}")
    public Result<?> getLikes(HttpServletRequest request, @PathVariable Integer page) {
        Integer userId = (Integer) request.getAttribute("userId");
        Map<String, Object> paramMap = CommonUtils.requestToQueryMap(request);
        paramMap.put("userId", userId);
        try{
            int total = itemManager.countByUserLike(paramMap);
            List<Item> items = itemManager.selectByUserLike(paramMap);
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("total", total);
            resultMap.put("rows", items);
            return Result.success(resultMap);
        } catch (Exception e){
            Logger.error("获取失败", e);
            return Result.fail("获取失败");
        }
    }
    
    
    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "success";
    }
}
