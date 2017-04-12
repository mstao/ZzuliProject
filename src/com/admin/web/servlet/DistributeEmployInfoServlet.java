package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminSimpleInfoDaoImpl;
import com.home.web.service.EmployBean;

/**
 * Servlet implementation class DistributeEmployInfoServlet
 */
/** 
 * @ClassName: DistributeEmployInfoServlet 
 * @Description: TODO 分发 人才招聘信息
 * @date 2016年12月30日 下午3:04:31  
 */
@WebServlet("/DistributeEmployInfoServlet")
public class DistributeEmployInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeEmployInfoServlet() {
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
		//获取内容
		ArrayList<EmployBean> employ=(ArrayList<EmployBean>) new AdminSimpleInfoDaoImpl<EmployBean>().getSimpleEmployInfo();
		request.setAttribute("employ", employ);
		request.getRequestDispatcher("./admin/employ/writeEmploy.jsp").forward(request, response);
	}

}
