/**
 * @Title: Rss.java
 * @Package com.lmg.springboot.feed.model
 */
package com.lmg.rss.feed.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***********************************
 * @ClassName: Rss.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午3:07:39
 ***********************************/

@Entity
@Table(name = "image")
public class Image implements Serializable {
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int               id;
    private int               feedId;
    private String            title;
    private String            description;
    private String            link;
    private String            url;
    
    
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getFeedId() {
        return feedId;
    }
    
    
    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }
    
    
    public String getTitle() {
        return title;
    }
    
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public String getDescription() {
        return description;
    }
    
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public String getLink() {
        return link;
    }
    
    
    public void setLink(String link) {
        this.link = link;
    }
    
    
    public String getUrl() {
        return url;
    }
    
    
    public void setUrl(String url) {
        this.url = url;
    }
    
}
