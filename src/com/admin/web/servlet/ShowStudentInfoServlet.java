package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminSimpleInfoDaoImpl;
import com.admin.dao.impl.CountInfoDao;
import com.global.CommonConfig;


import com.home.dao.impl.FunctionDaoImpl;
import com.home.util.PageHelper;
import com.home.web.service.StudentCultivateBean;

/**
 * Servlet implementation class ShowStudentInfoServlet
 */
/** 
 * @ClassName: ShowStudentInfoServlet 
 * @Description: TODO 加载学生培养信息
 * @date 2016年12月29日 下午8:50:31  
 */
@WebServlet("/ShowStudentInfoServlet")
public class ShowStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentInfoServlet() {
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
		String type=request.getParameter("type");
		//根据类型获取类型名称
		String type_name=new FunctionDaoImpl().getStudentTypeName(type);
		//获取当前页 
		String sp=request.getParameter("p");
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}
		
		//根据信息类型获取信息的总记录数值
		int newsCount=new CountInfoDao().getStudentCount(type);

		//设置每页显示的数据量
		int item_pre_page=CommonConfig.HOME_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取对应数据
		ArrayList<StudentCultivateBean> student=(ArrayList<StudentCultivateBean>) new AdminSimpleInfoDaoImpl<StudentCultivateBean>().getSimpleStudentInfo(type, position, item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(newsCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./showstudent.ado?type='"+type+"'&p=";
        //去掉 url中的单引号
        url=url.replace("'", "");
		phelper.setPath(url); 		
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("stu", student);
		request.setAttribute("type_name", type_name);
		request.setAttribute("type", type);
		request.setAttribute("toolbar", toolbar);
		request.getRequestDispatcher("./admin/student/showStudent.jsp").forward(request, response); 
	}

}
