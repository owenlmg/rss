/**
 * @Title: ItemManager.java
 * @Package com.lmg.rss.feed.service
 */
package com.lmg.rss.feed.service;

import java.util.List;
import java.util.Map;

import com.lmg.rss.common.service.BaseManager;
import com.lmg.rss.feed.model.Item;

/***********************************
 * @ClassName: ItemManager.java
 * @Description: ItemService接口
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:13:49
 ***********************************/

public interface ItemManager extends BaseManager<Item> {
    Integer countByUser(Map<String, Object> queryMap);
    
    
    List<Item> selectByUser(Map<String, Object> queryMap);
    
    
    /**
     * @Title: countByUserLike
     * @Description: TODO
     * @param paramMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:08:25
     */
    int countByUserLike(Map<String, Object> queryMap);
    
    
    /**
     * @Title: selectByUserLike
     * @Description: TODO
     * @param paramMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:08:31
     */
    List<Item> selectByUserLike(Map<String, Object> queryMap);
}
