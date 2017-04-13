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
import com.home.util.PageHelper;
import com.home.web.service.ResultPatentBean;

/**
 * Servlet implementation class ShowResultPatentListServlet
 */
/**
 * 
* @ClassName: ShowResultPatentListServlet
* @Description: TODO 专利
* @author Mingshan
* @date 2017年4月12日 下午1:25:52
*
 */
@WebServlet("/ShowResultPatentListServlet")
public class ShowResultPatentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResultPatentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sp=request.getParameter("p");
		int p;
		if(sp.equals("")){
			p=1;
		}else{
			//将当前页转化为整形
			p=Integer.parseInt(sp);
		}		
		
		//获取记录总数值
		int rCount=new CountInfoDao().getPatentCount();
		//设置每页显示的数据量
		int item_pre_page=CommonConfig.ADMIN_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取相应的信息
		ArrayList<ResultPatentBean> patent=(ArrayList<ResultPatentBean>) new AdminSimpleInfoDaoImpl<ResultPatentBean>().getSimplePatentInfo(position, item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(rCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./showpatent.ado?p=";
		phelper.setPath(url); 
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("patent", patent);
		request.setAttribute("toolbar", toolbar);
		request.getRequestDispatcher("./admin/result/patentList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
