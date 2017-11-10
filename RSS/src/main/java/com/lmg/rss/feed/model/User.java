/**
 * @Title: User.java
 * @Package com.lmg.springboot.sys.model
 */
package com.lmg.rss.feed.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer           id;
    private String            loginName;
    private String            loginPass;
    private String            nickname;
    private String            openId;
    private Integer           sex;
    private String            headImgUrl;
    private Timestamp         createTime;
    private Timestamp         lastUseTime;
    
    
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
    
}
