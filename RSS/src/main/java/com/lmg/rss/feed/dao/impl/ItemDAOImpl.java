/**
 * @Title: ItemDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.ItemDAO;
import com.lmg.rss.feed.model.Item;
import com.lmg.rss.util.CommonUtils;

/***********************************
 * @ClassName: ItemDAOImpl.java
 * @Description: ItemDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:13:49
 ***********************************/

@Repository("itemDAO")
public class ItemDAOImpl extends BaseDAOImpl<Item> implements ItemDAO {
    
    /**
     * @Title: countByUser
     * @Description: TODO
     * @param userId
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午10:55:54
     */
    @Override
    public Integer countByUser(Map<String, Object> queryMap) {
        return getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + "countByUser", queryMap);
    }
    
    
    /**
     * @Title: selectByUser
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:00:59
     */
    @Override
    public List<Item> selectByUser(Map<String, Object> queryMap) {
        RowBounds rowBounds = CommonUtils.getRowBounds(queryMap);
        return getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + "countByUser", queryMap, rowBounds);
    }
    
    
    /**
     * @Title: countByUserLike
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:09:30
     */
    @Override
    public int countByUserLike(Map<String, Object> queryMap) {
        return getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + "countByUserLike", queryMap);
    }
    
    
    /**
     * @Title: selectByUserLike
     * @Description: TODO
     * @param queryMap
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:09:30
     */
    @Override
    public List<Item> selectByUserLike(Map<String, Object> queryMap) {
        RowBounds rowBounds = CommonUtils.getRowBounds(queryMap);
        return getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + "selectByUserLike", queryMap, rowBounds);
    }
    
}
