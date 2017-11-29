/**
 * @Title: RssService.java
 * @Package com.lmg.springboot.feed.service
 */
package com.lmg.rss.feed.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lmg.rss.feed.model.Item;

/***********************************
 * @ClassName: RssService.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:46:52
 ***********************************/

public interface ItemService {
    Page<Item> findByFeedIdOrderByPubDateDesc(Integer feedId, Pageable pageable);
    
    
    Item findOne(Integer item);
    
    
    Page<Item> findByUserIdOrderByPubDateDesc(Integer userId, Pageable pageable);
}
