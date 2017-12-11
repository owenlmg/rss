/**
 * @Title: BaseDAO.java
 * @Package com.webgis.common.dao
 */
package com.lmg.rss.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * *********************************
 * 
 * @ClassName: BaseDAO.java
 * @Description: 基本DAO
 * @author: luomingguo
 * @createdAt: 2015年6月2日下午3:38:18
 **********************************
 */
public interface BaseDAO<T> {
    /**
     * 根据ID获取对象.
     */
    public abstract T get(Serializable id);
    
    
    /**
     * 根据ID获取对象.
     */
    public abstract T get(T o);
    
    
    /**
     * 根据ID加载
     */
    public abstract T load(Serializable id);
    
    
    /**
     * 获取全部对象.
     */
    public abstract List<T> selectAll();
    
    
    /**
     * 查询记录数
     */
    public abstract Integer countAll();
    
    
    /**
     * 根据对象查询
     */
    public abstract List<T> selectByModel(T o);
    
    
    /**
     * 根据条件查询
     */
    public abstract List<T> selectByMap(Map<String, Object> queryMap);
    
    
    /**
     * 模糊查询
     */
    public abstract List<T> selectByLike(Map<String, Object> queryMap);
    
    
    /**
     * 保存对象(新增或者更新)
     */
    public abstract Integer save(T o);
    
    
    /**
     * 新增对象
     */
    public abstract Integer create(T o);
    
    
    /**
     * 修改对象
     */
    public abstract Integer update(T o);
    
    
    /**
     * 删除对象
     */
    public abstract Integer delete(Serializable id);
    
    
    /**
     * 删除对象
     */
    public abstract Integer delete(T o);
    
    
    /**
     * 获取条数
     */
    public Integer countByMap(Map<String, Object> param);
    
    
    /**
     * 批量插入
     */
    public abstract Integer batchInsert(List<T> o);
}
