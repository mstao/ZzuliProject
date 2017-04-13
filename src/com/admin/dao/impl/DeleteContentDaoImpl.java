package com.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.admin.dao.IDeleteContentDao;
import com.home.db.DB;

/** 
 * @ClassName: DeleteContentDaoImpl 
 * @Description: TODO 删除信息 (批处理)
 * @date 2016年12月29日 上午10:36:35  
 */
public class DeleteContentDaoImpl implements IDeleteContentDao {

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteNews(java.lang.String[])
	 * 删除新闻公告信息
	 */
	@Override
	public boolean deleteNews(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_news where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;  
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteRule(java.lang.String[])
	 *  删除规章制度信息
	 */
	@Override
	public boolean deleteRule(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_rules where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;  
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteResearch(java.lang.String[])
	 * 
	 * 删除科学研究信息
	 */
	@Override
	public boolean deleteResearch(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_research where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteDocument(java.lang.String[])
	 * 删除文档
	 */
	@Override
	public boolean deleteDocument(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_file where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteAchievement(java.lang.String[])
	 *  删除科研成果
	 */
	@Override
	public boolean deleteAchievement(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_achievement where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteInstrumentRule(java.lang.String[])
	 * 删除 大型仪器-规章制度
	 */
	@Override
	public boolean deleteInstrumentRule(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_instrument_rule where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteInstrument(java.lang.String[])
	 *  删除仪器设备
	 */
	@Override
	public boolean deleteInstrument(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_instruments where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deletePerosn(java.lang.String[])
	 * 删除骨干信息
	 */
	@Override
	public boolean deletePerosn(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_person where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IDeleteContentDao#deleteCommittee(java.lang.String[])
	 * 删除委员会人员信息
	 */
	@Override
	public boolean deleteCommittee(String[] ids,String type) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql1="";
		if(type.equals("academia")){ //专家委员会
			sql1="delete from sys_academia_committee where id=?";
		}else if(type.equals("manage")){ //管理委员会
			sql1="delete from sys_manage_committee where id=?";
		}else if(type.equals("director")){//主任委员会
			sql1="delete from sys_director_committee where id=?";
		}
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql1);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除国家自然科学基金
	 */
	@Override
	public boolean deleteFoundation(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_project_foundation where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除省部级项目
	 */
	@Override
	public boolean deleteProvincial(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_project_provincial where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除横向合作
	 */
	@Override
	public boolean deleteHorizontalCooperation(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_project_horizontal_cooperation where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除奖励
	 */
	@Override
	public boolean deleteRewards(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_result_awards where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除专利
	 */
	@Override
	public boolean deletePatent(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_result_patent where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除论文
	 */
	@Override
	public boolean deleteThesis(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_result_thesis where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除鉴定
	 */
	@Override
	public boolean deleteIdentification(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_result_identification where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

	/**
	 * 删除学生培养信息
	 */
	@Override
	public boolean deleteStudentCultivateInfo(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag=false;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql = "delete from sys_student_cultivate where id=?";  
        try {  
        	
            con.setAutoCommit(false);  
            ps = con.prepareStatement(sql);  
            for(int i =0 ;i<ids.length;i++){   
                ps.setString(1,ids[i].trim());  
                ps.addBatch();                 
            }   
            ps.executeBatch(); //批量执行   
            con.commit();//提交事务  
            flag = true;  
        } catch (SQLException e) {  
            try {  
                con.rollback(); //进行事务回滚  
                flag=false;
            } catch (SQLException ex) {   
            }   
        }finally {  
        	try {
				con.setAutoCommit(true);
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }   
        return flag;
	}

}
