package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.dao.impl.FunctionDaoImpl;
import com.home.web.service.IntroBean;

/**
 * Servlet implementation class ShowIntroduceInfoServlet
 */
/** 
 * @ClassName: ShowIntroduceInfoServlet 
 * @Description: TODO 显示  实验室介绍  信息
 * @date 2016年12月28日 下午12:18:22  
 */
@WebServlet("/ShowIntroduceInfoServlet")
public class ShowIntroduceInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowIntroduceInfoServlet() {
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
		//获取信息类型
		String type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		//根据类型获取类型名称
		String type_name=new FunctionDaoImpl().getIntroduceTypeName(type);
		//根据类型信息获取内容
		ArrayList<IntroBean> intro=(ArrayList<IntroBean>) new AllInfoDaoImpl<IntroBean>().getIntroduceDraftInfo(type);
		request.setAttribute("intro", intro);
		request.setAttribute("type_name", type_name);
		request.setAttribute("type", type);
		request.getRequestDispatcher("./admin/introduce/showIntroduce.jsp").forward(request, response); 
	}

}
