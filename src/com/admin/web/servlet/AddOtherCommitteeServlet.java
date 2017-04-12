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
 * Servlet implementation class AddOtherCommitteeServlet
 */
/** 
 * @ClassName: AddOtherCommitteeServlet 
 * @Description: TODO 管理委员会，学术委员会信息人员信息
 * @date 2017年1月1日 下午8:17:15  
 */
@WebServlet("/AddOtherCommitteeServlet")
public class AddOtherCommitteeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOtherCommitteeServlet() {
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
        String style=request.getParameter("style");
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        String sex=request.getParameter("sex");
        String post=request.getParameter("post");
        String title=request.getParameter("title");
        String research=request.getParameter("research");
        String unit=request.getParameter("unit");
        String author=request.getParameter("author");
        String s_is_publish=request.getParameter("is_publish");
        int is_publish=Integer.parseInt(s_is_publish);
	  
	    int id=new AddContentDaoImpl().AddOtherCommitteeInfo(style, name, birthday, sex, post, title, research, unit, author, is_publish);
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

}
