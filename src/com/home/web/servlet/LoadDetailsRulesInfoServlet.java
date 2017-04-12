package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AddCountImpl;
import com.home.dao.impl.AllInfoDaoImpl;
import com.home.dao.impl.IndexDaoImpl;
import com.home.web.service.FileBean;
import com.home.web.service.RulesBean;

/**
 * Servlet implementation class LoadDetailsRulesInfoServlet
 */
/** 
 * @ClassName: LoadDetailsRulesInfoServlet 
 * @Description: TODO 获取规章制度详细信息
 * @date 2016年12月19日 下午8:56:14  
 */
@WebServlet("/LoadDetailsRulesInfoServlet")
public class LoadDetailsRulesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsRulesInfoServlet() {
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
		String r_id=new String(request.getParameter("rid").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int rid=Integer.parseInt(r_id);
		//根据id将浏览量+1
		new AddCountImpl().addRuleCount(rid);
		//获取该id的具体信息
		ArrayList<RulesBean> rule_details=(ArrayList<RulesBean>) new AllInfoDaoImpl<RulesBean>().getRulesInfo(rid);
	    //获取最近更新的规章制度信息
		ArrayList<RulesBean> rules_current=(ArrayList<RulesBean>) new IndexDaoImpl<RulesBean>().getRules();
		
		//获取规章制度的附件
		ArrayList<FileBean> file=(ArrayList<FileBean>) new AllInfoDaoImpl<FileBean>().getDocumentInfo(rid, "fgz");
		
		request.setAttribute("rule_details", rule_details);
		request.setAttribute("rules_current", rules_current);
		request.setAttribute("file", file);
	    request.getRequestDispatcher("./home/details/rule_details.jsp").forward(request, response); 
	}

}
