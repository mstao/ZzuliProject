package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AddContentDaoImpl;

/**
 * Servlet implementation class AddPersonServlet
 */
/** 
 * @ClassName: AddPersonServlet 
 * @Description: TODO 增加骨干信息
 * @date 2016年12月31日 下午8:30:54  
 */
@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
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
	
		String person_name=request.getParameter("person_name");
	    String person_info=request.getParameter("person_info");
	    String person_post=request.getParameter("person_post");
	    String avatar_file=request.getParameter("avatar_file");
	    String s_is_gugan=request.getParameter("is_gugan");
	    String author=request.getParameter("author");
	    String s_is_publish=request.getParameter("is_publish");
        
        //将is_publish 转为整形	
	    int is_publish=Integer.parseInt(s_is_publish);
        //将is_gugan 转为整形
	    int is_gugan=Integer.parseInt(s_is_gugan);
	    int id=new AddContentDaoImpl().AddPersonInfo(person_name, person_info, avatar_file, person_post, author, is_gugan, is_publish);
	    String rs;
	    if(id>0){
	    	rs=String.valueOf(id);
	    }else{
	    	rs="0";
	    }

		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

}
