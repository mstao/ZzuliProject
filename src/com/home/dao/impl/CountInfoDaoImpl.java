package com.home.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.db.DBMeans;

/** 
 * @ClassName: CountInfoDaoImpl 
 * @Description: TODO 获得数据总记录数   筛选掉未发布的
 * @date 2016年12月20日 上午10:47:10  
 */
public class CountInfoDaoImpl {
	
	
    /** 
     * @Title: getNewsCount 
     * @Description: TODO 根据type获取新闻公告的具体数量
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getNewsCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_news_type where type_flag='"+type+"' ";
	    rs=ss.Search(sql1);
	    int tid = 0;
	    try {
	    	while(rs.next()){
	    		tid=rs.getInt("id");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    String sql="select count(CASE WHEN news_type_id='"+tid+"' and is_publish=1 THEN 1 ELSE NULL END) from sys_news";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    
    /** 
     * @Title: getResearchCount 
     * @Description: TODO 根据type获取科学研究的具体数量 
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getResearchCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_research_type where type_flag='"+type+"'";
	    rs=ss.Search(sql1);
	    int tid = 0;
	    try {
	    	while(rs.next()){
	    		tid=rs.getInt("id");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    String sql="select count(CASE WHEN research_type_id='"+tid+"' and is_publish=1 THEN 1 ELSE NULL END) from sys_research ";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    /** 
     * @Title: getRulesCount 
     * @Description: TODO 根据type获取规章制度的具体数量 
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public  int getRulesCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(CASE WHEN is_publish=1 THEN 1 ELSE NULL END) from sys_rules";
	    rs=ss.Search(sql);
	    try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    /** 
     * @Title: getAchievementZhuanCount 
     * @Description: TODO 获取 成果转化的记录总数
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getAchievementZhuanCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_achievement_type where type_flag='"+type+"'";
	    rs=ss.Search(sql1);
	    int aid = 0;
	    try {
	    	while(rs.next()){
	    		aid=rs.getInt("id");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    String sql="select count(CASE WHEN achievement_type_id='"+aid+"' and is_publish=1 THEN 1 ELSE NULL END) from sys_achievement";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    /** 
     * @Title: getPersonCount 
     * @Description: TODO 获取人才队伍的记录总数
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getPersonCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	   
	    String sql="select count(CASE WHEN  is_publish=1 THEN 1 ELSE NULL END) from sys_person";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    /** 
     * @Title: getDocumentCount 
     * @Description: TODO  获取文档的数量 
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getDocumentCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	  
	    String sql="select count(*) from sys_file";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    public int getInstrumentCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	  
	    String sql="select count(CASE WHEN  is_publish=1 THEN 1 ELSE NULL END) from sys_instruments";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    public int getInstrumentRuleCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	  
	    String sql="select count(CASE WHEN  is_publish=1 THEN 1 ELSE NULL END) from sys_instrument_rule";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
    
    
    /**
     * 
    * @Title: getStudentCount
    * @Description: TODO 获取学生培养数量
    * @param @param type
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getStudentCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_student_cultivate_type where type_flag='"+type+"' ";
	    rs=ss.Search(sql1);
	    int tid = 0;
	    try {
	    	while(rs.next()){
	    		tid=rs.getInt("id");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
	    String sql="select count(CASE WHEN type_id='"+tid+"' and is_publish=1 THEN 1 ELSE NULL END) from sys_student_cultivate";
    	rs=ss.Search(sql);
    	try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
    	return count;
    }
}
