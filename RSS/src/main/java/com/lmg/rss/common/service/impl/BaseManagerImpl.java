/**
 * @Title: BaseManagerImpl.java
 * @Package com.webgis.common.service.impl
 */
package com.lmg.rss.common.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmg.rss.common.dao.BaseDAO;
import com.lmg.rss.common.service.BaseManager;

/**
 * *********************************
 * 
 * @ClassName: BaseManagerImpl.java
 * @Description: 基础Manager实现
 * @author: luomingguo
 * @createdAt: 2015年6月2日下午3:43:06
 **********************************
 */
public class BaseManagerImpl<T> implements BaseManager<T> {
    @Autowired
    public BaseDAO<T> baseDAO;
    
    
    /**
     * @return the baseDAO
     */
    public BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }
    
    
    /**
     * @param baseDAO
     *            the baseDAO to set
     */
    public void setBaseDAO(BaseDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }
    
    
    /**
     * @Title: countAll
     * @Description: 返回总条数
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public Integer countAll() {
        return this.baseDAO.countAll();
    }
    
    
    /**
     * @Title: countByMap
     * @Description: 返回条件查询的条数
     * @param queryMap
     * @return
     * @createdBy:luomingguo
     * @createaAt:2015年6月5日下午3:18:17
     */
    @Override
    public Integer countByMap(Map<String, Object> queryMap) {
        return this.baseDAO.countByMap(queryMap);
    }
    
    
    /**
     * @Title: create
     * @Description: 新增
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public Integer create(T o) {
        return this.baseDAO.create(o);
    }
    
    
    /**
     * @Title: delete
     * @Description: 删除
     * @param id
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public Integer delete(Serializable id) {
        return this.baseDAO.delete(id);
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除
     * @param o
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月6日上午9:50:16
     */
    @Override
    public Integer delete(T o) {
        return this.baseDAO.delete(o);
    }
    
    
    /**
     * @Title: get
     * @Description: 查询
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public T get(Serializable id) {
        T t = this.baseDAO.get(id);
        return t;
    }
    
    
    /**
     * @Title: get
     * @Description: 查询
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public T get(T o) {
        T t = this.baseDAO.get(o);
        return t;
    }
    
    
    /**
     * @Title: load
     * @Description: 查询
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public T load(Serializable id) {
        return this.baseDAO.load(id);
    }
    
    
    /**
     * @Title: save
     * @Description: 保存
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public Integer save(T o) {
        return this.baseDAO.save(o);
    }
    
    
    /**
     * @Title: selectAll
     * @Description: 查询全部
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public List<T> selectAll() {
        return this.baseDAO.selectAll();
    }
    
    
    /**
     * @Title: selectByLike
     * @Description: like查询
     * @param queryMap
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public List<T> selectByLike(Map<String, Object> queryMap) {
        return this.baseDAO.selectByLike(queryMap);
    }
    
    
    /**
     * @Title: selectByMap
     * @Description: 查询
     * @param queryMap
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public List<T> selectByMap(Map<String, Object> queryMap) {
        return this.baseDAO.selectByMap(queryMap);
    }
    
    
    /**
     * @Title: selectByModel
     * @Description: 查询
     * @param o
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public List<T> selectByModel(T o) {
        return this.baseDAO.selectByModel(o);
    }
    
    
    /**
     * @Title: update
     * @Description: 更新
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:29:38
     */
    @Override
    public Integer update(T o) {
        return this.baseDAO.update(o);
    }
    
    
    /**
     * 
     * @Title: selectInPage
     * @Description: 分页查询
     * @param param
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月6日上午9:53:30
     */
    @Override
    public Map<String, Object> selectInPage(Map<String, Object> param) {
        Integer total = this.baseDAO.countByMap(param);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total.intValue());
        if (total.intValue() == 0){
            map.put("rows", new ArrayList<T>());
        } else{
            // 检查是否设置有分页参数
            if (!param.containsKey("start") || !param.containsKey("size")){
                param.put("start", 0);
                param.put("size", 15);
            }
            List<T> list = baseDAO.selectByMap(param);
            map.put("rows", list);
        }
        return map;
    }
    
    
    /**
     * 
     * @Title: selectByTree
     * @Description: 树形查询
     * @param param
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:24:44
     */
    @Override
    public List<T> selectByTree(Map<String, Object> param) {
        List<T> list = this.baseDAO.selectByMap(param);
        
        TreeParseImpl<T> treeParse = new TreeParseImpl<T>();
        return treeParse.getChildNodes(list);
    }
    
    
    @Override
    public T get(String conditionName, Object conditionValue) {
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(conditionName, conditionValue);
        return get(params);
    }
    
    
    @Override
    public T get(Serializable id, String conditionName, Object conditionValue) {
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(conditionName, conditionValue);
        return get(id, params);
    }
    
    
    @Override
    public T get(Serializable id, Map<String, Object> params) {
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        param.putAll(params);
        return get(params);
    }
    
    
    @Override
    public T get(Map<String, Object> params) {
        // Popular vote was to return null on 0 results and throw exception on
        // too many.
        final List<T> list = this.baseDAO.selectByMap(params);
        if (list.size() == 1){
            return convertObjectToDicValue(list.get(0));
        } else if (list.size() > 1){
            throw new TooManyResultsException("Expected one result (or null), but found: " + list.size());
        }
        
        return null;
    }
    
    
    protected T convertObjectToDicValue(T t) {
        return t;
    }
    
    
    protected List<T> convertListToDicValue(List<T> list) {
        return list;
    }
    
    
    /**
     * @Title: batchInsert
     * @Description: TODO
     * @param o
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:24:24
     */
    @Override
    public Integer batchInsert(List<T> o) {
        return this.baseDAO.batchInsert(o);
    }
    
}
