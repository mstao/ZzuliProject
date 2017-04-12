package com.admin.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.dao.ILoginDao;
import com.admin.util.MD5Util;
import com.home.db.DB;
import com.home.db.DBMeans;

/** 
 * @ClassName: LoginDaoImpl 
 * @Description: TODO 用户登录处理 
 * @date 2016年12月22日 下午7:44:51  
 */
public class LoginDaoImpl implements ILoginDao{
   
	/* (non-Javadoc)
	 * @see com.admin.dao.LoginDao#loginValid(java.lang.String, java.lang.String)
	 * 验证用户 用户和密码(MD5加密验证)
	 */
	public boolean loginValid(String username,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String pwdInDb = (String)this.getPassword(username);
		 if(null!=pwdInDb){ // 该用户存在
		  
		 return MD5Util.validPassword(password, pwdInDb);
		 }else{
		 System.out.println("用户名和密码不匹配");
		 return false;
		 }
	}
	
	/* (non-Javadoc)
	 * @see com.admin.dao.impl.LoginDao#getPassword(java.lang.String)
	 * 通过用户名获取用户密码(经过MD5加密)
	 */
	public String getPassword(String userName){
		ResultSet rs=null;
		String passWord = null;
	    DBMeans ss=new DBMeans();
	    String sql="select password from sys_user where username='"+userName+"'";
	    rs=ss.Search(sql);
	    try {
			while(rs.next()){
				passWord=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    return passWord;
	}
	
	
	/* (non-Javadoc)
	 * @see com.admin.dao.LoginDao#registerUser(java.lang.String, java.lang.String)
	 * 注册用户  ,该功能不对外提供,仅测试和添加管理用户
	 */
	public  void registerUser(String username,String password){
		 String encryptedPwd = null;
		 DBMeans ss=new DBMeans();
		 try {
		  encryptedPwd = MD5Util.getEncryptedPwd(password);
		  String sql="insert into sys_user(username,password) values ('"+username+"','"+encryptedPwd+"')";
		  ss.Add(sql);

		 } catch (NoSuchAlgorithmException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (UnsupportedEncodingException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }finally{
				ss.closeAll();
		}
		 
		
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.ILoginDao#updatePassword(java.lang.String, java.lang.String)
	 * 修改密码
	 */
	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();

		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con); 
		//密码经过MD5加密
		String  md_password=MD5Util.getEncryptedPwd(password);
		String sql1="update sys_user set password='"+md_password+"' where username='"+username+"'";
		stmt.executeUpdate(sql1);
		con.commit();

		return true;
		}catch(Exception e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
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
