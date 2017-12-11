/**
 * @Title: EnumConstants.java
 * @Package webgis.util
 */
package com.lmg.rss.util;

/***********************************
 * @ClassName: EnumConstants.java
 * @Description: 状态枚举
 * @author: Luomingguo
 * @createdAt: 2016年8月8日下午5:16:51
 ***********************************/

public interface EnumConstants {
    /**
     * *********************************
     * 
     * @ClassName: EnumConstants.java
     * @Description: 定位状态
     * @author: Luomingguo
     * @createdAt: 2016年8月8日下午5:19:43
     **********************************
     */
    public enum MSG_CODE {
        session验证失败(1000);
        
        private final int value;
        
        
        MSG_CODE(int value) {
            this.value = value;
        }
        
        
        public int getValue() {
            return this.value;
        }
        
        
        public String getStrValue() {
            return String.valueOf(this.value);
        }
    }
}
