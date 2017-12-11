package com.lmg.rss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx")
@EnableConfigurationProperties
public class ClientExampleAnnotationConfig {
    String url;
    String appId;
    
    
    public String getUrl() {
        return url;
    }
    
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String getAppId() {
        return appId;
    }
    
    
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
}
