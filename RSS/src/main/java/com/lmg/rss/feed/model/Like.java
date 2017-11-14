/**
 * @Title: UserFeed.java
 * @Package com.lmg.springboot.sys.model
 */
package com.lmg.rss.feed.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***********************************
 * @ClassName: UserFeed.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月9日下午1:27:03
 ***********************************/

@Entity
@Table(name = "like")
public class Like implements Serializable {
    
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;
    private Integer           userId;
    private Integer           itemId;
    private Timestamp         likeTime;
    
    
    public Integer getId() {
        return id;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Integer getUserId() {
        return userId;
    }
    
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    public Integer getItemId() {
        return itemId;
    }
    
    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    
    
    public Timestamp getLikeTime() {
        return likeTime;
    }
    
    
    public void setLikeTime(Timestamp likeTime) {
        this.likeTime = likeTime;
    }
    
}
