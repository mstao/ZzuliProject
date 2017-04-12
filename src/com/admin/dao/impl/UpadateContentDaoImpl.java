package com.admin.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.dao.IUpdateContentDao;
import com.admin.util.GetDateUtil;
import com.home.db.DB;


/** 
 * @ClassName: UpadateContentDaoImpl 
 * @Description: TODO 更新信息 
 * @date 2016年12月28日 下午4:39:22  
 */
public class UpadateContentDaoImpl implements IUpdateContentDao {

	/* (non-Javadoc)
	 * @see com.admin.dao.IUpdateContentDao#upadteIntroInfo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 更新实验室简介信息
	 */
	@Override
	public boolean upadteIntroInfo(int id, String content,
			 String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_intro  set item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateNewsInfo(int, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * 更新新闻公告信息
	 */
	@Override
	public boolean updateNewsInfo(int id, String title,String content, 
			String author, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_news  set item_title='"+title+"', item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"',is_image='"+is_image+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateRuleInfo(int, java.lang.String, java.lang.String, java.lang.String, int)
	 * 更新规章制度信息
	 */
	@Override
	public boolean updateRuleInfo(int id, String title, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_rules  set rule_title='"+title+"', rule_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateResearchInfo(int, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * 更好科学研究信息
	 */
	@Override
	public boolean updateResearchInfo(int id, String title, String content,
			String author, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_research  set item_title='"+title+"', item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"',is_image='"+is_image+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateStudentInfo(int, java.lang.String, java.lang.String, int)
	 * 更改学生培养信息
	 */
	@Override
	public boolean updateStudentInfo(int id, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_student  set item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateEmployInfo(int, java.lang.String, java.lang.String, int)
	 * 更新人才招聘信息
	 */
	@Override
	public boolean updateEmployInfo(int id, String content, String author,
			int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_employ  set content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateContactInfo(int, java.lang.String, java.lang.String, int)
	 * 更新联系我们信息
	 */
	@Override
	public boolean updateContactInfo(int id, String content, String author,
			int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_contact  set content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateAchievementZhuan(int, java.lang.String, java.lang.String, java.lang.String, int)
	 *  更新科研成果 --成果转化
	 */
	@Override
	public boolean updateAchievementZhuan(int id, String title, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_achievement  set item_title='"+title+"', item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateAchievementOther(int, java.lang.String, java.lang.String, int)
	 * 更新 科研成果 --其他项
	 */
	@Override
	public boolean updateAchievementOther(int id, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_achievement  set  item_content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateInstrumentRuleInfo(int, java.lang.String, java.lang.String, java.lang.String, int)
	 * 更新大型仪器-规章制度
	 */
	@Override
	public boolean updateInstrumentRuleInfo(int id, String title,
			String content, String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_instrument_rule  set title='"+title+"', content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateInstrumentInfo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 更新 大型仪器 --仪器设备信息
	 */
	@Override
	public boolean updateInstrumentInfo(int id, String name, String content,
			String author, String img_url, String url, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_instruments set instrument_name='"+name+"', instrument_info='"+content+"',instrument_image='"+img_url+"',instrument_url='"+url+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updatePersonIntroInfo(int, java.lang.String, java.lang.String, int)
	 * 更新 人才队伍现状
	 */
	@Override
	public boolean updatePersonIntroInfo(int id, String content, String author,
			int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_person_intro  set content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updatePersonInfo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * 更新骨干信息
	 */
	@Override
	public boolean updatePersonInfo(int id, String person_name,
			String person_info, String avatar_file, String person_post,
			String author, int is_gugan, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_person  set person_name='"+person_name+"',person_info='"+person_info+"',avatar_file='"+avatar_file+"',person_post='"+person_post+"',is_gugan='"+is_gugan+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateCommitteeIntroInfo(int, java.lang.String, java.lang.String, int)
	 * 更新委员会介绍信息
	 */
	@Override
	public boolean updateCommitteeIntroInfo(int id, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_committee_intro  set content='"+content+"',add_time='"+c_date+"' , is_publish='"+is_publish+"', author='"+author+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateDirectorCommitteeInfo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 修改 实验室主任委员会人员信息
	 */
	@Override
	public boolean updateDirectorCommitteeInfo(int id, String name,
			String birthday, String sex, String post, String title,
			String research, String unit, String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		String sql1="update sys_director_committee set name='"+name+"',birthday='"+birthday+"',sex='"+sex+"',post='"+post+"',title='"+title+"',research='"+research+"',unit='"+unit+"',author='"+author+"',is_publish='"+is_publish+"',add_time='"+c_date+"' where id='"+id+"'";
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
	 * @see com.admin.dao.IUpdateContentDao#updateCommitteeInfo(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 修改委员
	 */
	@Override
	public boolean updateCommitteeInfo(int id, String type, String name,
			String birthday, String sex, String post, String title,
			String research, String unit, String author, int is_publish) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection con=(Connection) DB.getConn();
		//获取当前时间
		String c_date=GetDateUtil.getData();
		
		try{
		con.setAutoCommit(false);
		stmt=(Statement) DB.getStmt(con);   
		
		String sql="";
		if(type.equals("manage")){
			//根据post获取post_id
			int post_id=new AllTypeIdImpl().getPostTypeId(post);
			sql="update sys_manage_committee set name='"+name+"',birthday='"+birthday+"',sex='"+sex+"',post_id='"+post_id+"',title='"+title+"',research='"+research+"',unit='"+unit+"',author='"+author+"',is_publish='"+is_publish+"',add_time='"+c_date+"' where id='"+id+"'";
		}else if(type.equals("academia")){
			//根据post获取post_id
			int post_id=new AllTypeIdImpl().getPostTypeId(post);
			sql="update sys_academia_committee set name='"+name+"',birthday='"+birthday+"',sex='"+sex+"',post_id='"+post_id+"',title='"+title+"',research='"+research+"',unit='"+unit+"',author='"+author+"',is_publish='"+is_publish+"',add_time='"+c_date+"' where id='"+id+"'";
		}else if(type.equals("director")){
			sql="update sys_director_committee set name='"+name+"',birthday='"+birthday+"',sex='"+sex+"',post='"+post+"',title='"+title+"',research='"+research+"',unit='"+unit+"',author='"+author+"',is_publish='"+is_publish+"',add_time='"+c_date+"' where id='"+id+"'";
		}
		
		stmt.executeUpdate(sql);
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
