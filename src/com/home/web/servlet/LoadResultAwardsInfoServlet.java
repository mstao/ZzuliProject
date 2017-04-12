package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.ResultRewardsBean;

/**
 * Servlet implementation class LoadResultAwardsInfoServlet
 */
/**
 * 
* @ClassName: LoadResultAwardsInfoServlet
* @Description: TODO 获取奖励信息
* @author Mingshan
* @date 2017年4月12日 上午12:20:48
*
 */
@WebServlet("/LoadResultAwardsInfoServlet")
public class LoadResultAwardsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadResultAwardsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ResultRewardsBean> awards=(ArrayList<ResultRewardsBean>) new AllInfoDaoImpl<ResultRewardsBean>().getResultRewardsInfo();
	    request.setAttribute("awards", awards);
	    request.getRequestDispatcher("./home/list/result_awards.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
