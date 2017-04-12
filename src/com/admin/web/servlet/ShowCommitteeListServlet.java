package com.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.AdminAllInfoDaoImpl;
import com.admin.dao.impl.AdminSimpleInfoDaoImpl;
import com.admin.dao.impl.CountInfoDao;
import com.global.CommonConfig;
import com.home.util.PageHelper;
import com.home.web.service.CommitteeBean;
import com.home.web.service.CommitteeIntroBean;

/**
 * Servlet implementation class ShowCommitteeListServlet
 */
/** 
 * @ClassName: ShowCommitteeListServlet 
 * @Description: TODO 获取委员会人员信息
 * @date 2017年1月1日 下午3:54:19  
 */
@WebServlet("/ShowCommitteeListServlet")
public class ShowCommitteeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCommitteeListServlet() {
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
		
		//获取当前页 
		String sp=new String(request.getParameter("p").getBytes("ISO-8859-1"),"UTF-8");
		
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}
		
		//根据信息类型获取信息的总记录数值
		int Count=new CountInfoDao().getCommitteeCount(type);

		//设置每页显示的数据量
		int item_pre_page=CommonConfig.ADMIN_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据类型和偏移量获取对应数据
		ArrayList<CommitteeBean> committee=(ArrayList<CommitteeBean>) new AdminSimpleInfoDaoImpl<CommitteeBean>().getSimpleCommitteeInfo(type, position, item_pre_page);
		//根据类型获取获取 委员会的介绍信息
		String intro_type="";
		if(type.equals("academia")){ //专家委员会
			intro_type="xsw";
		}else if(type.equals("manage")){ //管理委员会
			intro_type="glw";
		}else if(type.equals("director")){//主任委员会
			intro_type="szw";
		}
		ArrayList<CommitteeIntroBean> committeeintro=(ArrayList<CommitteeIntroBean>) new AdminAllInfoDaoImpl<CommitteeIntroBean>().getCommitteeIntroInfo(intro_type);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(Count);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./showcommittee.ado?type='"+type+"'&p=";
        //去掉 url中的单引号
        url=url.replace("'", "");
		phelper.setPath(url); 
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("toolbar", toolbar);
		request.setAttribute("committee", committee);
		request.setAttribute("committeeintro", committeeintro);
		if(type.equals("academia")){ //专家委员会
			request.getRequestDispatcher("./admin/introduce/showAcademiaCommittee.jsp").forward(request, response); 
		}else if(type.equals("manage")){ //管理委员会
			request.getRequestDispatcher("./admin/introduce/showManageCommittee.jsp").forward(request, response); 
		}else if(type.equals("director")){//主任委员会
			request.getRequestDispatcher("./admin/introduce/showDirectorCommittee.jsp").forward(request, response); 
		}
	}

}
