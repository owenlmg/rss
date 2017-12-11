/**
 * @Title: BaseModel.java
 * @Package com.webgis.common.model
 */
package com.lmg.rss.common.model;

/**
 * *********************************
 * 
 * @ClassName: BaseModel.java
 * @Description: TODO
 * @author: luomingguo
 * @createdAt: 2015年6月2日下午3:39:42
 **********************************
 */
public class BaseModel implements java.io.Serializable {
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long   serialVersionUID = -186389957244441703L;
    
    protected java.lang.Integer id;
    
    protected String            orderBy;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public BaseModel() {
        super();
    }
    
    
    public java.lang.Integer getId() {
        return id;
    }
    
    
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    
    public String getOrderBy() {
        return orderBy;
    }
    
    
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    
}
