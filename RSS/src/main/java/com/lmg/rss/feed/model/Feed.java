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
@Table(name = "feed")
public class Feed implements Serializable {
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int               id;
    private String            title;
    private String            description;
    private int               imageId;
    private String            link;
    private String            url;
    private String            language;
    private String            rating;
    private String            copyright;
    private String            generator;
    private int               ttl;
    private int               rssType;
    private Timestamp         lastUpdDate;
    private int               referCount;
    private int               udpCycle;
    
    
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
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
    
    
    public int getImageId() {
        return imageId;
    }
    
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
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
    
    
    public String getLanguage() {
        return language;
    }
    
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    public String getRating() {
        return rating;
    }
    
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
    public String getCopyright() {
        return copyright;
    }
    
    
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    
    
    public String getGenerator() {
        return generator;
    }
    
    
    public void setGenerator(String generator) {
        this.generator = generator;
    }
    
    
    public int getTtl() {
        return ttl;
    }
    
    
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
    
    
    public int getRssType() {
        return rssType;
    }
    
    
    public void setRssType(int rssType) {
        this.rssType = rssType;
    }
    
    
    public Timestamp getLastUpdDate() {
        return lastUpdDate;
    }
    
    
    public void setLastUpdDate(Timestamp lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
    
    
    public int getReferCount() {
        return referCount;
    }
    
    
    public void setReferCount(int referCount) {
        this.referCount = referCount;
    }
    
    
    public int getUdpCycle() {
        return udpCycle;
    }
    
    
    public void setUdpCycle(int udpCycle) {
        this.udpCycle = udpCycle;
    }
    
    
    @Override
    public String toString() {
        return "Feed [id=" + id + ", title=" + title + ", description=" + description + ", imageId=" + imageId
                + ", link=" + link + ", url=" + url + ", language=" + language + ", rating=" + rating + ", copyright="
                + copyright + ", generator=" + generator + ", ttl=" + ttl + ", rssType=" + rssType + ", lastUpdDate="
                + lastUpdDate + ", referCount=" + referCount + ", udpCycle=" + udpCycle + "]";
    }
    
}
