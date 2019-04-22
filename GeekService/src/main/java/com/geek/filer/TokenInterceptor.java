//package com.geek.filer;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class TokenInterceptor implements HandlerInterceptor {
//
//    // controller 执行前调用
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("==========preHandle=========="+ handler.getClass());
//        return true;
//    }
//    // controller  执行后 且页面渲染前调用
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("===========postHandle=========");
//        String token = request.getHeader("token");
//        System.out.println(request.toString() +  request.getHeaderNames());
//
//        System.out.println(token);
//        String token2 = request.getParameter("token");
//
//        System.out.println(token2  + "--- token2");
//    }
//    // 页面渲染之后调用，一般用于资源清理操作
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("============afterCompletion========");
//    }
//}
