/**
 * @Title: RssServiceImpl.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.rss.feed.dao.FeedRepository;
import com.lmg.rss.feed.dao.ItemRepository;
import com.lmg.rss.feed.dao.UserFeedRepository;
import com.lmg.rss.feed.dao.UserRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.util.FeedUtil;

/***********************************
 * @ClassName: RssServiceImpl.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:56:51
 ***********************************/

@Component("feedService")
@Transactional
public class FeedServiceImpl implements FeedService {
    
    @Autowired
    private FeedRepository     feedRepository;
    
    @Autowired
    private UserRepository     userRepository;
    
    @Autowired
    private UserFeedRepository userFeedRepository;
    
    @Autowired
    private ItemRepository     itemRepository;
    
    
    /**
     * @Title: findOne
     * @Description: TODO
     * @param id
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午4:56:51
     */
    @Override
    public Feed findOne(Integer id) {
        return feedRepository.findOne(id);
    }
    
    
    /**
     * @Title: findByGeneratorContainingOrderByPubDateDesc
     * @Description: TODO
     * @param generator
     * @param pageable
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午4:56:52
     */
    @Override
    public List<Feed> findByLink(String link) {
        return feedRepository.findByLink(link);
    }
    
    
    /**
     * @Title: save
     * @Description: TODO
     * @param rss
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午5:09:45
     */
    @Override
    public Feed save(Feed feed) {
        // 根据link查找是否存在
        List<Feed> feedList = feedRepository.findByLink(feed.getLink());
        if (feedList.size() == 0){
            return feedList.get(0);
        }
        return feedRepository.save(feed);
    }
    
    
    /**
     * @Title: save
     * @Description: TODO
     * @param rss
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午5:09:45
     */
    @Override
    public Feed addFeed(String url) {
        // 根据link查找是否存在
        List<Feed> feedList = feedRepository.findByUrl(url);
        if (feedList.size() != 0){
            return feedList.get(0);
        }
        
        Map<String, Object> feedAndItems = FeedUtil.parseReturnFeedAndItems(url);
        if (feedAndItems == null){
            return null;
        }
        Feed feed = (Feed) feedAndItems.get("feed");
        feed.setUrl(url);
        feed.setReferCount(1);
        feed.setLastUpdDate(new Timestamp(System.currentTimeMillis()));
        
        List<Item> itemList = (List<Item>) feedAndItems.get("items");
        
        if (feed.getTitle() == null || feed.getTitle().trim().equals("")){
            return null;
        }
        feed = feedRepository.save(feed);
        for (Item item : itemList){
            item.setFeed(feed);
        }
        itemRepository.save(itemList);
        
        return feed;
    }
    
}
