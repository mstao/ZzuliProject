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
 * Servlet implementation class UpdateInstrumentRuleInfoServlet
 */
/** 
 * @ClassName: UpdateInstrumentRuleInfoServlet 
 * @Description: TODO 更新 大型仪器--规章制度信息
 * @date 2016年12月31日 上午9:42:07  
 */
@WebServlet("/UpdateInstrumentRuleInfoServlet")
public class UpdateInstrumentRuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInstrumentRuleInfoServlet() {
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
		String title=request.getParameter("title");
	    String content=request.getParameter("content");
	    String author=request.getParameter("author");
	    String s_is_publish=request.getParameter("is_publish");
	    
	   // System.out.println(content+"----"+title+"-----"+author);
	    //将id转为整形
	    int nid=Integer.parseInt(s_id);
        //将is_publish 转为整形	
	    int is_publish=Integer.parseInt(s_is_publish);
	    boolean bid=new UpadateContentDaoImpl().updateInstrumentRuleInfo(nid, title, content, author, is_publish);
	    String rs;
	    
	    if(bid==true){
	    	rs=String.valueOf(nid);
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
