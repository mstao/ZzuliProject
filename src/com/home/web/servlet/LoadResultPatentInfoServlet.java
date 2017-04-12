package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.ResultPatentBean;

/**
 * Servlet implementation class LoadResultPatentInfoServlet
 */

/**
 * 
* @ClassName: LoadResultPatentInfoServlet
* @Description: TODO 获取专利
* @author Mingshan
* @date 2017年4月12日 上午12:26:45
*
 */
@WebServlet("/LoadResultPatentInfoServlet")
public class LoadResultPatentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadResultPatentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ResultPatentBean> patent=(ArrayList<ResultPatentBean>) new AllInfoDaoImpl<ResultPatentBean>().getPatentInfo();
		request.setAttribute("patent", patent);
		request.getRequestDispatcher("./home/list/result_patent.jsp").forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
