/**
 * @Title: FeedMapper.java
 * @Package com.lmg.rss.feed.model 
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class Feed extends BaseModel {
    /**
     * @Fields serialVersionUID:序列 
     */
    private static final long serialVersionUID = 1L;
    
    /**
    *表名
    */
    public final static String TABLE_NAME ="FEED";
    /**
    *标题
    */
    private java.lang.String title;
    /**
    *rss链接
    */
    private java.lang.String link;
    private java.lang.String url;
    private java.lang.Integer imageId;
    private java.lang.String language;
    private java.lang.String rating;
    private java.lang.String copyright;
    private java.lang.String generator;
    private java.lang.Integer ttl;
    /**
    *类型
    */
    private java.lang.Integer rssType;
    /**
    *最近一次更新时间
    */
    private java.sql.Timestamp lastUpdDate;
    /**
    *被使用次数
    */
    private java.lang.Integer referCount;
    /**
    *更新周期
    */
    private java.lang.Integer updCycle;
    private java.lang.String description;
    private java.lang.Integer udpCycle;

 
 
     /**
    *set title:标题
    */

    public java.lang.String getTitle(){
        return title;
    }    
    public void  setTitle(java.lang.String  title){
        this.title = title;
    }

    /**
    *set link:rss链接
    */

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


    public java.lang.Integer getImageId(){
        return imageId;
    }    
    public void  setImageId(java.lang.Integer  imageId){
        this.imageId = imageId;
    }


    public java.lang.String getLanguage(){
        return language;
    }    
    public void  setLanguage(java.lang.String  language){
        this.language = language;
    }


    public java.lang.String getRating(){
        return rating;
    }    
    public void  setRating(java.lang.String  rating){
        this.rating = rating;
    }


    public java.lang.String getCopyright(){
        return copyright;
    }    
    public void  setCopyright(java.lang.String  copyright){
        this.copyright = copyright;
    }


    public java.lang.String getGenerator(){
        return generator;
    }    
    public void  setGenerator(java.lang.String  generator){
        this.generator = generator;
    }


    public java.lang.Integer getTtl(){
        return ttl;
    }    
    public void  setTtl(java.lang.Integer  ttl){
        this.ttl = ttl;
    }

    /**
    *set rssType:类型
    */

    public java.lang.Integer getRssType(){
        return rssType;
    }    
    public void  setRssType(java.lang.Integer  rssType){
        this.rssType = rssType;
    }

    /**
    *set lastUpdDate:最近一次更新时间
    */

    public java.sql.Timestamp getLastUpdDate(){
        return lastUpdDate;
    }    
    public void  setLastUpdDate(java.sql.Timestamp  lastUpdDate){
        this.lastUpdDate = lastUpdDate;
    }

    /**
    *set referCount:被使用次数
    */

    public java.lang.Integer getReferCount(){
        return referCount;
    }    
    public void  setReferCount(java.lang.Integer  referCount){
        this.referCount = referCount;
    }

    /**
    *set updCycle:更新周期
    */

    public java.lang.Integer getUpdCycle(){
        return updCycle;
    }    
    public void  setUpdCycle(java.lang.Integer  updCycle){
        this.updCycle = updCycle;
    }


    public java.lang.String getDescription(){
        return description;
    }    
    public void  setDescription(java.lang.String  description){
        this.description = description;
    }


    public java.lang.Integer getUdpCycle(){
        return udpCycle;
    }    
    public void  setUdpCycle(java.lang.Integer  udpCycle){
        this.udpCycle = udpCycle;
    }


 
     @Override
    public String toString() {
        return "FEED [title= " + title + ", link= " + link + ", url= " + url + ", imageId= " + imageId + ", language= " + language + ", rating= " + rating + ", copyright= " + copyright + ", generator= " + generator + ", ttl= " + ttl + ", rssType= " + rssType + ", lastUpdDate= " + lastUpdDate + ", referCount= " + referCount + ", updCycle= " + updCycle + ", description= " + description + ", udpCycle= " + udpCycle + "]";
    }
}

