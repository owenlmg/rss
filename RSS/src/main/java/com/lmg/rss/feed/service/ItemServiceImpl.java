/**
 * @Title: ItemServiceImpl.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.rss.feed.dao.ItemRepository;
import com.lmg.rss.feed.model.Item;

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
    
}
