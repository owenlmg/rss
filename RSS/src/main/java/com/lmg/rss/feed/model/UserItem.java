/**
 * @Title: UserItemMapper.java
 * @Package com.lmg.rss.feed.model
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class UserItem extends BaseModel {
    /**
     * @Fields serialVersionUID:序列
     */
    private static final long  serialVersionUID = 1L;
    
    /**
     * 表名
     */
    public final static String TABLE_NAME       = "USER_ITEM";
    private java.lang.Integer  userId;
    private java.lang.Integer  itemId;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param userId2
     * @param itemId2
     */
    public UserItem(Integer userId, Integer itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }
    
    
    public java.lang.Integer getUserId() {
        return userId;
    }
    
    
    public void setUserId(java.lang.Integer userId) {
        this.userId = userId;
    }
    
    
    public java.lang.Integer getItemId() {
        return itemId;
    }
    
    
    public void setItemId(java.lang.Integer itemId) {
        this.itemId = itemId;
    }
    
    
    @Override
    public String toString() {
        return "USER_ITEM [userId= " + userId + ", itemId= " + itemId + "]";
    }
}
