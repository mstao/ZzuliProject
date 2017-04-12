package com.admin.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class EditorUploadImgServiet
 */
/** 
 * @ClassName: EditorUploadImgServiet 
 * @Description: TODO  编辑器中的图片上传处理
 * @date 2016年12月24日 上午10:46:15  
 */
@WebServlet("/EditorUploadImgServlet")
@MultipartConfig
public class EditorUploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorUploadImgServlet() {
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
	        Part part = request.getPart("myEditorImgName");// myFileName是文件域的name属性值
	        // 文件类型限制
	        String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
	        boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
	        if (!allowed) {
	            response.getWriter().write("error|不支持的类型");
	            return;
	        }
	        // 图片大小限制
	        if (part.getSize() > 5 * 1024 * 1024) {
	            response.getWriter().write("error|图片大小不能超过5M");
	            return;
	        }
	        // 包含原始文件名的字符串
	        String fi = part.getHeader("content-disposition");
	        // 提取文件拓展名
	        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
	        // 生成实际存储的真实文件名
	        String realName = UUID.randomUUID().toString() + fileNameExtension;
	        //图片保存文件夹路径
	        String path= getServletContext().getRealPath("/Uploads/images");
	        //如果没有该文件目录，则创建
	        new java.io.File( path ).mkdir();
	        // 图片存放的真实路径
	        String realPath = getServletContext().getRealPath("/Uploads/images") + "/" + realName;
	       
	        // 将文件写入指定路径下
	        part.write(realPath);

	        // 返回图片的URL地址
	        response.getWriter().write(request.getContextPath() + "/Uploads/images/" + realName);
	}

}
