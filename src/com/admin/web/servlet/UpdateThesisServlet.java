package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.UpadateContentDaoImpl;

/**
 * Servlet implementation class UpdateThesisServlet
 */

/**
 * 
* @ClassName: UpdateThesisServlet
* @Description: TODO 修改论文
* @author Mingshan
* @date 2017年4月13日 上午8:20:54
*
 */
@WebServlet("/UpdateThesisServlet")
public class UpdateThesisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateThesisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String style=request.getParameter("style");
        String author=request.getParameter("author");
        String name=request.getParameter("name");
        String publication_division=request.getParameter("publication_division");
        String page_number=request.getParameter("page_number");
        String s_is_publish=request.getParameter("is_publish");
        String sid=request.getParameter("id");
        int is_publish=Integer.parseInt(s_is_publish);
        int id=Integer.parseInt(sid);
        boolean bid=new UpadateContentDaoImpl().updateThesisInfo(id, style, author, name, publication_division, page_number, is_publish);
	    String rs;
	    
	    if(bid==true){
	    	rs=String.valueOf(id);
	    }else{
	    	rs="0";
	    }
	    //System.out.println(id);
		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
