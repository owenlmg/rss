package com.lmg.rss;

import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lmg.rss.feed.dao.UserFeedRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.service.FeedService;
import com.lmg.rss.feed.service.ItemService;
import com.lmg.rss.feed.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppTest extends TestCase {
    
    @Autowired
    private FeedService        feedService;
    
    @Autowired
    private UserService        userService;
    
    @Autowired
    private UserFeedRepository userFeedRepository;
    
    @Autowired
    private ItemService        itemService;
    
    
    // @Test
    public void testAddUser() {
        User user = new User();
        user.setLoginName("abc");
        user.setLoginPass("123456");
        user.setNickname("大罗");
        
        user = userService.save(user);
        assertNotNull(user.getId());
    }
    
    
    // @Test
    public void testSubscribe() {
        Feed feed = userService.subscribe(2, "http://feeds.geekpark.net");
        assertNotNull(feed);
        assertEquals("http://feeds.geekpark.net", feed.getUrl());
        assertEquals(2, feed.getId());
        
    }
    
    
    @Test
    public void testUnSubscribe() {
        userService.unSubscribe(2, 3);
    }
    
    
    @Test
    public void testGetFeeds() {
        Set<Feed> feeds = userService.findOne(1).getFeeds();
        assertEquals(1, feeds.size());
        System.out.println(feeds);
    }
    
    
    @Test
    public void testGetItems() {
        Pageable pageable = new PageRequest(0, 10);
        Page<Item> items = itemService.findByFeedIdOrderByPubDateDesc(1, pageable);
        System.out.println(items.getTotalPages());
        System.out.println(items.getContent().size());
    }
}
