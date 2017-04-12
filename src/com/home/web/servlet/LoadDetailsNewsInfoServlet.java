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
import com.home.web.service.FileBean;
import com.home.web.service.NewsBean;

/**
 * Servlet implementation class LoadDetailsNewsInfoServlet
 */
/** 
 * @ClassName: LoadDetailsNewsInfoServlet 
 * @Description: TODO 获取新闻公告等的详细信息
 * @date 2016年12月19日 下午8:57:44  
 */
@WebServlet("/LoadDetailsNewsInfoServlet")
public class LoadDetailsNewsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsNewsInfoServlet() {
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
        /*		System.out.print("nid="+type);*/
		//根据id将浏览量+1
		new AddCountImpl().addNewsCount(id);
		
	    //获取该id的具体信息
		ArrayList<NewsBean> news_details=(ArrayList<NewsBean>) new AllInfoDaoImpl<NewsBean>().getNewsInfo(id);
	    //获取最新新闻信息
		ArrayList<NewsBean> news=(ArrayList<NewsBean>) new AllSimpleInfoDaoImpl<NewsBean>().getSimpleNewsInfo(type,0,CommonConfig.UPDATE_PAGESIZE);
		//获取该新闻的附件
		ArrayList<FileBean> file=(ArrayList<FileBean>) new AllInfoDaoImpl<FileBean>().getDocumentInfo(id, "fsg");
		request.setAttribute("file", file);
		request.setAttribute("type", type);
		request.setAttribute("item_current", news);
	    request.setAttribute("item_details", news_details);
	    request.getRequestDispatcher("./home/details/news_details.jsp").forward(request, response); 
	}

}
