/**
 * @Title: BaseDAOImpl.java
 * @Package com.webgis.common.dao.impl
 */
package com.lmg.rss.common.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lmg.rss.common.dao.BaseDAO;
import com.lmg.rss.config.MyBatisConfig;
import com.lmg.rss.util.GenericsUtils;

/**
 * *********************************
 * 
 * @ClassName: BaseDAOImpl.java
 * @Description: 基础DAO
 * @author: luomingguo
 * @createdAt: 2015年6月2日下午3:42:49
 **********************************
 */
@SuppressWarnings("static-access")
public class BaseDAOImpl<T> extends SqlSessionDaoSupport implements BaseDAO<T> {
    protected SqlSession       sqlSession;
    public static final String SQLNAME_SEPARATOR  = ".";
    
    public static final String SQL_GET            = "get";
    public static final String SQL_SAVE           = "insert";
    public static final String SQL_UPDATE         = "update";
    public static final String SQL_DELETE         = "delete";
    public static final String SQL_COUNTALL       = "countAll";
    public static final String SQL_SELECTALL      = "selectAll";
    public static final String SQL_SELECTBYLIKE   = "selectByLike";
    public static final String SQL_SELECTBYMAP    = "selectByMap";
    public static final String SQL_SELECTBYMODEL  = "selectByModel";
    public static final String SQL_UPDATEBYFIELDS = "updateByFields";
    public static final String SQL_COUNTBYMAP     = "countByMap";
    public static final String SQL_BATCH_INSERT   = "batchInsert";
    
    /**
     * DAO所管理的Entity类型.
     */
    protected Class<T>         entityClass;
    
    protected String           primaryKeyName;
    
    protected String           sqlMapNamespace;
    
    
    @SuppressWarnings("unchecked")
    public BaseDAOImpl() {
        // 获取泛型类型
        entityClass = GenericsUtils.getSuperClassGenricType(getClass());
        sqlMapNamespace = entityClass.getName();
        
        MyBatisConfig myBatisConfig = new MyBatisConfig();
        sqlSession = myBatisConfig.sqlSessionTemplate(myBatisConfig.sqlSessionFactoryBean());
    }
    
    
    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    
    /**
     * @Title: countAll
     * @Description: 返回总条数
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public Integer countAll() {
        return (Integer) this.getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR
                + this.SQL_COUNTALL, new HashMap<String, Object>());
    }
    
    
    /**
     * @Title: create
     * @Description: 新增
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public Integer create(T o) {
        return this.getSqlSession().insert(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SAVE, o);
    }
    
    
    /**
     * @Title: delete
     * @Description: 删除
     * @param id
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public Integer delete(Serializable id) {
        return this.getSqlSession().delete(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_DELETE, id);
    }
    
    
    /**
     * 
     * @Title: delete
     * @Description: 删除
     * @param o
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月6日上午9:41:12
     */
    @Override
    public Integer delete(T o) {
        return this.getSqlSession().delete(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_DELETE, o);
    }
    
    
    /**
     * @Title: get
     * @Description: 根据ID获取一行
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public T get(Serializable id) {
        T t = this.getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_GET, id);
        return t;
    }
    
    
    /**
     * @Title: get
     * @Description: 根据ID获取一行
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public T get(T o) {
        T t = this.getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_GET, o);
        return t;
    }
    
    
    /**
     * @Title: load
     * @Description: 根据ID获取一行
     * @param id
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public T load(Serializable id) {
        return this.getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_GET, id);
    }
    
    
    /**
     * @Title: save
     * @Description: 保存
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public Integer save(T o) {
        return this.getSqlSession().insert(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SAVE, o);
    }
    
    
    /**
     * @Title: selectAll
     * @Description: 查询所有数据 慎用 无分页
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public List<T> selectAll() {
        return this.getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SELECTALL, new HashMap<String, Object>());
    }
    
    
    /**
     * @Title: selectByLike
     * @Description: like查询
     * @param querymap
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public List<T> selectByLike(Map<String, Object> queryMap) {
        return this.getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SELECTBYLIKE, queryMap);
    }
    
    
    /**
     * @Title: selectByMap
     * @Description: 分页查询
     * @param querymap
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public List<T> selectByMap(Map<String, Object> queryMap) {
        if (queryMap.containsKey("start") && queryMap.containsKey("size")){
            RowBounds rowBounds = getRowBounds(queryMap);
            return this.getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SELECTBYMAP, queryMap, rowBounds);
        } else{
            return this.getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SELECTBYMAP, queryMap);
        }
    }
    
    
    /**
     * @Title: selectByModel
     * @Description: 查询
     * @param o
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public List<T> selectByModel(T o) {
        return this.getSqlSession().selectList(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_SELECTBYMODEL, o);
    }
    
    
    /**
     * @Title: update
     * @Description: 更新
     * @param o
     * @createdBy:luomingguo
     * @createaAt:2014-8-29下午07:19:21
     */
    @Override
    public Integer update(T o) {
        return this.getSqlSession().update(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_UPDATE, o);
    }
    
    
    /**
     * 
     * @Title: countByMap
     * @Description: 根据条件返回总条数
     * @param param
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年11月6日上午9:44:42
     */
    @Override
    public Integer countByMap(Map<String, Object> param) {
        return this.getSqlSession().selectOne(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_COUNTBYMAP, param);
    }
    
    
    private RowBounds getRowBounds(Map<String, Object> param) {
        int start = 0;
        int size = 15;
        if (!param.containsKey("start")){
            param.put("start", start);
        }
        if (!param.containsKey("size")){
            param.put("size", size);
        }
        return new RowBounds(Integer.valueOf(param.get("start").toString()),
                Integer.valueOf(param.get("size").toString()));
    }
    
    
    /**
     * @Title: batchInsert
     * @Description: TODO
     * @param o
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年12月8日上午11:22:46
     */
    @Override
    public Integer batchInsert(List<T> o) {
        return this.getSqlSession().insert(this.sqlMapNamespace + this.SQLNAME_SEPARATOR + this.SQL_BATCH_INSERT, o);
    }
}
