package com.lmg.rss.util;

import java.io.Serializable;
import java.util.Map;

/**
 * *********************************
 * 
 * @ClassName: Resp.java
 * @Description: 响应
 * @author: Luomingguo
 * @createdAt: 2015年10月14日下午2:25:43
 **********************************
 */
public class Result<T> implements Serializable {
    
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;
    
    
    /**
     * 生成成功返回对象
     * 
     * @param msg
     * @return
     */
    public static <T> Result<T> success(T msg) {
        Result<T> resp = new Result<T>();
        resp.setCode(1);
        resp.setMsg(msg);
        return resp;
    }
    
    
    /**
     * 生成成功返回对象 (登录)
     * 
     * @param msg
     * @return
     */
    public static <T> Result<T> success(T msg, String token) {
        Result<T> resp = new Result<T>();
        resp.setCode(1);
        resp.setMsg(msg);
        resp.setToken(token);
        return resp;
    }
    
    
    /**
     * 生成失败返回对象
     * 
     * @param msg
     * @return
     */
    public static Result<String> fail(String msg) {
        Result<String> resp = new Result<String>();
        resp.setCode(-1);
        resp.setMsg(msg);
        return resp;
    }
    
    
    public static Result<String> fail(String msg, Map<String, Object> extendMsg) {
        Result<String> resp = new Result<String>();
        resp.setCode(-1);
        resp.setMsg(msg);
        resp.setExtendMsg(extendMsg);
        return resp;
    }
    
    /** 响应代码 */
    private Integer             code;
    
    /** 响应消息 */
    private T                   msg;
    
    /** Token */
    private String              token;
    
    /** 附加消息 */
    private Map<String, Object> extendMsg;
    
    /** 成功次数 */
    private Integer             successCount;
    
    /** 总次数 */
    private Integer             total;
    
    private Map<String, Object> data;
    
    
    /**
     * @return the data
     */
    public Map<String, Object> getData() {
        return data;
    }
    
    
    /**
     * @param data
     *            the data to set
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    
    /**
     * @return the successCount
     */
    public Integer getSuccessCount() {
        return successCount;
    }
    
    
    /**
     * @param successCount
     *            the successCount to set
     */
    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }
    
    
    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }
    
    
    /**
     * @param total
     *            the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    public Integer getCode() {
        return code;
    }
    
    
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }
    
    
    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    
    public T getMsg() {
        return msg;
    }
    
    
    public void setMsg(T msg) {
        this.msg = msg;
    }
    
    
    public Map<String, Object> getExtendMsg() {
        return extendMsg;
    }
    
    
    public void setExtendMsg(Map<String, Object> extendMsg) {
        this.extendMsg = extendMsg;
    }
    
    
    public boolean isOk() {
        return this.code == 1;
    }
    
}
