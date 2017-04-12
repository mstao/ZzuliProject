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
import com.home.web.service.ResearchBean;

/**
 * Servlet implementation class LoadDetailsResearchInfoServlet
 */
/** 
 * @ClassName: LoadDetailsResearchInfoServlet 
 * @Description: TODO 获取科学研究的具体信息
 * @date 2016年12月19日 下午9:15:45  
 */
@WebServlet("/LoadDetailsResearchInfoServlet")
public class LoadDetailsResearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsResearchInfoServlet() {
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
		String type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		String s_id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int id=Integer.parseInt(s_id);
		//根据id将浏览量+1
		
		new AddCountImpl().addResearchCount(id);
		//获取该id的具体信息
		ArrayList<ResearchBean> research_details=(ArrayList<ResearchBean>) new AllInfoDaoImpl<ResearchBean>().getResearchInfo(id);
	    //获取最新更新的科学研究信息
		ArrayList<ResearchBean> research_current=(ArrayList<ResearchBean>) new AllSimpleInfoDaoImpl<ResearchBean>().getSimpleResearchInfo(type, 0, CommonConfig.UPDATE_PAGESIZE); 
	   
		//获取科学研究的附件
		ArrayList<FileBean> file=(ArrayList<FileBean>) new AllInfoDaoImpl<FileBean>().getDocumentInfo(id, "fky");
		
		request.setAttribute("item_details", research_details);
	    request.setAttribute("item_current", research_current);
	    request.setAttribute("type", type);
	    request.setAttribute("file", file);
	    request.getRequestDispatcher("./home/details/research_details.jsp").forward(request, response); 
	
	}

}
