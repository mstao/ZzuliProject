package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.CommonConfig;
import com.home.dao.impl.AddCountImpl;
import com.home.dao.impl.AllInfoDaoImpl;
import com.home.dao.impl.AllSimpleInfoDaoImpl;
import com.home.web.service.AchievementBean;
import com.home.web.service.FileBean;


/**
 * Servlet implementation class LoadDeatilsAchievementInfoServlet
 */
@WebServlet("/LoadDeatilsAchievementInfoServlet")
public class LoadDetailsAchievementZhuanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsAchievementZhuanInfoServlet() {
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
		//获取信息id
		String n_id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int id=Integer.parseInt(n_id);
		
		//浏览量+1
		new AddCountImpl().addAchievementZhuanCount(id);
		//获取该id的具体信息
		ArrayList<AchievementBean> ac_details=(ArrayList<AchievementBean>) new AllInfoDaoImpl<AchievementBean>().getAchievementInfo(id);
		//获取最新更新
		ArrayList<AchievementBean> ac_current=(ArrayList<AchievementBean>) new AllSimpleInfoDaoImpl<AchievementBean>().getSimpleAchievementInfo(type, 0, CommonConfig.UPDATE_PAGESIZE);
		
		//获取附件
		ArrayList<FileBean> file=(ArrayList<FileBean>) new AllInfoDaoImpl<FileBean>().getDocumentInfo(id, "fcz");
		request.setAttribute("file", file);
		request.setAttribute("ac_details", ac_details);
		request.setAttribute("ac_current", ac_current);
		request.getRequestDispatcher("./home/details/achievement_zhuan_details.jsp").forward(request, response);
	}

}
