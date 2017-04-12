package com.home.db;


import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB{	
	
	/*	
	 * 获取Connection对象,这里用到了数据库连接池获取
	 *
	 */
	
	public static Connection getConn(){
		Connection conn=null;			
		try {
				Context initContext = new InitialContext();   
			    Context envContext  = (Context)initContext.lookup("java:/comp/env");   
			    DataSource ds;
				ds = (DataSource)envContext.lookup("jdbc/webdb");
				try {
					conn = ds.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		      
			/*Class.forName(ReadDbConfig.DBDriver);
			conn=DriverManager.getConnection(ReadDbConfig.DBURL,ReadDbConfig.DBUSER,ReadDbConfig.DBPASS);*/
		
		return conn;
	}
	

	/*	
	 * 获取Statement对象
	 *
	 */
	public static Statement getStmt(Connection conn){
		Statement stmt=null;
		if(conn!=null){
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("创建Statement对象时发生异常");
			}
		}else{
			System.out.println("conn对象不存在，无法创建Statement对象");
		}
		return stmt;
	}
	/*	
	 * 获取PreparedStatement对象
	 * 
	 */
	public static PreparedStatement getPstmt(Connection conn,String sql){
		PreparedStatement pstmt = null;
		if(conn!=null){
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("创建preparedStatement对象时发生异常");
			}
		}else{
			System.out.println("conn对象不存在，无法创建PreparedStatement对象");
		}
		return pstmt;
	}
	/*	
	 * 获取ResultSet对象
	 * 
	 */
	public static ResultSet executeQuery(Statement stmt,String sql){
		ResultSet rs=null;
				try {
					rs=stmt.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("创建ResultSet对象发生异常");
				}	
		return rs;
	}
	/*	
	 * 重载获取ResultSet对象(查询)
	 *
	 */
	public static ResultSet getRs(PreparedStatement pstmt){
		ResultSet rs=null;
		if(pstmt!=null){
			try {
				rs=pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("获取rs对象失败");
			}
		}else{
			System.out.println("pstmt流不存在");
		}
		return rs;
	}
	/*	
	 * 重载获取ResultSet对象(查询) Statement对象
	 */
	public static ResultSet getRs(Connection conn,String sql){
		ResultSet rs=null;
		if(conn!=null&&sql!=null){	
			try {
					rs=conn.createStatement().executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("创建RS对象时发生错误");
				}
		}else{
			System.out.println("conn流不存在或sql语句不存在");
		}
		return rs;
	}
	/*
	 * 流的关闭相关重载
	 * 
	 */
		public static void close(Connection conn){
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("你要关闭的conn流不存在");
			}
		}
		public static void close(Statement stmt){
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("你要关闭的stmt流不存在");
			}
		}
		public static void close(ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("你要关闭的rs流不存在");
			}
		}
		
		// 关闭所有连接
		public static void clossAll(ResultSet rs,Statement stmt,Connection con){
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
