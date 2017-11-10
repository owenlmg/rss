/**
 * @Title: FetchFeed.java
 * @Package com.lmg.springboot.util
 */
package com.lmg.rss.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lmg.rss.feed.dao.FeedRepository;
import com.lmg.rss.feed.dao.ItemRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;

/***********************************
 * @ClassName: FetchFeed.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月10日上午11:00:19
 ***********************************/

@ComponentScan
public class FetchFeed extends Thread {
    private static Logger  logger = LoggerFactory.getLogger(FetchFeed.class);
    
    private FeedRepository feedRepository;
    
    private ItemRepository itemRepository;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param feedRepository2
     * @param itemRepository2
     */
    public FetchFeed(FeedRepository feedRepository, ItemRepository itemRepository) {
        this.feedRepository = feedRepository;
        this.itemRepository = itemRepository;
    }
    
    
    /**
     * @Title: run
     * @Description: TODO
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午11:01:45
     */
    @Override
    public void run() {
        while (true){
            List<Feed> feedList = feedRepository.findByReferCountGreaterThan(0);
            for (Feed feed : feedList){
                try{
                    Map<String, Object> feedAndItems = FeedUtil.parseReturnFeedAndItems(feed.getUrl());
                    if (feedAndItems == null){
                        continue;
                    }
                    
                    List<Item> itemList = (List<Item>) feedAndItems.get("items");
                    
                    if (feed.getTitle() != null && !feed.getTitle().trim().equals("")){
                        Date lastUpdDate = new Date(0L);
                        Page<Item> items = itemRepository.findByFeedIdOrderByPubDateDesc(feed.getId(), new PageRequest(
                                0, 1));
                        if (items != null && items.hasContent()){
                            Item item = items.getContent().get(0);
                            lastUpdDate = item.getPubDate();
                        }
                        
                        for (Iterator<Item> it = itemList.iterator(); it.hasNext();){
                            Item item = it.next();
                            if (item.getPubDate().before(lastUpdDate)){
                                it.remove();
                            } else{
                                item.setFeedId(feed.getId());
                            }
                        }
                        if (itemList.size() > 0){
                            itemRepository.save(itemList);
                            System.out.println(feed.getTitle() + "更新" + itemList.size() + "条" + new Date());
                        }
                    }
                    feed.setLastUpdDate(new Timestamp(System.currentTimeMillis()));
                    feedRepository.save(feed);
                } catch (Exception e){
                    logger.error("Feed解析错误,URL:" + feed, e);
                }
            }
            try{
                Thread.sleep(1000 * 60 * 10);
            } catch (Exception e){
                logger.error("Feed解析错误执行错误", e);
            }
        }
        
    }
}
