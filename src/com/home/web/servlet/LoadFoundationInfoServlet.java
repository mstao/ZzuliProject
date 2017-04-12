package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.FoundationbBean;

/**
 * Servlet implementation class LoadFoundationInfo
 */
/**
 * 
* @ClassName: LoadFoundationInfo
* @Description: TODO 加载国家自然科学基金项目信息
* @author Mingshan
* @date 2017年4月12日 上午12:04:10
*
 */

@WebServlet("/LoadFoundationInfo")
public class LoadFoundationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadFoundationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<FoundationbBean> foundation=(ArrayList<FoundationbBean>) new AllInfoDaoImpl<FoundationbBean>().getProjectFoundationInfo();
		request.setAttribute("foundation", foundation);
		request.getRequestDispatcher("./home/list/project_foundation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
