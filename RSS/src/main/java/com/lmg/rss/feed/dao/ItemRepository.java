/**
 * @Title: RssRepository.java
 * @Package com.lmg.springboot.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lmg.rss.feed.model.Item;

/***********************************
 * @ClassName: RssRepository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:43:54
 ***********************************/

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {
    Page<Item> findByFeedIdOrderByPubDateDesc(Integer feedId, Pageable pageable);
    
    
    /**
     * @Title: exists
     * @Description: TODO
     * @param link
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月28日上午10:44:32
     */
    Integer countByLink(String link);
    
    
    Page<Item> findByFeedIdInOrderByPubDateDesc(Set<Integer> feedIds, Pageable pageable);
}
