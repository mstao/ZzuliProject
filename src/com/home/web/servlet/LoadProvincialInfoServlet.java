package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.ProvincialProjectBean;

/**
 * Servlet implementation class LoadProvincialInfoServlet
 */

/**
 * 
* @ClassName: LoadProvincialInfoServlet
* @Description: TODO 获取省部级重大（点）项目
* @author Mingshan
* @date 2017年4月12日 上午12:11:18
*
 */
@WebServlet("/LoadProvincialInfoServlet")
public class LoadProvincialInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadProvincialInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ProvincialProjectBean> provincial=(ArrayList<ProvincialProjectBean>) new AllInfoDaoImpl<ProvincialProjectBean>().getProvincialProjectInfo();
		request.setAttribute("provincial", provincial);
		request.getRequestDispatcher("./home/list/project_provincial.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
