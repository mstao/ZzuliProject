package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllSimpleInfoDaoImpl;
import com.home.dao.impl.CountInfoDaoImpl;
import com.home.web.service.NewsBean;
import com.home.web.service.ResearchBean;

/**
 * Servlet implementation class LoadAdminPageViewServlet
 */
/** 
 * @ClassName: LoadAdminPageViewServlet 
 * @Description: TODO 载入后台主页
 * @date 2016年12月22日 下午7:00:26  
 */
@WebServlet("/LoadAdminPageViewServlet")
public class LoadAdminPageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAdminPageViewServlet() {
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
		CountInfoDaoImpl ci=new CountInfoDaoImpl();
		//获取新闻数量
		int newsCount=ci.getNewsCount("xsx");
		//获取公告通知数量
		int noticeCount=ci.getNewsCount("xgt");
		//获取规章制度数量
		int ruleCount=ci.getRulesCount();
		//获取在研项目
		int projectCount=ci.getResearchCount("kzx");
		
		String  type="";
		//获取最近更新的新闻信息
		type="xsx";
		ArrayList<NewsBean> news=(ArrayList<NewsBean>) new AllSimpleInfoDaoImpl<NewsBean>().getSimpleNewsInfo(type,0,7);
		
		//获取最近更新的公告通知
		type="xgt";
		ArrayList<NewsBean> notice=(ArrayList<NewsBean>) new AllSimpleInfoDaoImpl<NewsBean>().getSimpleNewsInfo(type,0,7);
		
		//获取最近更新的研究亮点
		type="kyl";
		ArrayList<ResearchBean> research=(ArrayList<ResearchBean>) new AllSimpleInfoDaoImpl<ResearchBean>().getSimpleResearchInfo(type,0,7);
		
		request.setAttribute("newsCount", newsCount);
		request.setAttribute("noticeCount", noticeCount);
		request.setAttribute("ruleCount", ruleCount);
		request.setAttribute("projectCount", projectCount);
		
		request.setAttribute("news", news);
		request.setAttribute("notice", notice);
		request.setAttribute("research", research);
		/*String sessionId=request.getSession().getId();
		System.out.print(sessionId);*/
		request.getRequestDispatcher("./admin/index.jsp").forward(request, response);
	}

}
