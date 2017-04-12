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
import com.home.web.service.NewsBean;

/**
 * Servlet implementation class DistributeNewsInfoServlet
 */
/** 
 * @ClassName: DistributeNewsInfoServlet 
 * @Description: TODO 分发新闻公告数据
 * @date 2016年12月28日 下午8:50:19  
 */
@WebServlet("/DistributeNewsInfoServlet")
public class DistributeNewsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeNewsInfoServlet() {
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
		//获取typename
		String type_name=new FunctionDaoImpl().getNewsTypeName(type);
	    //获取该id的具体信息
		ArrayList<NewsBean> news_details=(ArrayList<NewsBean>) new AdminAllInfoDaoImpl<NewsBean>().getNewsInfo(id);
	    request.setAttribute("news_details", news_details);
	    request.setAttribute("type", type);
	    request.setAttribute("type_name",type_name);
	    request.setAttribute("nid", id);
	    request.getRequestDispatcher("./admin/news/updateNews.jsp").forward(request, response);
	}

}
