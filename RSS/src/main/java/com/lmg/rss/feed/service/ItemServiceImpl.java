/**
 * @Title: ItemServiceImpl.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.rss.feed.dao.ItemRepository;
import com.lmg.rss.feed.dao.UserRepository;
import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.model.User;

/***********************************
 * @ClassName: ItemServiceImpl.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月10日上午9:12:27
 ***********************************/

@Component("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    
    /**
     * @Title: findByFeedIdOrderByPubDateDesc
     * @Description: TODO
     * @param feedId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月10日上午9:12:27
     */
    @Override
    public Page<Item> findByFeedIdOrderByPubDateDesc(Integer feedId, Pageable pageable) {
        return itemRepository.findByFeedIdOrderByPubDateDesc(feedId, pageable);
    }
    
    
    /**
     * @Title: findOne
     * @Description: TODO
     * @param item
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月27日下午4:25:07
     */
    @Override
    public Item findOne(Integer item) {
        return itemRepository.findOne(item);
    }
    
    
    /**
     * @Title: findByFeedIdInOrderByPubDateDesc
     * @Description: TODO
     * @param feedIds
     * @param pageable
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月28日下午3:32:47
     */
    @Override
    public Page<Item> findByUserIdOrderByPubDateDesc(Integer userId, Pageable pageable) {
        User user = userRepository.findOne(userId);
        if (user != null && user.getFeeds().size() > 0){
            Set<Integer> feedIds = new HashSet<Integer>();
            for (Feed feed : user.getFeeds()){
                feedIds.add(feed.getId());
            }
            return itemRepository.findByFeedIdInOrderByPubDateDesc(feedIds, pageable);
        }
        return null;
    }
    
}
