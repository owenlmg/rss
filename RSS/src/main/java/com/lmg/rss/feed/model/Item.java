/**
 * @Title: ItemMapper.java
 * @Package com.lmg.rss.feed.model
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class Item extends BaseModel {
    /**
     * @Fields serialVersionUID:序列
     */
    private static final long  serialVersionUID = 1L;
    
    /**
     * 表名
     */
    public final static String TABLE_NAME       = "ITEM";
    private java.lang.String   title;
    private java.lang.String   link;
    private java.lang.String   author;
    private java.lang.String   category;
    private java.sql.Timestamp pubDate;
    private java.lang.String   comments;
    private java.lang.String   descriptionType;
    private java.lang.String   descriptionValue;
    private java.lang.Integer  feedId;
    private java.lang.String   firstImg;
    private java.lang.String   pubDateStr;
    private java.lang.String   feedName;
    
    
    public java.lang.String getTitle() {
        return title;
    }
    
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    
    public java.lang.String getLink() {
        return link;
    }
    
    
    public void setLink(java.lang.String link) {
        this.link = link;
    }
    
    
    public java.lang.String getAuthor() {
        return author;
    }
    
    
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }
    
    
    public java.lang.String getCategory() {
        return category;
    }
    
    
    public void setCategory(java.lang.String category) {
        this.category = category;
    }
    
    
    public java.sql.Timestamp getPubDate() {
        return pubDate;
    }
    
    
    public void setPubDate(java.sql.Timestamp pubDate) {
        this.pubDate = pubDate;
    }
    
    
    public java.lang.String getComments() {
        return comments;
    }
    
    
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }
    
    
    public java.lang.String getDescriptionType() {
        return descriptionType;
    }
    
    
    public void setDescriptionType(java.lang.String descriptionType) {
        this.descriptionType = descriptionType;
    }
    
    
    public java.lang.String getDescriptionValue() {
        return descriptionValue;
    }
    
    
    public void setDescriptionValue(java.lang.String descriptionValue) {
        this.descriptionValue = descriptionValue;
    }
    
    
    public java.lang.Integer getFeedId() {
        return feedId;
    }
    
    
    public void setFeedId(java.lang.Integer feedId) {
        this.feedId = feedId;
    }
    
    
    public java.lang.String getFirstImg() {
        return firstImg;
    }
    
    
    public void setFirstImg(java.lang.String firstImg) {
        this.firstImg = firstImg;
    }
    
    
    public java.lang.String getPubDateStr() {
        return pubDateStr;
    }
    
    
    public void setPubDateStr(java.lang.String pubDateStr) {
        this.pubDateStr = pubDateStr;
    }
    
    
    public java.lang.String getFeedName() {
        return feedName;
    }
    
    
    public void setFeedName(java.lang.String feedName) {
        this.feedName = feedName;
    }
    
    
    @Override
    public String toString() {
        return "ITEM [title= " + title + ", link= " + link + ", author= " + author + ", category= " + category
                + ", pubDate= " + pubDate + ", comments= " + comments + ", descriptionType= " + descriptionType
                + ", descriptionValue= " + descriptionValue + ", feedId= " + feedId + ", firstImg= " + firstImg
                + ", pubDateStr= " + pubDateStr + ", feedName= " + feedName + "]";
    }
}
