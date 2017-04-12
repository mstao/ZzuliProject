package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.PersonIntroBean;

/**
 * Servlet implementation class DistributePersonIntroInfoServlet
 */
/** 
 * @ClassName: DistributePersonIntroInfoServlet 
 * @Description: TODO 分发人才队伍现状数据 
 * @date 2016年12月31日 下午7:02:53  
 */
@WebServlet("/DistributePersonIntroInfoServlet")
public class DistributePersonIntroInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributePersonIntroInfoServlet() {
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
		ArrayList<PersonIntroBean> personintro=(ArrayList<PersonIntroBean>) new AdminAllInfoDaoImpl<PersonIntroBean>().getPersonIntroInfo();
		request.setAttribute("personintro", personintro);
		request.getRequestDispatcher("./admin/person/writePersonIntro.jsp").forward(request, response); 
	}

}
