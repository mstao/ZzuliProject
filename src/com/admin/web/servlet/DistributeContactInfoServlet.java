package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminSimpleInfoDaoImpl;
import com.home.web.service.ContactBean;

/**
 * Servlet implementation class DistributeContactInfoServlet
 */
/** 
 * @ClassName: DistributeContactInfoServlet 
 * @Description: TODO 分发联系我们 信息 
 * @date 2016年12月30日 下午5:12:17  
 */
@WebServlet("/DistributeContactInfoServlet")
public class DistributeContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeContactInfoServlet() {
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
		//获取内容
		ArrayList<ContactBean> contact=(ArrayList<ContactBean>) new AdminSimpleInfoDaoImpl<ContactBean>().getSimpleContactInfo();
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("./admin/contact/writeContact.jsp").forward(request, response); 
	}

}
