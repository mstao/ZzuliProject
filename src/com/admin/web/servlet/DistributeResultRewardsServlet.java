package com.admin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.ResultRewardsBean;

/**
 * Servlet implementation class DistributeResultRewardsServlet
 */
@WebServlet("/DistributeResultRewardsServlet")
public class DistributeResultRewardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeResultRewardsServlet() {
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
		
		ResultRewardsBean rewards=new AdminAllInfoDaoImpl<ResultRewardsBean>().getRewardsInfo(id);
	    request.setAttribute("rewards",rewards);
	    request.getRequestDispatcher("./admin/result/updateRewards.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
