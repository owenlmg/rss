/**
 * @Title: User.java
 * @Package com.lmg.springboot.sys.model
 */
package com.lmg.rss.feed.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/***********************************
 * @ClassName: User.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月9日下午1:27:03
 ***********************************/

@Entity
@Table(name = "user")
public class User implements Serializable {
    
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer           id;
    private String            loginName;
    private String            loginPass;
    private String            nickname;
    private String            openId;
    private String            sessionKey;
    private String            session;
    private String            city;
    private String            province;
    private String            country;
    private String            language;
    
    private Integer           sex;
    private String            headImgUrl;
    private Timestamp         createTime;
    private Timestamp         lastUseTime;
    
    @ManyToMany
    @JoinTable(name = "user_feed", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "feed_id"))
    private Set<Feed>         feeds            = new HashSet<Feed>();
    
    @ManyToMany
    @JoinTable(name = "user_item", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item>         items            = new HashSet<Item>();
    
    
    public Integer getId() {
        return id;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getLoginName() {
        return loginName;
    }
    
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    
    public String getLoginPass() {
        return loginPass;
    }
    
    
    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
    
    
    public String getNickname() {
        return nickname;
    }
    
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
    public String getOpenId() {
        return openId;
    }
    
    
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    
    public Integer getSex() {
        return sex;
    }
    
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    
    public String getHeadImgUrl() {
        return headImgUrl;
    }
    
    
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    
    
    public Timestamp getCreateTime() {
        return createTime;
    }
    
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    
    public Timestamp getLastUseTime() {
        return lastUseTime;
    }
    
    
    public void setLastUseTime(Timestamp lastUseTime) {
        this.lastUseTime = lastUseTime;
    }
    
    
    public Set<Feed> getFeeds() {
        return feeds;
    }
    
    
    public void setFeeds(Set<Feed> feeds) {
        this.feeds = feeds;
    }
    
    
    public Set<Item> getItems() {
        return items;
    }
    
    
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    
    public String getSessionKey() {
        return sessionKey;
    }
    
    
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    
    
    public String getSession() {
        return session;
    }
    
    
    public void setSession(String session) {
        this.session = session;
    }
    
    
    public String getCity() {
        return city;
    }
    
    
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String getProvince() {
        return province;
    }
    
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    
    public String getCountry() {
        return country;
    }
    
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public String getLanguage() {
        return language;
    }
    
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", loginName=" + loginName + ", loginPass=" + loginPass + ", nickname=" + nickname
                + ", openId=" + openId + ", sex=" + sex + ", headImgUrl=" + headImgUrl + ", createTime=" + createTime
                + ", lastUseTime=" + lastUseTime + ", feeds=" + feeds + "]";
    }
    
}
