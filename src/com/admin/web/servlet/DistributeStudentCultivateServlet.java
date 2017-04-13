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
import com.home.web.service.NewsBean;
import com.home.web.service.StudentCultivateBean;

/**
 * Servlet implementation class DistributeStudentCultivateServlet
 */

/**
 * 
* @ClassName: DistributeStudentCultivateServlet
* @Description: TODO 学生培养  
* @author Mingshan
* @date 2017年4月13日 下午6:57:46
*
 */
@WebServlet("/DistributeStudentCultivateServlet")
public class DistributeStudentCultivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributeStudentCultivateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		//获取信息id
		String n_id=request.getParameter("id");
		//将id类型转化为int
		int id=Integer.parseInt(n_id);
		//获取typename
		String type_name=new FunctionDaoImpl().getStudentTypeName(type);
	    //获取该id的具体信息
		StudentCultivateBean stu_details=new AdminAllInfoDaoImpl<StudentCultivateBean>().getStudentInfo(id);
	    request.setAttribute("stu_details", stu_details);
	    request.setAttribute("type", type);
	    request.setAttribute("type_name",type_name);
	    request.setAttribute("id", id);
	    request.getRequestDispatcher("./admin/student/updateStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
