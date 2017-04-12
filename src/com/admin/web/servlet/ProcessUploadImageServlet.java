
package com.admin.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class ProcessUploadImageServlet
 */
/** 
 * @ClassName: ProcessUploadImageServlet 
 * @Description: TODO 仪器设备  上传图片
 * @date 2016年12月31日 下午2:12:11  
 */
@WebServlet("/ProcessUploadImageServlet")
public class ProcessUploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessUploadImageServlet() {
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
		System.out.println("I am a serlvet to process upload!!!");
/*		System.out.println(request.getParameter("item_id"));
        System.out.println(request.getParameter("item_type"));*/
      //  String  item_type=request.getParameter("item_type");
        
		request.setCharacterEncoding( "UTF-8" );	// 从request中取时, 以UTF-8编码解析

		//工厂 
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

		// 获取上传文件存放的 目录 , 无则创建
		String path = getServletContext().getRealPath( "/Uploads/images" );
		System.out.println("path : " + path);

		new java.io.File( path ).mkdir();
		/** 
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，  
         * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的  
         * 然后再将其真正写到 对应目录的硬盘上 
         */  
		diskFileItemFactory.setRepository( new File( path ) );
		//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室 
        diskFileItemFactory.setSizeThreshold( 1024*1024 );
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory); 
        try
        {
        	// 可上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest( request );
            for (FileItem item : list )
            {
                //获取提交的表单文件名
                String name = item.getFieldName();

                // 字符串类 属性
                if ( item.isFormField() )
                {
                    String value = item.getString();
                    System.out.println(name + "=+" + value);
                  
                } 
                // 二进制类
                else 
                {
                	// 获取上传文件的名字                   
                    String value = item.getName();  // 1,获取路径            
                    int start = value.lastIndexOf( "\\" );// 2,索引到最后一个反斜杠
                    String filename = value.substring( start+1 );//3, 截取(+1是去掉反斜杠) 

                    System.out.println( name + "=" + value );

                    File file = null;
                    do {  
                    	// 生成文件名
                        start = filename.lastIndexOf( "." );    // 索引到最后一个点
                        filename = filename.substring( 0, start )    // 不含扩展名的文件
                                    + UUID.randomUUID().toString()   // 随机数
                                    + filename.substring( start );  //  扩展名
                        file = new File(path, filename);  
                    } while (file.exists());  
                    //文件最后处理后的名称
                    System.out.println( "filename=" + filename );
                    //文件处理后最后的路径，用于存到数据库(文件路径)
                    String filePath=request.getContextPath() + "/Uploads/images/" + filename;
                    System.out.println( "filePath=" + filePath);
                    // 写到磁盘上去
                    item.write( file );
     
                    System.out.println( "the upload file's size:" + item.getSize() );
                   
                    // new AddFileDaoImpl().AddFile(item_id, item_type, value, filename);
                    // String  showfilepath="/Uploads/files/" + filename;
                    PrintWriter out = response.getWriter();
            		out.write(filePath);
            		out.flush();
            		out.close();
                }


            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}

}
