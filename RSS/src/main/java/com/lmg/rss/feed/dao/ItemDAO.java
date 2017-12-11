/**
 * @Title: ItemDAO.java
 * @Package com.lmg.rss.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;
import java.util.Map;

import com.lmg.rss.common.dao.BaseDAO;
import com.lmg.rss.feed.model.Item;

/***********************************
 * @ClassName: ItemDAO.java
 * @Description: ItemDAO接口
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:13:49
 ***********************************/

public interface ItemDAO extends BaseDAO<Item> {
    Integer countByUser(Map<String, Object> queryMap);
    
    
    /**
     * @Title: selectByUser
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:00:52
     */
    List<Item> selectByUser(Map<String, Object> queryMap);
    
    
    /**
     * @Title: countByUserLike
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:09:20
     */
    int countByUserLike(Map<String, Object> queryMap);
    
    
    /**
     * @Title: selectByUserLike
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:09:25
     */
    List<Item> selectByUserLike(Map<String, Object> queryMap);
}
