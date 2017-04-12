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
import com.home.util.PageHelper;
import com.home.web.service.InstrumentsBean;

/**
 * Servlet implementation class LoadInstrumentInfoServlet
 */
@WebServlet("/LoadInstrumentInfoServlet")
public class LoadInstrumentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadInstrumentInfoServlet() {
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
		int pCount=new CountInfoDaoImpl().getInstrumentCount();

		//设置每页显示的数据量
		int item_pre_page=CommonConfig.PERSON_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据偏移量获取对应数据
		ArrayList<InstrumentsBean> instrument=(ArrayList<InstrumentsBean>) new AllSimpleInfoDaoImpl<InstrumentsBean>().getSimpleInstrumentInfo(position, item_pre_page);
		//分页工具类
		PageHelper phelper = new PageHelper();
		//设置总记录数
		phelper.setTotal(pCount);
		//设置每页显示记录数量
		phelper.setPageSize(item_pre_page);
		//设置当前页码
		phelper.setIndex(p);
		//设置url
        String url="./instrument.do?p=";
        //去掉 url中的单引号
        url=url.replace("'", "");
		phelper.setPath(url); 
		//获取导航条
		String toolbar=phelper.getPageHTML();
		request.setAttribute("toolbar", toolbar);
		request.setAttribute("instrument", instrument);
		request.getRequestDispatcher("./home/instrument/instrument.jsp").forward(request, response); 
	}

}
