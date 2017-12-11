/**
 * @Title: FeedManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.FeedDAO;
import com.lmg.rss.feed.dao.ItemDAO;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.service.FeedManager;
import com.lmg.rss.util.FeedUtil;

/***********************************
 * @ClassName: FeedManagerImpl.java
 * @Description: FeedService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:03:18
 ***********************************/

@Service("feedManager")
public class FeedManagerImpl extends BaseManagerImpl<Feed> implements FeedManager {
    
    @Resource(name = "feedDAO")
    public void setFeedDAO(FeedDAO feedDAO) {
        super.baseDAO = feedDAO;
    }
    
    
    public FeedDAO getFeedDAO() {
        return (FeedDAO) super.baseDAO;
    }
    
    @Autowired
    private ItemDAO itemDao;
    
    
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
        Feed feed = new Feed();
        feed.setUrl(url);
        List<Feed> feedList = this.getFeedDAO().selectByModel(feed);
        if (feedList.size() != 0){
            return feedList.get(0);
        }
        
        Map<String, Object> feedAndItems = FeedUtil.parseReturnFeedAndItems(url);
        if (feedAndItems == null){
            return null;
        }
        feed = (Feed) feedAndItems.get("feed");
        feed.setUrl(url);
        feed.setReferCount(1);
        feed.setLastUpdDate(new Timestamp(System.currentTimeMillis()));
        
        List<Item> itemList = (List<Item>) feedAndItems.get("items");
        
        if (feed.getTitle() == null || feed.getTitle().trim().equals("")){
            return null;
        }
        int feedId = this.getFeedDAO().save(feed);
        for (Item item : itemList){
            item.setFeedId(feedId);
        }
        itemDao.batchInsert(itemList);
        return feed;
    }
    
    
    /**
     * @Title: getFeedsByUser
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午10:40:27
     */
    @Override
    public List<Feed> selectFeedsByUser(Map<String, Object> queryMap) {
        
        return getFeedDAO().selectFeedsByUser(queryMap);
    }
}
