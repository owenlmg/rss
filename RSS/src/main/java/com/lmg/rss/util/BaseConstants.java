package com.lmg.rss.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BaseConstants implements Serializable {
    
    private static final long             serialVersionUID = 4970120605013956942L;
    public static HashMap<String, String> propMap          = new HashMap<String, String>();
    public static String                  EMPTY_STR        = "";
    private static String                 configFile       = "classpath*:conf.properties";
    private static List<String>           configFiles      = null;
    
    
    public BaseConstants() {
        if (!propMap.isEmpty()){
            parseConfigProperties();
        }
    }
    
    static{
        // 加载默认配置
        loadConfigFile();
        loadConfigFiles();
    }
    
    
    /**
     * 
     * @Title: loadConfigFile
     * @Description: 加载单配置文件
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午9:57:53
     */
    private static boolean loadConfigFile() {
        try{
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(configFile);
            if (resources == null){
                return false;
            }
            
            Properties p = new Properties();
            for (Resource r : resources){
                if (r != null){
                    p.load(r.getInputStream());
                    mergeProperties(p);
                }
            }
        } catch (IOException e1){
            e1.printStackTrace();
        }
        return true;
    }
    
    
    /**
     * 
     * @Title: loadConfigFiles
     * @Description: 加载多配置文件
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午9:58:02
     */
    private static boolean loadConfigFiles() {
        if (configFiles == null){
            return false;
        }
        
        try{
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            List<Resource> resources = new ArrayList<Resource>();
            for (int idx = 0; idx < configFiles.size(); idx++){
                Resource[] tempResoureArr = resolver.getResources(configFiles.get(idx));
                if (tempResoureArr != null){
                    for (int i = 0; i < tempResoureArr.length; i++){
                        if (tempResoureArr[i] != null){
                            resources.add(tempResoureArr[i]);
                        }
                    }
                }
            }
            Properties p = new Properties();
            for (Resource r : resources){
                if (r != null){
                    p.load(r.getInputStream());
                    mergeProperties(p);
                }
            }
        } catch (IOException e1){
            e1.printStackTrace();
        }
        return true;
    }
    
    
    /**
     * 
     * @Title: mergeProperties
     * @Description: 合并配置
     * @param p
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午9:58:11
     */
    private static void mergeProperties(Properties p) {
        Set<Entry<Object, Object>> entrySet = p.entrySet();
        for (Entry<Object, Object> entry : entrySet){
            if (entry.getKey() != null){
                propMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
    
    
    /**
     * 
     * @Title: get
     * @Description: 获取配置
     * @param key
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午10:06:36
     */
    public static String get(String key) {
        String v = propMap.get(key);
        if (v != null){
            return v.trim();
        }
        return null;
    }
    
    
    /**
     * 
     * @Title: get
     * @Description: 获取配置，如果不存在，使用默认值
     * @param key
     * @param defaultValue
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午10:06:45
     */
    public static String get(String key, String defaultValue) {
        String v = propMap.get(key);
        if (v == null || EMPTY_STR.equals(v.trim())){
            return defaultValue;
        }
        return v.trim();
    }
    
    
    /**
     * 
     * @Title: get
     * @Description: 获取配置，如果不存在，使用默认值
     * @param key
     * @param defaultValue
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午10:06:45
     */
    public static int get(String key, int defaultValue) {
        String v = propMap.get(key);
        if (v == null || EMPTY_STR.equals(v.trim()) || !StringUtil.isNumeric(v.trim(), true)){
            return defaultValue;
        }
        return Integer.parseInt(v.trim());
    }
    
    
    /**
     * 
     * @Title: getMap
     * @Description: 获取配置，以Map方式返回
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午10:07:04
     */
    public static HashMap<String, String> getMap() {
        return propMap;
    }
    
    
    /**
     * 
     * @Title: parseConfigProperties
     * @Description: 解析配置
     * @createdBy:Luomingguo
     * @createaAt:2015年10月10日上午9:59:19
     */
    public void parseConfigProperties() {
    };
}
