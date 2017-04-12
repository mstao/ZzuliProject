package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.CommonConfig;
import com.home.dao.impl.AllInfoDaoImpl;
import com.home.dao.impl.AllSimpleInfoDaoImpl;
import com.home.dao.impl.IndexDaoImpl;
import com.home.web.service.InstrumentsBean;
import com.home.web.service.NewsBean;
import com.home.web.service.ResearchBean;
import com.home.web.service.RulesBean;

/**
 * Servlet implementation class LoadHomePageInfoServlet
 */


/** 
 * @ClassName: LoadHomePageInfoServlet 
 * @Description: TODO 获取网站首页信息 
 * @author Mingshan
 * @date 2016年12月18日 上午11:36:00  
 */

@WebServlet("/LoadHomePageInfoServlet")
public class LoadHomePageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoadHomePageInfoServlet() {
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
		
		//获取新闻信息
		ArrayList<NewsBean> news=(ArrayList<NewsBean>) new IndexDaoImpl<NewsBean>().getNews("xsx");
		
	    //获取公告通知信息
		ArrayList<NewsBean> notice=(ArrayList<NewsBean>) new IndexDaoImpl<NewsBean>().getNews("xgt");
		
		//获取规章制度信息
		ArrayList<RulesBean> rules=(ArrayList<RulesBean>) new IndexDaoImpl<RulesBean>().getRules();
		
		//获取研究亮点信息
		ArrayList<ResearchBean> research=(ArrayList<ResearchBean>) new IndexDaoImpl<ResearchBean>().getResearch("kyl"); 
		
		//获取在研项目信息
		ArrayList<ResearchBean> project=(ArrayList<ResearchBean>) new IndexDaoImpl<ResearchBean>().getResearch("kzx");

		
		 //获取轮播新闻信息	
		ArrayList<NewsBean> slidernews=(ArrayList<NewsBean>) new AllInfoDaoImpl<NewsBean>().getSliderNewsInfo("xsx");
		
		//获取轮播在研项目
		ArrayList<ResearchBean> sliderproject=(ArrayList<ResearchBean>) new AllInfoDaoImpl<ResearchBean>().getSliderProject("kzx");
		
		//获取大型仪器的展览信息
		ArrayList<InstrumentsBean> instrument_show=(ArrayList<InstrumentsBean>) new AllSimpleInfoDaoImpl<InstrumentsBean>().getSimpleInstrumentInfo(0, CommonConfig.INSTRUMENT_PAGESIZE);
		/*System.out.print(news.size());
		if(news!=null|| news.size()!=0){
			for(int i=news.size()-1;i>=0;i--){
			    NewsBean nb=(NewsBean)news.get(i);
			    System.out.print("--"+nb.getItem_title());
			}
		}*/
		request.setAttribute("news",news);
	    request.setAttribute("notice", notice);
	    request.setAttribute("rules", rules);
	    request.setAttribute("research", research);
	    request.setAttribute("project", project);
	    
	    request.setAttribute("slidernews", slidernews);
	    request.setAttribute("sliderproject", sliderproject);
	    request.setAttribute("instrument_show",instrument_show);
		/*response.sendRedirect("./home/index.html");*/
		request.getRequestDispatcher("./home/index.jsp").forward(request, response); 
	}

}
