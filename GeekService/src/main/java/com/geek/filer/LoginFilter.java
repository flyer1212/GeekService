package com.geek.filer;


import com.geek.entity.User;
import com.geek.redis.RedisClient;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@Order(1)
// 这里的@Order 不能放在前面，也不能和@Component 和 @Configuration 一起使用
//@WebFilter(filterName = "tokenFilter", urlPatterns = {"/user/*", "/task/*", "/usertask/*"})
@WebFilter(filterName = "tokenFilter", urlPatterns = {"/user/*", "/task/*"})
@Order(1)
public class LoginFilter implements Filter {


    @Autowired
    RedisClient redisClient;

    private static Cache<String, User> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
                    .expireAfterAccess(3, TimeUnit.MINUTES).build();

    private static final Set<String> ALLOWED_PATHS =
            Collections.unmodifiableSet(new HashSet<>(
                    Arrays.asList("/user/login", "/user/register", "/swagger-ui.html")
            ));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        // 带cookie的时候，origin 必须全匹配，不能使用*
        // 这个只能设置具体的那一个，不能设置*
        String origin = request.getHeader("Origin");
        if(!"".equals(origin)){
            response.setHeader("Access-Control-Allow-Origin", origin);
        }
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with" );
        response.setHeader("Access-Control-Allow-Headers",  "token");
        response.setHeader("Access-Control-Allow-Headers",  "content-type");
        // enable cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if("OPTIONS".equals(request.getMethod())){
            return ;
        }

        //系统是通过Cookie[]
        String token = "";
        String path = request.getRequestURI();
        System.out.println(path + " ----- 请求的path");
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        if (allowedPath) {
            System.out.println("这里是不需要进行过滤的方法");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    System.out.println(token +"--- token");
                }
            }

            User user = null;
            if ("" != token && token != null) {
                //登录的时候已经放入redis, 先从缓存里面查,避免每次查redis
                user = cache.getIfPresent(token);
                if (user == null) {
                    // 如果缓存里面没有,查redis 后放入缓存
                    user = redisClient.get(token);
                    if (user != null) {
                        cache.put(token, user);
                    }
                }
            }

            if (user == null) {
                return;
            }
            // 如果有user, 证明已经登录过了, 继续放行
            System.out.println("放行");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
