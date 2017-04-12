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
import com.home.util.PageHelper;
import com.home.web.service.RulesBean;

/**
 * Servlet implementation class LoadRulesInfoServlet
 */
@WebServlet("/LoadRulesInfoServlet")
public class LoadRulesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadRulesInfoServlet() {
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
		//获取当前页 
		String sp=new String(request.getParameter("p").getBytes("ISO-8859-1"),"UTF-8");
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}		
		
		//获取记录总数值
		int rCount=new CountInfoDaoImpl().getRulesCount();
		//设置每页显示的数据量
		int item_pre_page=CommonConfig.HOME_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取相应的信息
		ArrayList<RulesBean> rules=(ArrayList<RulesBean>) new AllSimpleInfoDaoImpl<RulesBean>().getSimpleRulesInfo(position,item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(rCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./rules.do?p=";
		phelper.setPath(url); 
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("rules", rules);
		request.setAttribute("toolbar", toolbar);
		request.getRequestDispatcher("./home/list/ruleslist.jsp").forward(request, response); 
	}

}
