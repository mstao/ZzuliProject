package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.ResultIdentificationBean;

/**
 * Servlet implementation class LoadResultIdentificationInfoServlet
 */
/**
 * 
* @ClassName: LoadResultIdentificationInfoServlet
* @Description: TODO 获取鉴定
* @author Mingshan
* @date 2017年4月12日 上午12:33:50
*
 */
@WebServlet("/LoadResultIdentificationInfoServlet")
public class LoadResultIdentificationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadResultIdentificationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ResultIdentificationBean> identification=(ArrayList<ResultIdentificationBean>) new AllInfoDaoImpl<ResultIdentificationBean>().getIdentificationInfo();
		
		request.setAttribute("identification", identification);
		request.getRequestDispatcher("./home/list/result_identification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
