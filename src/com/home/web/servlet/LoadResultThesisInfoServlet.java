package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.ResultThesisBean;

/**
 * Servlet implementation class LoadResultThesisInfoServlet
 */

/**
 * 
* @ClassName: LoadResultThesisInfoServlet
* @Description: TODO 获取论文
* @author Mingshan
* @date 2017年4月12日 上午12:30:19
*
 */
@WebServlet("/LoadResultThesisInfoServlet")
public class LoadResultThesisInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadResultThesisInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ResultThesisBean> thesis=(ArrayList<ResultThesisBean>) new AllInfoDaoImpl<ResultThesisBean>().getThesisInfo();
		request.setAttribute("thesis", thesis);
		request.getRequestDispatcher("./home/list/result_thesis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
