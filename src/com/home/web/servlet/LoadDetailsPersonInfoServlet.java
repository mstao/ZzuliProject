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
import com.home.web.service.PersonBean;

/**
 * Servlet implementation class LoadDetailsPersonInfoServlet
 */
/** 
 * @ClassName: LoadDetailsPersonInfoServlet 
 * @Description: TODO 获取人物信息信息 
 * @date 2016年12月20日 下午8:19:27  
 */
@WebServlet("/LoadDetailsPersonInfoServlet")
public class LoadDetailsPersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsPersonInfoServlet() {
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
	
		String s_id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		//将id类型转化为int
		int id=Integer.parseInt(s_id);
		//根据id将浏览量+1
		new AddCountImpl().addPersonCount(id);
		//获取该id的具体信息
		ArrayList<PersonBean> person_details=(ArrayList<PersonBean>) new AllInfoDaoImpl<PersonBean>().getPersonInfo(id);
	    request.setAttribute("person_details", person_details);
	    request.getRequestDispatcher("./home/details/person_details.jsp").forward(request, response);
	    
	}

}
