package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class UpdateUserPasswordServlet
 */
/** 
 * @ClassName: UpdateUserPasswordServlet 
 * @Description: TODO 更新用户账户密码
 * @date 2017年1月4日 下午3:18:56  
 */
@WebServlet("/UpdateUserPasswordServlet")
public class UpdateUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取用户名
		String username=request.getParameter("um").trim();
		String oldpassword=request.getParameter("old").trim();
		String newpassword=request.getParameter("new").trim();
		String repeatpassword=request.getParameter("repeat").trim();
		String rs="";
		//验证用户原来的密码的正确性
		try {
	   		 if(new LoginDaoImpl().loginValid(username,oldpassword)){
	   		      
	   			 if(newpassword.equals(repeatpassword)){
   		    	  //修改密码
   		    	  boolean flag=new LoginDaoImpl().updatePassword(username, newpassword);
   		          if(flag==true){
   		        	  rs="1";
   		          }else{
   		        	  rs="0";
   		          }
   		          
	   			 }else{
	   				  rs="0";
	   			 }
	   		      
	   		      
	   		      
	   		 }else{//旧密码输入错误
	   		     rs="2";
	   		 }
   		 } catch (NoSuchAlgorithmException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   		 } catch (UnsupportedEncodingException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
     	} 
		
		
		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

}
