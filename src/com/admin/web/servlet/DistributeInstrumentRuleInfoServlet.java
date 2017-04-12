package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.InstrumentRuleBean;

/**
 * Servlet implementation class DistributeInstrumentRuleInfoServlet
 */
/** 
 * @ClassName: DistributeInstrumentRuleInfoServlet 
 * @Description: TODO 分发 大型 仪器-规章制度详细信息
 * @date 2016年12月31日 上午9:50:40  
 */
@WebServlet("/DistributeInstrumentRuleInfoServlet")
public class DistributeInstrumentRuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeInstrumentRuleInfoServlet() {
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
		int id=Integer.parseInt(r_id);
		//获取该id的具体信息
		ArrayList<InstrumentRuleBean> rule_details=(ArrayList<InstrumentRuleBean>) new AdminAllInfoDaoImpl<InstrumentRuleBean>().getInstrumentRuleInfo(id);
		request.setAttribute("id", id);
		request.setAttribute("rule_details", rule_details);
	    request.getRequestDispatcher("./admin/instrument/updateInstrumentRules.jsp").forward(request, response); 
	}

}
