package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.impl.AllInfoDaoImpl;
import com.home.web.service.CommitteeBean;
import com.home.web.service.CommitteeIntroBean;

/**
 * Servlet implementation class LoadCommitteeInfoServlet
 */
/** 
 * @ClassName: LoadCommitteeInfoServlet 
 * @Description: TODO 获取委员会的信息
 * @date 2017年1月2日 下午4:42:52  
 */
@WebServlet("/LoadCommitteeInfoServlet")
public class LoadCommitteeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCommitteeInfoServlet() {
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
		
	
		//获取数据
		ArrayList<CommitteeBean> committee=(ArrayList<CommitteeBean>) new AllInfoDaoImpl<CommitteeBean>().getCommitteeInfo(type);
		//根据类型获取获取 委员会的介绍信息
		String intro_type="";
		if(type.equals("academia")){ //专家委员会
			intro_type="xsw";
		}else if(type.equals("manage")){ //管理委员会
			intro_type="glw";
		}else if(type.equals("director")){//主任委员会
			intro_type="szw";
		}
		ArrayList<CommitteeIntroBean> committeeintro=(ArrayList<CommitteeIntroBean>) new AllInfoDaoImpl<CommitteeIntroBean>().getCommitteeIntroInfo(intro_type);
		
		request.setAttribute("committee", committee);
		request.setAttribute("committeeintro", committeeintro);
		if(type.equals("academia")){ //专家委员会
			request.getRequestDispatcher("./home/introduce/showAcademiaCommittee.jsp").forward(request, response); 
		}else if(type.equals("manage")){ //管理委员会
			request.getRequestDispatcher("./home/introduce/showManageCommittee.jsp").forward(request, response); 
		}else if(type.equals("director")){//主任委员会
			request.getRequestDispatcher("./home/introduce/showDirectorCommittee.jsp").forward(request, response); 
		}
	}

}
