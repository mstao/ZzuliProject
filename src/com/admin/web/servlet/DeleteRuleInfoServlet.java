package com.admin.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.impl.DeleteContentDaoImpl;

/**
 * Servlet implementation class DeleteRuleInfoServlet
 */
/** 
 * @ClassName: DeleteRuleInfoServlet 
 * @Description: TODO 删除规章制度信息 
 * @date 2016年12月29日 下午2:10:49  
 */
@WebServlet("/DeleteRuleInfoServlet")
public class DeleteRuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRuleInfoServlet() {
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
		String ids=new String(request.getParameter("ids").getBytes("ISO-8859-1"),"UTF-8");
		String rs;		
        String[] idArray = ids.split(",");
        //进行批量删除
        boolean flag=new DeleteContentDaoImpl().deleteRule(idArray);
        if(flag==true){
        	rs="1";
        }else{
        	rs="0";
        }     
		
		PrintWriter out = response.getWriter();
		out.write(rs);
		out.flush();
		out.close();
	}

}
