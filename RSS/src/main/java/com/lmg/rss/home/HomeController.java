/**
 * @Title: HomeController.java
 * @Package com.lmg.springboot.controller
 */
package com.lmg.rss.home;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmg.rss.MyBean;

/***********************************
 * @ClassName: HomeController.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月6日下午1:35:07
 ***********************************/

@Controller
@RequestMapping("home")
public class HomeController {
    @Resource
    private StringRedisTemplate template;
    
    
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "hello");
        
        MyBean bean = new MyBean(template);
        bean.printRedis();
        return "welcome";
    }
    
    
    @RequestMapping("/about")
    @ResponseBody
    String about() {
        return "about";
    }
}
