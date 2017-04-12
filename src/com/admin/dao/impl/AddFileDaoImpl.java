package com.admin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.util.GetDateUtil;
import com.home.db.DB;


/** 
 * @ClassName: AddFileDaoImpl 
 * @Description: TODO 将文件信息写入数据库
 * @date 2016年12月26日 下午2:57:36  
 */
public class AddFileDaoImpl {
	public void  AddFile(int item_id,String type,String filename,String realname){
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据type获取类型id
		int type_id=new AllTypeIdImpl().getFileTypeId(type);
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="insert into sys_file(file_name,real_name,file_belong_id,add_time,item_id) values('"+filename+"','"+realname+"','"+type_id+"','"+c_data+"','"+item_id+"')";
		stmt.executeUpdate(sql1);
		con.commit();
		}catch(Exception e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.setAutoCommit(true);
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
