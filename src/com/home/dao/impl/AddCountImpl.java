package com.home.dao.impl;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.home.dao.IAddCount;
import com.home.db.DB;


/** 
 * @ClassName: AddCountImpl 
 * @Description: TODO 浏览量+1 实现类 
 * @date 2016年12月21日 上午11:16:15  
 */
public class AddCountImpl implements IAddCount {

	/* (non-Javadoc)
	 * @see com.home.dao.IAddCount#addNewsCount(int)
	 * 
	 *  新闻公告的浏览量+1  用事务处理
	 */
	@Override
	public boolean addNewsCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_news sn set sn.view_count=sn.view_count+1 where sn.id='"+id+"'";
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

	@Override
	public boolean addRuleCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_rules r set r.view_count=r.view_count+1 where r.id='"+id+"'";
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

	@Override
	public boolean addResearchCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_research r set r.view_count=r.view_count+1 where r.id='"+id+"'";
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

	/* (non-Javadoc)
	 * @see com.home.dao.IAddCount#addPersonCount(int)
	 * 人才骨干浏览量+1
	 */
	@Override
	public boolean addPersonCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_person p set p.view_count=p.view_count+1 where p.id='"+id+"'";
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
	
	/** 
	 * @Title: addAchievementZhuan 
	 * @Description: TODO 根据id将成果转化浏览量+1
	 * @param @param id
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws 
	 */
	public boolean addAchievementZhuanCount(int id){
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_achievement a set a.view_count=a.view_count+1 where a.id='"+id+"'";
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

	@Override
	public boolean addInstrumentCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_instruments a set a.view_count=a.view_count+1 where a.id='"+id+"'";
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

	@Override
	public boolean addInstrumentRuleCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_instrument_rule a set a.view_count=a.view_count+1 where a.id='"+id+"'";
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

	@Override
	public boolean addStudentCultivateCount(int id) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_student_cultivate a set a.view_count=a.view_count+1 where a.id='"+id+"'";
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
