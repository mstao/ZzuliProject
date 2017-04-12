package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.CommonConfig;
import com.home.dao.impl.AllSimpleInfoDaoImpl;
import com.home.dao.impl.CountInfoDaoImpl;
import com.home.dao.impl.FunctionDaoImpl;
import com.home.util.PageHelper;
import com.home.web.service.NewsBean;

/**
 * Servlet implementation class LoadNewsInfoServlet
 */
@WebServlet("/LoadNewsInfoServlet")
public class LoadNewsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadNewsInfoServlet() {
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
		
		//获取当前页 
		String sp=new String(request.getParameter("p").getBytes("ISO-8859-1"),"UTF-8");
		
		//根据type_flag 获取type_name
		String type_name=new FunctionDaoImpl().getNewsTypeName(type);
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}
		
		//根据信息类型获取信息的总记录数值
		int newsCount=new CountInfoDaoImpl().getNewsCount(type);

		//设置每页显示的数据量
		int item_pre_page=CommonConfig.HOME_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取对应数据
		ArrayList<NewsBean> news=(ArrayList<NewsBean>) new AllSimpleInfoDaoImpl<NewsBean>().getSimpleNewsInfo(type,position,item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(newsCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./news.do?type='"+type+"'&p=";
        //去掉 url中的单引号
        url=url.replace("'", "");
		phelper.setPath(url); 
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("toolbar", toolbar);
		request.setAttribute("news", news);
		request.setAttribute("type_name", type_name);
		request.getRequestDispatcher("./home/list/newslist.jsp").forward(request, response); 
	}

}
