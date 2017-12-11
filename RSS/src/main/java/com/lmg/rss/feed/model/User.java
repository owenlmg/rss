/**
 * @Title: UserMapper.java
 * @Package com.lmg.rss.feed.model 
 */
package com.lmg.rss.feed.model;

import com.lmg.rss.common.model.BaseModel;

public class User extends BaseModel {
    /**
     * @Fields serialVersionUID:序列 
     */
    private static final long serialVersionUID = 1L;
    
    /**
    *表名
    */
    public final static String TABLE_NAME ="USER";
    /**
    *账号
    */
    private java.lang.String loginName;
    /**
    *密码
    */
    private java.lang.String loginPass;
    private java.lang.String nickname;
    private java.lang.String openId;
    private java.lang.String sessionKey;
    private java.lang.String session;
    private java.lang.Integer sex;
    private java.lang.String headImgUrl;
    private java.lang.String city;
    private java.lang.String province;
    private java.lang.String country;
    private java.lang.String language;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp lastUseTime;

 
 
     /**
    *set loginName:账号
    */

    public java.lang.String getLoginName(){
        return loginName;
    }    
    public void  setLoginName(java.lang.String  loginName){
        this.loginName = loginName;
    }

    /**
    *set loginPass:密码
    */

    public java.lang.String getLoginPass(){
        return loginPass;
    }    
    public void  setLoginPass(java.lang.String  loginPass){
        this.loginPass = loginPass;
    }


    public java.lang.String getNickname(){
        return nickname;
    }    
    public void  setNickname(java.lang.String  nickname){
        this.nickname = nickname;
    }


    public java.lang.String getOpenId(){
        return openId;
    }    
    public void  setOpenId(java.lang.String  openId){
        this.openId = openId;
    }


    public java.lang.String getSessionKey(){
        return sessionKey;
    }    
    public void  setSessionKey(java.lang.String  sessionKey){
        this.sessionKey = sessionKey;
    }


    public java.lang.String getSession(){
        return session;
    }    
    public void  setSession(java.lang.String  session){
        this.session = session;
    }


    public java.lang.Integer getSex(){
        return sex;
    }    
    public void  setSex(java.lang.Integer  sex){
        this.sex = sex;
    }


    public java.lang.String getHeadImgUrl(){
        return headImgUrl;
    }    
    public void  setHeadImgUrl(java.lang.String  headImgUrl){
        this.headImgUrl = headImgUrl;
    }


    public java.lang.String getCity(){
        return city;
    }    
    public void  setCity(java.lang.String  city){
        this.city = city;
    }


    public java.lang.String getProvince(){
        return province;
    }    
    public void  setProvince(java.lang.String  province){
        this.province = province;
    }


    public java.lang.String getCountry(){
        return country;
    }    
    public void  setCountry(java.lang.String  country){
        this.country = country;
    }


    public java.lang.String getLanguage(){
        return language;
    }    
    public void  setLanguage(java.lang.String  language){
        this.language = language;
    }


    public java.sql.Timestamp getCreateTime(){
        return createTime;
    }    
    public void  setCreateTime(java.sql.Timestamp  createTime){
        this.createTime = createTime;
    }


    public java.sql.Timestamp getLastUseTime(){
        return lastUseTime;
    }    
    public void  setLastUseTime(java.sql.Timestamp  lastUseTime){
        this.lastUseTime = lastUseTime;
    }


 
     @Override
    public String toString() {
        return "USER [loginName= " + loginName + ", loginPass= " + loginPass + ", nickname= " + nickname + ", openId= " + openId + ", sessionKey= " + sessionKey + ", session= " + session + ", sex= " + sex + ", headImgUrl= " + headImgUrl + ", city= " + city + ", province= " + province + ", country= " + country + ", language= " + language + ", createTime= " + createTime + ", lastUseTime= " + lastUseTime + "]";
    }
}

