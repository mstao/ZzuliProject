package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.UpadateContentDaoImpl;

/**
 * Servlet implementation class UpdateInstrumentInfoServlet
 */
/** 
 * @ClassName: UpdateInstrumentInfoServlet 
 * @Description: TODO 更新仪器设备信息
 * @date 2016年12月31日 下午5:08:32  
 */
@WebServlet("/UpdateInstrumentInfoServlet")
public class UpdateInstrumentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInstrumentInfoServlet() {
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
		response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
		String s_id=request.getParameter("id");
		String name=request.getParameter("name");
	    String content=request.getParameter("content");
	    String ins_url=request.getParameter("ins_url");
	    String img_url=request.getParameter("img_url");
	    String author=request.getParameter("author");
	    String s_is_publish=request.getParameter("is_publish");

	    
	   // System.out.println(content+"----"+title+"-----"+author);
	    //将id转为整形
	    int id=Integer.parseInt(s_id);
        //将is_publish 转为整形	
	    int is_publish=Integer.parseInt(s_is_publish);

	    boolean bid=new UpadateContentDaoImpl().updateInstrumentInfo(id, name, content, author, img_url, ins_url, is_publish);
	    String rs;
	    
	    if(bid==true){
	    	rs=String.valueOf(id);
	    }else{
	    	rs="0";
	    }
	    //System.out.println(id);
		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

}
