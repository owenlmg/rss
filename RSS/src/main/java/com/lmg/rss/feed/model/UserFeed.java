/**
 * @Title: UserFeedMapper.java
 * @Package com.lmg.rss.feed.model
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class UserFeed extends BaseModel {
    /**
     * @Fields serialVersionUID:序列
     */
    private static final long  serialVersionUID = 1L;
    
    /**
     * 表名
     */
    public final static String TABLE_NAME       = "USER_FEED";
    private java.lang.Integer  feedId;
    private java.lang.Integer  userId;
    private java.util.Date     subscribeTime;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public UserFeed() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param feedId
     * @param userId
     */
    public UserFeed(Integer userId, Integer feedId) {
        super();
        this.feedId = feedId;
        this.userId = userId;
    }
    
    
    public java.lang.Integer getFeedId() {
        return feedId;
    }
    
    
    public void setFeedId(java.lang.Integer feedId) {
        this.feedId = feedId;
    }
    
    
    public java.lang.Integer getUserId() {
        return userId;
    }
    
    
    public void setUserId(java.lang.Integer userId) {
        this.userId = userId;
    }
    
    
    public java.util.Date getSubscribeTime() {
        return subscribeTime;
    }
    
    
    public void setSubscribeTime(java.util.Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
    
    
    @Override
    public String toString() {
        return "USER_FEED [feedId= " + feedId + ", userId= " + userId + ", subscribeTime= " + subscribeTime + "]";
    }
}
