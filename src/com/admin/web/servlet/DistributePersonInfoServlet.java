package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.home.web.service.PersonBean;

/**
 * Servlet implementation class DistributePersonInfoServlet
 */
/** 
 * @ClassName: DistributePersonInfoServlet 
 * @Description: TODO 分发骨干信息 
 * @date 2016年12月31日 下午9:15:59  
 */
@WebServlet("/DistributePersonInfoServlet")
public class DistributePersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributePersonInfoServlet() {
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
		//获取信息id
		String n_id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int id=Integer.parseInt(n_id);
	    //获取该id的具体信息
		ArrayList<PersonBean> person=(ArrayList<PersonBean>) new AdminAllInfoDaoImpl<PersonBean>().getPersonInfo(id);
	    request.setAttribute("person", person);
	    request.setAttribute("id", id);
	    request.getRequestDispatcher("./admin/person/updatePerson.jsp").forward(request, response);
	}

}
