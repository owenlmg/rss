package com.lmg.rss.interceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lmg.rss.listeners.SessionInterceptor;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
    
    /**
     * 
     * @Title: getSessionInterceptor
     * @Description: 拦截器加载的时间点在springcontext之前，所以在Interceptor中无法注入，使用@Bean注解提前加载
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月29日上午9:46:06
     */
    @Bean
    public HandlerInterceptor getSessionInterceptor() {
        return new SessionInterceptor();
    }
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(getSessionInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns("/**.html");
        
        // 还可以在这里注册其它的拦截器
        // registry.addInterceptor(new
        // OtherInterceptor()).addPathPatterns("/**");
    }
}
