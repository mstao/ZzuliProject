package com.home.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMeans {
	   Connection con=null;
	   Statement stmt=null;
	   ResultSet rs=null;
	   public int flag;
       public ResultSet Search(String sql){
    	   try{
		   con=DB.getConn();
		   stmt=DB.getStmt(con);
    	   rs=DB.executeQuery(stmt, sql);
    	   }catch(Exception e){
    		   e.printStackTrace();
    	   }
    	   return rs;
       }
      
       //添加
        public int Add(String sql){
		   con=DB.getConn();
		   stmt=DB.getStmt(con);
    	try {
			flag=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return flag;
	   }
        //更新
        public int Update(String sql){
           con=DB.getConn();
 		   stmt=DB.getStmt(con);
     	try {
 			flag=stmt.executeUpdate(sql);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		   return flag;
        }
        public void closeAll(){
    	   DB.clossAll(rs, stmt, con);
       }
        public void closeBu(){
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
