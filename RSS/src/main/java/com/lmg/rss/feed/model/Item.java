/**
 * @Title: Rss.java
 * @Package com.lmg.springboot.feed.model
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
 * @ClassName: Rss.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午3:07:39
 ***********************************/

@Entity
@Table(name = "item")
public class Item implements Serializable {
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int               id;
    private int               feedId;
    private String            title;
    private String            link;
    private String            author;
    private String            category;
    private Timestamp         pubDate;
    private String            comments;
    private String            descriptionType;
    private String            descriptionValue;
    
    
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
    
    
    public String getLink() {
        return link;
    }
    
    
    public void setLink(String link) {
        this.link = link;
    }
    
    
    public String getAuthor() {
        return author;
    }
    
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    public String getCategory() {
        return category;
    }
    
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public Timestamp getPubDate() {
        return pubDate;
    }
    
    
    public void setPubDate(Timestamp pubDate) {
        this.pubDate = pubDate;
    }
    
    
    public String getComments() {
        return comments;
    }
    
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    public String getDescriptionType() {
        return descriptionType;
    }
    
    
    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }
    
    
    public String getDescriptionValue() {
        return descriptionValue;
    }
    
    
    public void setDescriptionValue(String descriptionValue) {
        this.descriptionValue = descriptionValue;
    }
    
}
