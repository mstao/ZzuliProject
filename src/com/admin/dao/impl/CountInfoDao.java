package com.admin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.db.DBMeans;

/** 
 * @ClassName: CountInfoDao 
 * @Description: TODO 获得数据总记录数   不筛选未发布的
 * @date 2016年12月28日 下午8:06:03  
 */
public class CountInfoDao {
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
	    String sql="select count(CASE WHEN news_type_id='"+tid+"'  THEN 1 ELSE NULL END) from sys_news";
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
	    String sql="select count(CASE WHEN research_type_id='"+tid+"'  THEN 1 ELSE NULL END) from sys_research ";
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
	    String sql="select count(*) from sys_rules";
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
     * @Description: TODO 获取 科研成果的记录总数
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getAchievement(String type){
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
	    String sql="select count(CASE WHEN achievement_type_id='"+aid+"' THEN 1 ELSE NULL END) from sys_achievement";
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
    public int getPersonCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_person_type where type_flag='"+type+"'";
	    rs=ss.Search(sql1);
	    int pid = 0;
	    try {
	    	while(rs.next()){
	    		pid=rs.getInt("id");
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    String sql="select count(CASE WHEN person_type_id='"+pid+"' THEN 1 ELSE NULL END) from sys_person";
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
     * @Title: getInstrumentRulesCount 
     * @Description: TODO 大型仪器 --规章制度 记录数 
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getInstrumentRulesCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_instrument_rule";
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
     * @Title: getInstrumentCount 
     * @Description: TODO 仪器设备的记录总数
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getInstrumentCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_instruments";
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
    public int getPersonCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_person";
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
     * @Title: getCommitteeCount 
     * @Description: TODO 根据类型获取委员会人的数量
     * @param @param type
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws 
     */
    public int getCommitteeCount(String type){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String  sql="";
	    if(type.equals("academia")){ //专家委员会
			sql="select count(*) from sys_academia_committee";
		}else if(type.equals("manage")){ //管理委员会
			sql="select count(*) from sys_manage_committee";
		}else if(type.equals("director")){//主任委员会
			sql="select count(*) from sys_director_committee";
		}
	    
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
    * @Title: getFoundationCount
    * @Description: TODO 获取国家自然科学基金项目数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getFoundationCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_project_foundation";
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
    * @Title: getProvincialCount
    * @Description: TODO 获取省部级重大项目 列表
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getProvincialCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_project_provincial";
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
    * @Title: getHorizontalCooperationCount
    * @Description: TODO 横向合作  数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getHorizontalCooperationCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_project_horizontal_cooperation";
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
    * @Title: getRewardCount
    * @Description: TODO 获取 奖励数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getRewardCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_result_awards";
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
    * @Title: getPatentCount
    * @Description: TODO 获取专利数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getPatentCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_result_patent";
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
    * @Title: getThesisCount
    * @Description: TODO 论文的数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getThesisCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_result_thesis";
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
    * @Title: getIdentificationCount
    * @Description: TODO获取 鉴定 数量
    * @param @return    设定文件
    * @return int    返回类型
    * @throws
     */
    public int getIdentificationCount(){
    	int count = 0;
    	ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql="select count(*) from sys_result_identification";
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
	    String sql="select count(CASE WHEN type_id='"+tid+"' THEN 1 ELSE NULL END) from sys_student_cultivate";
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
