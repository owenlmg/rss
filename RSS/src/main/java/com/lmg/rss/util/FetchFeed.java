/**
 * @Title: FetchFeed.java
 * @Package com.lmg.springboot.util
 */
package com.lmg.rss.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.service.FeedManager;
import com.lmg.rss.feed.service.ItemManager;

/***********************************
 * @ClassName: FetchFeed.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月10日上午11:00:19
 ***********************************/

@ComponentScan
public class FetchFeed extends Thread {
    private static Logger logger = LoggerFactory.getLogger(FetchFeed.class);
    
    private FeedManager   feedManager;
    
    private ItemManager   itemManager;
    
    
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
    public FetchFeed(FeedManager feedManager, ItemManager itemManager) {
        this.feedManager = feedManager;
        this.itemManager = itemManager;
        this.setName("FetchFeed线程");
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
            List<Feed> feedList = feedManager.selectAll();
            for (Feed feed : feedList){
                try{
                    Map<String, Object> feedAndItems = FeedUtil.parseReturnFeedAndItems(feed.getUrl());
                    if (feedAndItems == null){
                        continue;
                    }
                    
                    List<Item> itemList = (List<Item>) feedAndItems.get("items");
                    
                    if (feed.getTitle() != null && !feed.getTitle().trim().equals("")){
                        Date lastUpdDate = new Date(0L);
                        Map<String, Object> queryMap = new HashMap<String, Object>();
                        queryMap.put("feedId", feed.getId());
                        queryMap.put("orderBy", "PUB_DATE desc");
                        List<Item> items = itemManager.selectByMap(queryMap);
                        if (items.size() > 0){
                            Item item = items.get(0);
                            lastUpdDate = item.getPubDate();
                        }
                        
                        for (Iterator<Item> it = itemList.iterator(); it.hasNext();){
                            Item item = it.next();
                            if (item.getPubDate().before(lastUpdDate)){
                                it.remove();
                            } else{
                                // 重复性检测
                                Map<String, Object> map = new HashMap<String, Object>();
                                map.put("link", item.getLink());
                                if (itemManager.countByMap(map) == 0){
                                    item.setFeedId(feed.getId());
                                } else{
                                    it.remove();
                                }
                            }
                        }
                        if (itemList.size() > 0){
                            itemManager.batchInsert(itemList);
                            System.out.println(feed.getTitle() + "更新" + itemList.size() + "条" + new Date());
                        }
                    }
                    feed.setLastUpdDate(new Timestamp(System.currentTimeMillis()));
                    feedManager.update(feed);
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
