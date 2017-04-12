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
import com.home.web.service.InstrumentRuleBean;

/**
 * Servlet implementation class LoadDetailsInstrumentRuleInfoServlet
 */
/** 
 * @ClassName: LoadDetailsInstrumentRuleInfoServlet 
 * @Description: TODO 获取仪器设备 -规章制度的详细信息 
 * @date 2016年12月30日 下午1:08:28  
 */
@WebServlet("/LoadDetailsInstrumentRuleInfoServlet")
public class LoadDetailsInstrumentRuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsInstrumentRuleInfoServlet() {
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
		//根据id将浏览量+1
		new AddCountImpl().addInstrumentRuleCount(id);
		//获取该id的具体信息
		ArrayList<InstrumentRuleBean> rule_details=(ArrayList<InstrumentRuleBean>) new AllInfoDaoImpl<InstrumentRuleBean>().getInstrumentRuleInfo(id);
	    //获取最近更新的
		ArrayList<InstrumentRuleBean> rules_current=(ArrayList<InstrumentRuleBean>) new AllSimpleInfoDaoImpl<InstrumentRuleBean>().getSimpleInstrumentRuleInfo(0, CommonConfig.UPDATE_PAGESIZE);
		
		//获取规章制度的附件
		ArrayList<FileBean> file=(ArrayList<FileBean>) new AllInfoDaoImpl<FileBean>().getDocumentInfo(id, "fyz");
		
		request.setAttribute("rule_details", rule_details);
		request.setAttribute("rules_current", rules_current);
		request.setAttribute("file", file);
	    request.getRequestDispatcher("./home/details/instrument_rule_details.jsp").forward(request, response); 
	}

}
