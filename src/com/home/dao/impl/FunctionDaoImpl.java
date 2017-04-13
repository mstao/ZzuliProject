package com.home.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.db.DBMeans;


/** 
 * @ClassName: FunctionDaoImpl 
 * @Description: TODO  一些常用操作
 * @date 2016年12月20日 下午4:20:35  
 */
public class FunctionDaoImpl {
    
	
	/** 
	 * @Title: getTypeName 
	 * @Description: TODO 根据类型标志获取类型名称 
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String getNewsTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_news_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	/** 
	 * @Title: getResearchTypeName 
	 * @Description: TODO 根据类型标志获取类型名称  
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public  String getResearchTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_research_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	/** 
	 * @Title: getIntroduceTypeName 
	 * @Description: TODO 根据类型标志获取类型名称   
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String getIntroduceTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_intro_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	/** 
	 * @Title: getStudentTypeName 
	 * @Description: TODO  根据类型标志获取类型名称  
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String getStudentTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_student_cultivate_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	/** 
	 * @Title: getAchievementTypeName 
	 * @Description: TODO 根据类型标志获取类型名称
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String getAchievementTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_achievement_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	/** 
	 * @Title: getPersonTypeName 
	 * @Description: TODO 根据类型标志获取类型名称 
	 * @param @param type_flag
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String getPersonTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_person_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
	
	public String getCommitteeIntroTypeName(String type_flag){
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select type_name from sys_committee_intro_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    String type_name = null;
	    try {
	    	while(rs.next()){
	    		type_name=rs.getString("type_name");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    
	    return type_name;
	}
}
