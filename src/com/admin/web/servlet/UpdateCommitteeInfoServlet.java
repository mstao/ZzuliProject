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
 * Servlet implementation class UpdateCommitteeInfoServlet
 */
/** 
 * @ClassName: UpdateCommitteeInfoServlet 
 * @Description: TODO 修改委员会人员信息
 * @date 2017年1月2日 上午11:25:00  
 */
@WebServlet("/UpdateCommitteeInfoServlet")
public class UpdateCommitteeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommitteeInfoServlet() {
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
        String s_id=request.getParameter("id");
        String type=request.getParameter("type");
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
        
        int id=Integer.parseInt(s_id);
        boolean bid=new UpadateContentDaoImpl().updateCommitteeInfo(id, type, name, birthday, sex, post, title, research, unit, author, is_publish);
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

}
