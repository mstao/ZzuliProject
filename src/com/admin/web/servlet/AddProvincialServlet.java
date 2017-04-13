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
 * Servlet implementation class AddProvincialServlet
 */

/**
 * 
* @ClassName: AddProvincialServlet
* @Description: TODO 添加省部级项目
* @author Mingshan
* @date 2017年4月12日 下午8:23:56
*
 */
@WebServlet("/AddProvincialServlet")
public class AddProvincialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProvincialServlet() {
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
        String nameid=request.getParameter("nameid");
        String person=request.getParameter("person");
        String source=request.getParameter("source");
        String s_outlay=request.getParameter("outlay");
        String time=request.getParameter("time");
        String s_is_publish=request.getParameter("is_publish");
        
        double outlay=Double.parseDouble(s_outlay);
        int is_publish=Integer.parseInt(s_is_publish);
        int id=new AddContentDaoImpl().AddProvincialInfo(nameid, person, source, outlay, time, is_publish);
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
