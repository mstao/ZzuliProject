package com.home.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.CommonConfig;
import com.home.dao.impl.AllSimpleInfoDaoImpl;
import com.home.dao.impl.CountInfoDaoImpl;
import com.home.dao.impl.FunctionDaoImpl;
import com.home.util.PageHelper;
import com.home.web.service.StudentCultivateBean;

/**
 * Servlet implementation class LoadStudentInfoServlet
 */
/**
 * 
* @ClassName: LoadStudentInfoServlet
* @Description: TODO 获取学生培养列表
* @author Mingshan
* @date 2017年4月13日 下午4:12:44
*
 */
@WebServlet("/LoadStudentInfoServlet")
public class LoadStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadStudentInfoServlet() {
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
        request.setCharacterEncoding("UTF-8");
		//获取信息类型
		String type=request.getParameter("type");
		//获取当前页 
		String sp=request.getParameter("p");
		
		//根据类型获取类型名称
		String type_name=new FunctionDaoImpl().getStudentTypeName(type);
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}
		
		//根据信息类型获取信息的总记录数值
		int newsCount=new CountInfoDaoImpl().getStudentCount(type);

		//设置每页显示的数据量
		int item_pre_page=CommonConfig.HOME_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取对应数据
		ArrayList<StudentCultivateBean> student=(ArrayList<StudentCultivateBean>) new AllSimpleInfoDaoImpl<StudentCultivateBean>().getSimpleStudentCultivateInfo(type, position, item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(newsCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./student.do?type='"+type+"'&p=";
        //去掉 url中的单引号
        url=url.replace("'", "");
		phelper.setPath(url); 		

		 
		request.setAttribute("type_name", type_name);
		request.setAttribute("stu", student);
		request.getRequestDispatcher("./home/student/student.jsp").forward(request, response); 
	}

}
