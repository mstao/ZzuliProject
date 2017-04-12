package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AddContentDaoImpl;
import com.admin.dao.impl.UpadateContentDaoImpl;

/**
 * Servlet implementation class AddUpdateContactServlet
 */
/** 
 * @ClassName: AddUpdateContactServlet 
 * @Description: TODO 更新修改  联系我们信息
 * @date 2016年12月30日 下午5:25:36  
 */
@WebServlet("/AddUpdateContactServlet")
public class AddUpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUpdateContactServlet() {
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
		String i_id=request.getParameter("id");
		String i_ui=request.getParameter("ui");
	    String content=request.getParameter("content");
	    String author=request.getParameter("author");
	    String s_is_publish=request.getParameter("is_publish");
	    int is_publish=Integer.parseInt(s_is_publish);
	    int iid=Integer.parseInt(i_id);
	    int ui=Integer.parseInt(i_ui);
	    int pid=0;
	    //判断请求类型   ui 为1 为发布内容 ,0为更新内容
	    if(ui==1){
	    	pid=new AddContentDaoImpl().AddContactInfo(content, author, is_publish);
	    }else if(ui==0){
	        boolean b_id=new UpadateContentDaoImpl().updateContactInfo(iid, content, author, is_publish);
	        if(b_id==true){
	        	pid=1;
	        }else{
	        	pid=0;
	        }
	    }
	    
	    String rs;
	    if(pid>0){
	    	rs=String.valueOf(pid);
	    }else{
	    	rs="0";
	    }
	    //System.out.println(id);
		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

}
