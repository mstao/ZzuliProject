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
import com.home.web.service.AchievementBean;

/**
 * Servlet implementation class DistributeAchievementInfoServlet
 */
/** 
 * @ClassName: DistributeAchievementInfoServlet 
 * @Description: TODO 分发科研成果信息
 * @date 2016年12月30日 下午9:12:33  
 */
@WebServlet("/DistributeAchievementInfoServlet")
public class DistributeAchievementInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeAchievementInfoServlet() {
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
		String type_name=new FunctionDaoImpl().getAchievementTypeName(type);
	    //获取该id的具体信息
		ArrayList<AchievementBean> ac_details=(ArrayList<AchievementBean>) new AdminAllInfoDaoImpl<AchievementBean>().getAchievementInfo(id);
	    request.setAttribute("ac_details", ac_details);
	    request.setAttribute("type", type);
	    request.setAttribute("type_name",type_name);
	    request.setAttribute("id", id);
	    
	    request.getRequestDispatcher("./admin/achievement/updateAchievement.jsp").forward(request, response); 	
	   
	   
	}

}
