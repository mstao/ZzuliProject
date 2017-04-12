package com.admin.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class DealLoginServlet
 */
/** 
 * @ClassName: DealLoginServlet 
 * @Description: TODO 处理后台登录请求 
 * @date 2016年12月22日 下午7:18:03  
 */
@WebServlet("/DealLoginServlet")
public class DealLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public DealLoginServlet() {
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
		//获取信息类型
		/*String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		//获取信息类型
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");*/
        request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
   		 if(new LoginDaoImpl().loginValid(username,password)){
   		    //获取SESSION对象
		    HttpSession session=request.getSession();
		    //将用户信息保存到session中
   			session.setAttribute("username", username);
   		    //设置最大session保存时间，时间为秒
  		    session.setMaxInactiveInterval(60*60*24*7);//一星期
   			response.sendRedirect("aindex.ado");
   		 }else{
   			request.getRequestDispatcher("./admin/login.jsp?status=error").forward(request, response);
   		  }
   		 } catch (NoSuchAlgorithmException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   		 } catch (UnsupportedEncodingException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	} 
	}

}
