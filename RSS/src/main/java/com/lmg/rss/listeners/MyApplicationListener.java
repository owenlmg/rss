/**
 * @Title: MyApplicationListener.java
 * @Package com.lmg.springboot.listeners
 */
package com.lmg.rss.listeners;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/***********************************
 * @ClassName: MyApplicationListener.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月7日下午3:39:48
 ***********************************/

public class MyApplicationListener implements ApplicationListener<ApplicationFailedEvent> {
    
    /**
     * @Title: onApplicationEvent
     * @Description: TODO
     * @param event
     * @createdBy:Luomingguo
     * @createaAt:2017年11月7日下午3:40:01
     */
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("event:" + event);
        
    }
    
}
