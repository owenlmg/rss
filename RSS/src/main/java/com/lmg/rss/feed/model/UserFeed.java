/**
 * @Title: UserFeed.java
 * @Package com.lmg.springboot.sys.model
 */
package com.lmg.rss.feed.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/***********************************
 * @ClassName: UserFeed.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月9日下午1:27:03
 ***********************************/

@Entity
@Table(name = "user_feed")
@IdClass(UserFeedPK.class)
public class UserFeed implements Serializable {
    
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer           userId;
    @Id
    private Integer           feedId;
    private Timestamp         subscribeTime;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public UserFeed(Integer userId, Integer feedId) {
        this.userId = userId;
        this.feedId = feedId;
        this.subscribeTime = new Timestamp(System.currentTimeMillis());
    }
    
    
    public Integer getUserId() {
        return userId;
    }
    
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    public Integer getFeedId() {
        return feedId;
    }
    
    
    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }
    
    
    public Timestamp getSubscribeTime() {
        return subscribeTime;
    }
    
    
    public void setSubscribeTime(Timestamp subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
    
}
