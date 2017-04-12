package com.admin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.dao.IAllTypeId;
import com.home.db.DBMeans;

/** 
 * @ClassName: AllTypeIdImpl 
 * @Description: TODO 获取类型id
 * @date 2016年12月25日 下午8:03:38  
 */
public class AllTypeIdImpl implements IAllTypeId
{

	/* (non-Javadoc)
	 * @see com.admin.dao.IAllTypeId#getNewsTypeId(java.lang.String)
	 * 获取新新闻公告类型id
	 * 
	 */
	@Override
	public int getNewsTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_news_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	@Override
	public int getFileTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_file_belong where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAllTypeId#getResearchTypeId(java.lang.String)
	 * 获取科学研究类型id
	 */
	@Override
	public int getResearchTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_research_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }
			ss.closeAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAllTypeId#getAchievementTypeId(java.lang.String)
	 * 获取科研成果的类型id
	 */
	@Override
	public int getAchievementTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_achievement_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }
			ss.closeAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAllTypeId#getIntroduceTypeId(java.lang.String)
	 * 获取实验室简介相关类型id
	 */
	@Override
	public int getIntroduceTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_intro_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	@Override
	public int getStudentTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_student_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	@Override
	public int getPostTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_post_style where post_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	@Override
	public int getCommitteeIntroTypeId(String type_flag) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    //根据type查询出类型id
	    String sql1="select id from sys_committee_intro_type where type_flag='"+type_flag+"'";
	    rs=ss.Search(sql1);
	    int id=0;
	    try {
	    	while(rs.next()){
	    		id=rs.getInt("id");
	        }
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			ss.closeAll();
		}
	    
	    return id;
	}

	
	
	
	
}
