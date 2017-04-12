package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.dao.impl.FunctionDaoImpl;
import com.home.web.service.AchievementBean;

/**
 * Servlet implementation class LoadAchievementInfoServlet
 */


/** 
 * @ClassName: LoadAchievementInfoServlet 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @date 2016年12月19日 下午4:18:39  
 */
@WebServlet("/LoadAchievementInfoServlet")
public class LoadAchievementInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAchievementInfoServlet() {
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
		String type_name=new FunctionDaoImpl().getAchievementTypeName(type);
		//根据类型信息获取内容
		ArrayList<AchievementBean> achievement=(ArrayList<AchievementBean>) new AllInfoDaoImpl<AchievementBean>().getAchievementInfo(type);
		request.setAttribute("achievement", achievement);
		request.setAttribute("type_name", type_name);
		request.getRequestDispatcher("./home/achievement/achievement.jsp").forward(request, response);
	}

}
