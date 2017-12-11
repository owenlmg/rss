/**
 * @Title: ItemManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.ItemDAO;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.feed.service.ItemManager;

/***********************************
 * @ClassName: ItemManagerImpl.java
 * @Description: ItemService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:13:49
 ***********************************/

@Service("itemManager")
public class ItemManagerImpl extends BaseManagerImpl<Item> implements ItemManager {
    
    @Resource(name = "itemDAO")
    public void setItemDAO(ItemDAO itemDAO) {
        super.baseDAO = itemDAO;
    }
    
    
    public ItemDAO getItemDAO() {
        return (ItemDAO) super.baseDAO;
    }
    
    
    /**
     * @Title: countByUser
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午10:55:38
     */
    @Override
    public Integer countByUser(Map<String, Object> queryMap) {
        return getItemDAO().countByUser(queryMap);
    }
    
    
    /**
     * @Title: selectByUser
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:00:40
     */
    @Override
    public List<Item> selectByUser(Map<String, Object> queryMap) {
        return getItemDAO().selectByUser(queryMap);
    }
    
    
    /**
     * @Title: countByUserLike
     * @Description: TODO
     * @param paramMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:08:38
     */
    @Override
    public int countByUserLike(Map<String, Object> queryMap) {
        return getItemDAO().countByUserLike(queryMap);
    }
    
    
    /**
     * @Title: selectByUserLike
     * @Description: TODO
     * @param paramMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:08:38
     */
    @Override
    public List<Item> selectByUserLike(Map<String, Object> queryMap) {
        return getItemDAO().selectByUserLike(queryMap);
    }
}
