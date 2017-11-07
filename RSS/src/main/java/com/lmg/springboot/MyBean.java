/**
 * @Title: MyBean.java
 * @Package com.lmg.springboot
 */
package com.lmg.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/***********************************
 * @ClassName: MyBean.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午3:43:27
 ***********************************/

@Component
public class MyBean {
    private StringRedisTemplate template;
    
    
    @Autowired
    public MyBean(StringRedisTemplate template) {
        this.template = template;
    }
    
    
    public void getVehicleMap() {
        Object object = template.opsForHash().entries("vehiclemap");
        System.out.println(object);
    }
    
    
    public void printRedis() {
        Object object = template.opsForHash().get("vehiclemap", "21052");
        System.out.println(object);
    }
}
