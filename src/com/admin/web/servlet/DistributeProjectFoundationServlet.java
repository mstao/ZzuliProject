package com.admin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.FoundationbBean;

/**
 * Servlet implementation class DistributeProjectFoundationServlet
 */
@WebServlet("/DistributeProjectFoundationServlet")
public class DistributeProjectFoundationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeProjectFoundationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取id
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		FoundationbBean foundation=new AdminAllInfoDaoImpl<FoundationbBean>().getFoundationInfo(id);
		request.setAttribute("foundation",foundation);
		request.getRequestDispatcher("./admin/research/updateFoundation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
