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
 * Servlet implementation class AddPatentServlet
 */

/**
 * 
* @ClassName: AddPatentServlet
* @Description: TODO 添加添加专利
* @author Mingshan
* @date 2017年4月12日 下午8:54:36
*
 */
@WebServlet("/AddPatentServlet")
public class AddPatentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatentServlet() {
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
        String name=request.getParameter("name");
        String style=request.getParameter("style");
        String person=request.getParameter("person");
        String time=request.getParameter("time");
        String s_is_publish=request.getParameter("is_publish");
       
        int is_publish=Integer.parseInt(s_is_publish);
        int id=new AddContentDaoImpl().AddPatentInfo(name, style, person, time, is_publish);
	    String rs;
	    if(id>0){
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
