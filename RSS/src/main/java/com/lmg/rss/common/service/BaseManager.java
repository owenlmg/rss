/**
 * @Title: BaseManager.java
 * @Package com.webgis.common.service
 */
package com.lmg.rss.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/***********************************
 * @ClassName: BaseManager.java
 * @Description: 基础Manager
 * @author: luomingguo
 * @createdAt: 2014-8-26下午02:56:34
 ***********************************/

public interface BaseManager<T> {
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
     * 根据条件查询记录数
     */
    public abstract Integer countByMap(Map<String, Object> queryMap);
    
    
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
     * 查询条数
     */
    public Map<String, Object> selectInPage(Map<String, Object> param);
    
    
    /**
     * 树形查询
     */
    public List<T> selectByTree(Map<String, Object> param);
    
    
    /**
     * 根据ID查询一个结果，附带一个参数
     * 
     * @param id
     * @param conditionName
     *            参数名
     * @param conditionValue
     *            参数值
     * @return
     * @author Warren Wang
     * @since 2017年7月5日 上午9:12:09
     */
    public T get(Serializable id, String conditionName, Object conditionValue);
    
    
    /**
     * 根据一个参数, 查询一个结果
     * 
     * @param id
     * @param conditionName
     *            参数名
     * @param conditionValue
     *            参数值
     * @return
     * @author Warren Wang
     * @since 2017年7月5日 上午9:12:09
     */
    public T get(String conditionName, Object conditionValue);
    
    
    /**
     * 根据ID查询一个结果， 附带多个参数
     * 
     * @param id
     * @param params
     *            参数Map
     * @return
     * @author Warren Wang
     * @since 2017年7月5日 上午9:16:52
     */
    public T get(Serializable id, Map<String, Object> params);
    
    
    /**
     * 查询一个结果，附带多个参数
     * 
     * @param id
     * @param params
     *            参数Map
     * @return
     * @author Warren Wang
     * @since 2017年7月5日 上午9:16:52
     */
    public T get(Map<String, Object> params);
    
    
    /**
     * 批量插入
     */
    public abstract Integer batchInsert(List<T> o);
    
}
