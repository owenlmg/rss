package com.lmg.rss.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *********************************
 * 
 * @ClassName: DataSourceConfig.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月30日下午2:09:04
 **********************************
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@EnableConfigurationProperties
public class DataSourceConfig {
    
    // @Bean
    public DataSourceProperties dataSourceProperties() {
        DataSourceProperties properties = new DataSourceProperties();
        // properties.setUrl(ev.getProperty("spring.datasource.url"));
        // properties.setUsername(ev.getProperty("spring.datasource.username"));
        // properties.setPassword(ev.getProperty("spring.datasource.password"));
        // properties.setDriverClassName(ev.getProperty("spring.datasource.driver-class-name"));
        
        return properties;
    }
    
    
    @Bean
    public DataSource getDataSource() {
        // return
        // dataSourceProperties().initializeDataSourceBuilder().create().build();
        // return
        // return
        // dataSourceProperties().initializeDataSourceBuilder().create().build();
        return DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/rss?useUnicode=true&characterEncoding=UTF-8").username("root").password("").driverClassName("com.mysql.jdbc.Driver").build();
    }
    
}
