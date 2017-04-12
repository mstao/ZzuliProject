package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.CommitteeBean;


/**
 * Servlet implementation class DistributeCommitteeInfoServlet
 */
/** 
 * @ClassName: DistributeCommitteeInfoServlet 
 * @Description: TODO 分发委员会人员的信息
 * @date 2017年1月2日 上午12:45:09  
 */
@WebServlet("/DistributeCommitteeInfoServlet")
public class DistributeCommitteeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeCommitteeInfoServlet() {
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
	  
	    //获取该id的具体信息
		ArrayList<CommitteeBean> committee=(ArrayList<CommitteeBean>) new AdminAllInfoDaoImpl<CommitteeBean>().getCommitteeInfo(id, type);
	    request.setAttribute("committee", committee);
	    request.setAttribute("type", type);
	    request.setAttribute("id", id);
	    if(type.equals("director")){//主任委员会
	    	request.getRequestDispatcher("./admin/introduce/updateDirectorCommittee.jsp").forward(request, response);
		}else{//管理委员会，学术委员会
			request.getRequestDispatcher("./admin/introduce/updateOtherCommittee.jsp").forward(request, response);
		}
	    
	}

}
