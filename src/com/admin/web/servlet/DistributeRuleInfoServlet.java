package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.RulesBean;

/**
 * Servlet implementation class DistributeRuleInfoServlet
 */
/** 
 * @ClassName: DistributeRuleInfoServlet 
 * @Description: TODO 获取规章制度消息 ，分发 
 * @date 2016年12月29日 下午1:52:34  
 */
@WebServlet("/DistributeRuleInfoServlet")
public class DistributeRuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeRuleInfoServlet() {
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
		String r_id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int rid=Integer.parseInt(r_id);
		//获取该id的具体信息
		ArrayList<RulesBean> rule_details=(ArrayList<RulesBean>) new AdminAllInfoDaoImpl<RulesBean>().getRulesInfo(rid);
		request.setAttribute("rid", rid);
		request.setAttribute("rule_details", rule_details);
	    request.getRequestDispatcher("./admin/rules/updateRules.jsp").forward(request, response); 
	}

}
