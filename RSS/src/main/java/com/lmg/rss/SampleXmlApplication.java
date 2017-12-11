package com.lmg.rss;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.lmg.rss.config.ClientExampleAnnotationConfig;

@SpringBootApplication
@EnableConfigurationProperties
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SampleXmlApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(SampleXmlApplication.class, args);
        System.out.println(new ClientExampleAnnotationConfig().getAppId());
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        System.out.println();
    }
    
}
