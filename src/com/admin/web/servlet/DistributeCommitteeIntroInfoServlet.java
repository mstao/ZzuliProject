package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.dao.impl.FunctionDaoImpl;
import com.home.web.service.CommitteeIntroBean;

/**
 * Servlet implementation class DistributeCommitteeIntroInfoServlet
 */
/** 
 * @ClassName: DistributeCommitteeIntroInfoServlet 
 * @Description: TODO 分发委员会介绍信息 
 * @date 2017年1月1日 下午9:46:13  
 */
@WebServlet("/DistributeCommitteeIntroInfoServlet")
public class DistributeCommitteeIntroInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeCommitteeIntroInfoServlet() {
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
		String type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		//根据类型获取类型名称
		String type_name=new FunctionDaoImpl().getCommitteeIntroTypeName(type);
		//根据类型信息获取内容
		ArrayList<CommitteeIntroBean> committeeintro=(ArrayList<CommitteeIntroBean>) new AdminAllInfoDaoImpl<CommitteeIntroBean>().getCommitteeIntroInfo(type);
		request.setAttribute("committeeintro", committeeintro);
		request.setAttribute("type", type);
		request.setAttribute("type_name", type_name);
		request.getRequestDispatcher("./admin/introduce/writeCommitteeIntro.jsp").forward(request, response); 
	}

}
