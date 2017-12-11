/**
 * @Title: SessionInterceptor.java
 * @Package com.jygps.common.interceptor
 */
package com.lmg.rss.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lmg.rss.feed.model.User;
import com.lmg.rss.feed.service.UserManager;
import com.lmg.rss.util.EnumConstants.MSG_CODE;
import com.lmg.rss.util.ResponseUtil;

/***********************************
 * @ClassName: SessionInterceptor.java
 * @Description: session超时检查
 * @author: Luomingguo
 * @createdAt: 2015年9月29日下午1:52:18
 ***********************************/
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private Environment         env;
    
    @Autowired
    private UserManager         userManager;
    
    private static List<String> allowUrls  = null;
    private final static String TOKEN      = "token";
    
    private final static String USERID_KEY = "userId";
    
    
    private void init() {
        allowUrls = new ArrayList<String>();
        String url = env.getProperty("session_not_check_url");
        if (url != null && !"".equals(url.trim())){
            String[] urls = url.split(",");
            for (String u : urls){
                allowUrls.add(u);
            }
        }
    }
    
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (allowUrls == null){
            init();
        }
        String requestUrl = request.getRequestURI();
        // 从 header 中得到 token
        String token = request.getHeader(TOKEN);
        if (token == null || "".equals(token)){
            token = request.getParameter(TOKEN);
            if (token == null){
                token = request.getAttribute(TOKEN) == null ? null : request.getAttribute(TOKEN).toString();
            }
        }
        
        // 排除
        for (String url : allowUrls){
            if (requestUrl.endsWith(url) || (url.indexOf("*") >= 0 && requestUrl.contains(url.replaceAll("[*]", "")))){
                return true;
            }
        }
        if (token != null){
            // 验证存在
            User user = new User();
            user.setSession(token);
            List<User> users = userManager.selectByModel(user);
            if (users.size() > 0){
                user = users.get(0);
                request.setAttribute(USERID_KEY, user.getId());
                return true;
            }
        }
        ResponseUtil.writeJson(response, "{\"code\":" + MSG_CODE.session验证失败.getValue() + ",\"msg\":\""
                + MSG_CODE.session验证失败 + "\"}");
        return false;
    }
    
}
