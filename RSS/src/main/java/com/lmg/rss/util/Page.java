package com.lmg.rss.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

/**
 * *********************************
 * 
 * @ClassName: Page.java
 * @Description: 对分页的基本数据进行一个简单的封装
 * @author: Luomingguo
 * @createdAt: 2015年10月9日上午11:39:51
 **********************************/
public class Page<T> extends RowBounds {
    
    private int                 start    = 1;                             // 页码，默认是第一页
    private int                 pageSize = 15;                            // 每页显示的记录数，默认是15
    private int                 totalRecord;                              // 总记录数
    private int                 totalPage;                                // 总页数
    private List<T>             results;                                  // 对应的当前页记录
    private int                 rowCount;
    private int                 currentPage;
    
    private Map<String, Object> params   = new HashMap<String, Object>(); // 其他的参数我们把它分装成一个Map对象
                                                                          
    
    public int getRowCount() {
        return rowCount;
    }
    
    
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        // 在设置总条数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        this.setTotalPage(totalPage);
    }
    
    
    public int getStart() {
        return start;
    }
    
    
    public void setStart(int start) {
        this.start = start;
    }
    
    
    public int getPageSize() {
        return pageSize;
    }
    
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
    public int getTotalPage() {
        return totalPage;
    }
    
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    
    public List<T> getResults() {
        return results;
    }
    
    
    public void setResults(List<T> results) {
        this.results = results;
    }
    
    
    public Map<String, Object> getParams() {
        return params;
    }
    
    
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    
    
    public int getTotalRecord() {
        return totalRecord;
    }
    
}
