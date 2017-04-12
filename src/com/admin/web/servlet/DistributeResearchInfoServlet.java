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
import com.home.web.service.ResearchBean;

/**
 * Servlet implementation class Distribute
 */
/** 
 * @ClassName: DistributeResearchInfoServlet 
 * @Description: TODO  分发科学研究信息
 * @date 2016年12月29日 下午5:53:23  
 */
@WebServlet("/Distribute")
public class DistributeResearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeResearchInfoServlet() {
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
		String type_name=new FunctionDaoImpl().getResearchTypeName(type);
	    //获取该id的具体信息
		ArrayList<ResearchBean> research_details=(ArrayList<ResearchBean>) new AdminAllInfoDaoImpl<ResearchBean>().getResearchInfo(id);
	    request.setAttribute("research_details", research_details);
	    request.setAttribute("type", type);
	    request.setAttribute("type_name",type_name);
	    request.setAttribute("id", id);
	    request.getRequestDispatcher("./admin/research/updateResearch.jsp").forward(request, response);
	}

}
