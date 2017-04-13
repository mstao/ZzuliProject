package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.DeleteContentDaoImpl;

/**
 * Servlet implementation class DeleteHorizontalCooperationServlet
 */
@WebServlet("/DeleteHorizontalCooperationServlet")
public class DeleteHorizontalCooperationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHorizontalCooperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ids=request.getParameter("ids");
		String rs;		
        String[] idArray = ids.split(",");
        //进行批量删除
        boolean flag=new DeleteContentDaoImpl().deleteHorizontalCooperation(idArray);
        if(flag==true){
        	rs="1";
        }else{
        	rs="0";
        }     
		
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
