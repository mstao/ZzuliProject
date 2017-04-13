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
import com.home.web.service.NewsBean;
import com.home.web.service.StudentCultivateBean;

/**
 * Servlet implementation class LoadDetailsSatudentInfoServlet
 */

/**
 * 
* @ClassName: LoadDetailsSatudentInfoServlet
* @Description: TODO 获取学生培养的详细信息
* @author Mingshan
* @date 2017年4月13日 下午4:24:03
*
 */
@WebServlet("/LoadDetailsSatudentInfoServlet")
public class LoadDetailsStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailsStudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
		//获取信息类型
		String type=request.getParameter("type");
		//获取信息id
		String n_id=request.getParameter("id");
		//将id类型转化为int
		int id=Integer.parseInt(n_id);
        /*		System.out.print("nid="+type);*/
		//根据id将浏览量+1
		new AddCountImpl().addStudentCultivateCount(id);
		
	    //获取该id的具体信息
		StudentCultivateBean stu_details=(StudentCultivateBean) new AllInfoDaoImpl<StudentCultivateBean>().getStudentCultivateInfo(id);
	    //获取最新新闻信息
		ArrayList<StudentCultivateBean> stu=(ArrayList<StudentCultivateBean>) new AllSimpleInfoDaoImpl<StudentCultivateBean>().getSimpleStudentCultivateInfo(type, 0, CommonConfig.UPDATE_PAGESIZE);
		
		request.setAttribute("type", type);
		request.setAttribute("item_current", stu);
	    request.setAttribute("item_details", stu_details);
	    request.getRequestDispatcher("./home/details/student_details.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
