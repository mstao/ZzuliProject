package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.PersonIntroBean;

/**
 * Servlet implementation class LoadPersonIntroInfoServlet
 */
/** 
 * @ClassName: LoadPersonIntroInfoServlet 
 * @Description: TODO 获取人才队伍现状信息
 * @date 2017年1月1日 上午10:41:31  
 */
@WebServlet("/LoadPersonIntroInfoServlet")
public class LoadPersonIntroInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPersonIntroInfoServlet() {
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
		ArrayList<PersonIntroBean> personintro=(ArrayList<PersonIntroBean>) new AllInfoDaoImpl<PersonIntroBean>().getPersonIntro();
		request.setAttribute("personintro",personintro);
		request.getRequestDispatcher("./home/person/personintro.jsp").forward(request, response);
	}

}
