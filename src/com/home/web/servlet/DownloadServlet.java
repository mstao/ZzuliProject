package com.home.web.servlet;

import java.io.File;
import java.io.FileInputStream;    
import java.io.IOException;  
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
/** 
 * @ClassName: DownloadServlet 
 * @Description: TODO 文件下载 
 * @date 2016年12月26日 下午8:55:01  
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");
		//得到要下载的文件名
		/*String fileName =new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8"); 
		String realname = new String(request.getParameter("realname").getBytes("ISO-8859-1"),"UTF-8");*/
		String fileName=request.getParameter("filename");
		String realname=request.getParameter("realname");

		String userAgent = request.getHeader("User-Agent");
		System.out.println(fileName);
		//上传的文件都是保存在/Uploads/files
		String fileSaveRootPath=this.getServletContext().getRealPath("/Uploads/files");

		//得到要下载的文件
		File file = new File(fileSaveRootPath +"/"+ realname);
		//如果文件不存在
		if(!file.exists()){
			//request.setAttribute("message", "您要下载的资源已被删除！！");
			System.out.println("文件找不到");
			return;
		}
		//针对IE或者以IE为内核的浏览器：
		if (userAgent.contains("MSIE")||userAgent.contains("Trident")) {
		 fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		 fileName = fileName.replace("+", "%20");// 处理空格变“+”的问题
		} else {
		//非IE浏览器的处理：
		fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
	
		/*URLEncoder.encode(fileName, "UTF-8")*/
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=\"" + fileName + "\"");
		response.setContentType( "application/x-msdownload");
		//读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + realname);
		//创建输出流
		OutputStream out = response.getOutputStream();
		//创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		//循环将输入流中的内容读取到缓冲区当中
		while((len=in.read(buffer))>0){
			//输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		//关闭文件输入流
		in.close();
		//关闭输出流
		out.close();
	}
		 
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
