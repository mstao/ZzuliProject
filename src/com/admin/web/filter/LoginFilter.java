package com.admin.web.filter;

import java.io.IOException;  
  


import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  

/** 
 * @ClassName: LoginFilter 
 * @Description: TODO 后台登录过滤
 * @date 2016年12月23日 下午1:18:38  
 */
public class LoginFilter implements Filter {  
    private static final String SHOW_LOGIN_PATH = "SHOW_LOGIN_PATH";    //显示登录页面  
    private static final String DO_LOGIN_PATH = "DO_LOGIN_PATH";        //登录操作不能过滤掉  
    private static final String LOGIN_USERNAME = "LOGIN_USERNAME";      //登录用户在session中的属性key -- session.setAttribute(key,value)  
    private String showloginPath;  
    private String dologinPath;  
    private String loginUserName;  
    //初始化信息  
    public void init(FilterConfig config) throws ServletException {  
        showloginPath = config.getInitParameter(SHOW_LOGIN_PATH);  
        dologinPath = config.getInitParameter(DO_LOGIN_PATH);  
        loginUserName = config.getInitParameter(LOGIN_USERNAME);  
        if(showloginPath==null || showloginPath.equals("") || showloginPath.equals("null") ){  
            throw new ServletException("登录页面配置出错,请查看web.xml配置是否正确...");  
        }  
    }  
    //过滤操作  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
         HttpServletRequest  httpReq  = (HttpServletRequest) request;  
         HttpServletResponse httpResp = (HttpServletResponse) response;  
         httpResp.setContentType("text/html");  
         //判断是否是登陆页面  
         String servletPath = httpReq.getServletPath();  
          //System.out.print("我是过滤器。。");
         //flag:若为登陆页面的action路径 showloginPath/dologinPath,则赋值true，否则赋值false  
         @SuppressWarnings("unused")
		 boolean flag = false;  
         if(servletPath.equals(showloginPath) || servletPath.equals(dologinPath)){  
             chain.doFilter(request, response);  
         
             flag = true;  
             return;  
         }else{   
           //如果不是登录页面，则需先判断用户是否已登录  
           //String url = servletPath;  
           String username= (String) httpReq.getSession().getAttribute(loginUserName);  
           //System.out.print(username);
           if(username != null){//如果不为空,则进行已登录处理  
                 chain.doFilter(request, response);  
             }else{//如果为空,则进行未登录处理  ，跳转到登录界面，拒绝进入 
                 httpReq.getRequestDispatcher(showloginPath).forward(httpReq,httpResp);   
             }  
         }  
    }  
      
    public void destroy(){  
        //do something 。。 
    }  
      
}  