package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.HorizontalCooperationBean;

/**
 * Servlet implementation class LoadHorizontalCooperationInfoServlet
 */

/**
 * 
* @ClassName: LoadHorizontalCooperationInfoServlet
* @Description: TODO 获取横向合作
* @author Mingshan
* @date 2017年4月12日 上午12:15:15
*
 */
@WebServlet("/LoadHorizontalCooperationInfoServlet")
public class LoadHorizontalCooperationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadHorizontalCooperationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<HorizontalCooperationBean> cooperation=(ArrayList<HorizontalCooperationBean>) new AllInfoDaoImpl<HorizontalCooperationBean>().getHorizontalCooperationInfo();
		request.setAttribute("cooperation", cooperation);
		request.getRequestDispatcher("./home/list/project_horizontal_cooperation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
