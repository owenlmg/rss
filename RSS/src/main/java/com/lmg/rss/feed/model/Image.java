/**
 * @Title: ImageMapper.java
 * @Package com.lmg.rss.feed.model 
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class Image extends BaseModel {
    /**
     * @Fields serialVersionUID:序列 
     */
    private static final long serialVersionUID = 1L;
    
    /**
    *表名
    */
    public final static String TABLE_NAME ="IMAGE";
    private java.lang.String title;
    private java.lang.String link;
    private java.lang.String url;
    private java.lang.String description;
    private java.lang.Integer feedId;

 
 
 
    public java.lang.String getTitle(){
        return title;
    }    
    public void  setTitle(java.lang.String  title){
        this.title = title;
    }


    public java.lang.String getLink(){
        return link;
    }    
    public void  setLink(java.lang.String  link){
        this.link = link;
    }


    public java.lang.String getUrl(){
        return url;
    }    
    public void  setUrl(java.lang.String  url){
        this.url = url;
    }


    public java.lang.String getDescription(){
        return description;
    }    
    public void  setDescription(java.lang.String  description){
        this.description = description;
    }


    public java.lang.Integer getFeedId(){
        return feedId;
    }    
    public void  setFeedId(java.lang.Integer  feedId){
        this.feedId = feedId;
    }


 
     @Override
    public String toString() {
        return "IMAGE [title= " + title + ", link= " + link + ", url= " + url + ", description= " + description + ", feedId= " + feedId + "]";
    }
}

