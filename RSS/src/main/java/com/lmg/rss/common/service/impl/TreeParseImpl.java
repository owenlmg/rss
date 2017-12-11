/**
 * @Title: TreeParseImpl.java
 * @Package com.webgis.common.web
 */
package com.lmg.rss.common.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**********************************
 * 
 * @ClassName: TreeParseImpl.java
 * @Description: 解析树形结构
 * @author: luomingguo
 * @createdAt: 2014年10月16日下午4:49:06
 **********************************/
public class TreeParseImpl<T> {
    
    /**
     * 
     * @Title: getChildNodes
     * @Description: 获取所有子节点
     * @param list
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:20
     */
    public List<T> getChildNodes(List<T> list) {
        return getChildNodes(list, 0L);
    }
    
    
    /**
     * 
     * @Title: getChildNodes
     * @Description: 根据父节点的ID获取所有子节点
     * @param list
     * @param typeId
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:28
     */
    public List<T> getChildNodes(List<T> list, Long typeId) {
        List<T> returnList = new ArrayList<T>();
        
        if (list == null && typeId == null){
            return returnList;
        }
        
        // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
        if (typeId > 0){
            for (Iterator<T> iterator = list.iterator(); iterator.hasNext();){
                T node = (T) iterator.next();
                Long parent = methodGetParent(node);
                if (typeId == parent){
                    recursionFn(list, node);
                    returnList.add(node);
                }
            }
        } else{
            for (Iterator<T> iterator = list.iterator(); iterator.hasNext();){
                T node = (T) iterator.next();
                Long parent = methodGetParent(node);
                // 二、遍历所有的父节点下的所有子节点
                if (parent == 0){
                    recursionFn(list, node);
                    returnList.add(node);
                }
            }
        }
        return returnList;
    }
    
    
    /**
     * 
     * @Title: recursionFn
     * @Description: 递归处理
     * @param list
     * @param node
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:33
     */
    private void recursionFn(List<T> list, T node) {
        List<T> childList = getChildList(list, node);// 得到子节点列表
        methodSetChildren(node, childList);
        
        if (hasChild(list, node)){// 判断是否有子节点
            Iterator<T> it = childList.iterator();
            while (it.hasNext()){
                T n = (T) it.next();
                recursionFn(list, n);
            }
        }
    }
    
    
    /**
     * 
     * @Title: getChildList
     * @Description: 得到子节点列表
     * @param list
     * @param node
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:39
     */
    private List<T> getChildList(List<T> list, T node) {
        List<T> nodeList = new ArrayList<T>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()){
            T n = (T) it.next();
            Long parent = methodGetParent(n);
            Long id = methodGetId(node);
            if (parent != null && id != null && parent.longValue() == id.longValue()){
                nodeList.add(n);
            }
        }
        return nodeList;
    }
    
    
    /**
     * 
     * @Title: hasChild
     * @Description: 判断是否有子节点
     * @param list
     * @param node
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:45
     */
    private boolean hasChild(List<T> list, T node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }
    
    
    /**
     * 
     * @Title: methodGetParent
     * @Description: 执行getParent方法
     * @param t
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:43:15
     */
    private Long methodGetParent(T t) {
        Method getParent;
        try{
            getParent = t.getClass().getDeclaredMethod("getParentId");
            Object gp = getParent.invoke(t);
            if (gp == null){
                return 0L;
            } else if ("".equals(gp.toString())){
                return 0L;
            } else{
                return Long.parseLong(gp.toString());
            }
        } catch (SecurityException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
        
    }
    
    
    /**
     * 
     * @Title: methodGetId
     * @Description: 执行getId方法
     * @param t
     * @return
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:43:50
     */
    private Long methodGetId(T t) {
        Method getParent;
        try{
            getParent = t.getClass().getSuperclass().getDeclaredMethod("getId");
            Object gp = getParent.invoke(t);
            if (gp == null){
                return null;
            } else if ("".equals(gp.toString())){
                return 0L;
            } else{
                return Long.parseLong(gp.toString());
            }
        } catch (SecurityException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
        
    }
    
    
    /**
     * 
     * @Title: methodSetChildren
     * @Description: 执行setChildren方法
     * @param t
     * @param list
     * @createdBy:luomingguo
     * @createaAt:2014年10月16日下午4:44:04
     */
    private void methodSetChildren(T t, List<T> list) {
        Method setChildren;
        try{
            setChildren = t.getClass().getSuperclass().getDeclaredMethod("setChildren", List.class);
            setChildren.invoke(t, list);
        } catch (SecurityException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
    
}
