package com.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.dao.IAddContentDao;
import com.admin.util.GetDateUtil;
import com.home.db.DB;


/** 
 * @ClassName: AddContentDaoImpl 
 * @Description: TODO 向数据库添加信息
 * @date 2016年12月25日 下午6:57:53  
 */
public class AddContentDaoImpl implements IAddContentDao {

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddNewsInfo(java.lang.String, java.lang.String, java.lang.String)
	 * 添加新闻公告信息
	 */
	@Override
	public int AddNewsInfo(String type,String title,String content,String author,int is_publish,int is_image) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getNewsTypeId(type);
		String sql="insert into sys_news(item_title,item_content,add_time,news_type_id,author,is_publish,is_image) values(?,?,?,?,?,?,?)";
	    try {
	    	
			
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, title);
		    ps.setString(2,content);
		    ps.setString(3, c_data);
		    ps.setInt(4, type_id);
		    ps.setString(5, author);
		    ps.setInt(6, is_publish);
		    ps.setInt(7, is_image);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }
		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddRuleInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加规章制度信息
	 */
	@Override
	public int AddRuleInfo(String title, String content,String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();

		String sql="insert into sys_rules(rule_title,rule_content,add_time,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, title);
		    ps.setString(2,content);
		    ps.setString(3, c_data);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddResearchInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * 添加科学研究信息 
	 */
	@Override
	public int AddResearchInfo(String type, String title, String content,String author, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getResearchTypeId(type);
		String sql="insert into sys_research(item_title,item_content,add_time,research_type_id,author,is_publish,is_image) values(?,?,?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, title);
		    ps.setString(2,content);
		    ps.setString(3, c_data);
		    ps.setInt(4, type_id);
		    ps.setString(5, author);
		    ps.setInt(6, is_publish);
		    ps.setInt(7, is_image);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddAchievementInfo(java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加成果转化信息
	 */
	@Override
	public int AddAchievementInfo(String type,String title, String content, String author,int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getAchievementTypeId(type); 
		
		String sql="insert into sys_achievement(item_title,item_content,achievement_type_id,add_time,author,is_publish) values(?,?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, title);
		    ps.setString(2,content);
		    ps.setInt(3, type_id);
		    ps.setString(4, c_data);
		    ps.setString(5, author);
		    ps.setInt(6, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddIntroduceInfo(java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加实验室简介相关信息
	 */
	@Override
	public int AddIntroduceInfo(String type, String content, String author,
			int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getIntroduceTypeId(type); 
		
		String sql="insert into sys_intro(item_content,intro_type_id,add_time,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setInt(2, type_id);
		    ps.setString(3, c_data);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddStudentInfo(java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加  学生培养信息  返回新添加信息的id
	 * 
	 */
	@Override
	public int AddStudentInfo(String type, String content, String author,
			int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getStudentTypeId(type); 
		
		String sql="insert into sys_student(item_content,student_type_id,add_time,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setInt(2, type_id);
		    ps.setString(3, c_data);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddEmployInfo(java.lang.String, java.lang.String, int)
	 * 添加人才招聘信息，返回新添加信息的id
	 */
	@Override
	public int AddEmployInfo(String content, String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		
		String sql="insert into sys_employ(content,add_time,author,is_publish) values(?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setString(2, c_data);
		    ps.setString(3, author);
		    ps.setInt(4, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddContactInfo(java.lang.String, java.lang.String, int)
	 * 添加联系我们信息 返回添加信息的id
	 */
	@Override
	public int AddContactInfo(String content, String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		
		String sql="insert into sys_contact(content,add_time,author,is_publish) values(?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setString(2, c_data);
		    ps.setString(3, author);
		    ps.setInt(4, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }
		    con.close();
		    ps.close();
		    rs.close();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		return id;
	}

	@Override
	public int AddAchievementLunInfo(String type, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型获取类型id
		int type_id=new AllTypeIdImpl().getAchievementTypeId(type); 
		
		String sql="insert into sys_achievement(item_content,achievement_type_id,add_time,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setInt(2, type_id);
		    ps.setString(3, c_data);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddInstrumentRuleInfo(java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加大型仪器-规章制度信息
	 */
	@Override
	public int AddInstrumentRuleInfo(String title, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();

		String sql="insert into sys_instrument_rule(title,content,add_time,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, title);
		    ps.setString(2,content);
		    ps.setString(3, c_data);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddInstrumentInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加仪器设备信息
	 */
	@Override
	public int AddInstrumentInfo(String name, String content, String author,
			String img_url, String url, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();

		String sql="insert into sys_instruments(instrument_name,instrument_info,instrument_image,instrument_url,add_time,author,is_publish) values(?,?,?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, name);
		    ps.setString(2,content);
		    ps.setString(3, img_url);
		    ps.setString(4, url);
		    ps.setString(5, c_data);
		    ps.setString(6, author);
		    ps.setInt(7, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	@Override
	public int AddPersonIntroInfo(String content, String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		
		String sql="insert into sys_person_intro(content,add_time,author,is_publish) values(?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setString(2, c_data);
		    ps.setString(3, author);
		    ps.setInt(4, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddPersonInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 * 添加 骨干信息
	 */
	@Override
	public int AddPersonInfo(String person_name, String person_info,
			String avatar_file, String person_post, String author,
			int is_gugan, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		
		String sql="insert into sys_person(person_name,person_info,avatar_file,person_post,is_gugan,add_time,author,is_publish) values(?,?,?,?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, person_name);
		    ps.setString(2, person_info);
		    ps.setString(3, avatar_file);
		    ps.setString(4, person_post);
		    ps.setInt(5, is_gugan);
		    ps.setString(6,c_data);
		    ps.setString(7, author);
		    ps.setInt(8, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddDirectorCommitteeInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加主任委员会人员信息
	 */
	@Override
	public int AddDirectorCommitteeInfo(String name, String birthday,
			String sex, String post, String title, String research,
			String unit, String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		
		String sql="insert into sys_director_committee(name,birthday,sex,post,title,research,unit,author,is_publish,add_time) values(?,?,?,?,?,?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, name);
		    ps.setString(2, birthday);
		    ps.setString(3, sex);
		    ps.setString(4, post);
		    ps.setString(5, title);
		    ps.setString(6, research);
		    ps.setString(7, unit);
		    ps.setString(8, author);
		    ps.setInt(9, is_publish);
		    ps.setString(10,c_data);

		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddOtherCommitteeInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加管理委员会，学术委员会人员信息
	 */
	@Override
	public int AddOtherCommitteeInfo(String style, String name, String birthday,
			String sex, String post, String title, String research,
			String unit, String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据post获取post_id
		int post_id=new AllTypeIdImpl().getPostTypeId(post);
		
		String sql="";
		if(style.equals("manage")){
			sql="insert into sys_manage_committee(name,birthday,sex,post_id,title,research,unit,author,is_publish,add_time) values(?,?,?,?,?,?,?,?,?,?)";
		}else if(style.equals("academia")){
			sql="insert into sys_academia_committee(name,birthday,sex,post_id,title,research,unit,author,is_publish,add_time) values(?,?,?,?,?,?,?,?,?,?)";
		}
	
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, name);
		    ps.setString(2, birthday);
		    ps.setString(3, sex);
		    ps.setInt(4, post_id);
		    ps.setString(5, title);
		    ps.setString(6, research);
		    ps.setString(7, unit);
		    ps.setString(8, author);
		    ps.setInt(9, is_publish);
		    ps.setString(10,c_data);

		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
	    
		return id;
	
	   }

	/* (non-Javadoc)
	 * @see com.admin.dao.IAddContentDao#AddCommitteeIntroInfo(java.lang.String, java.lang.String, java.lang.String, int)
	 * 添加委员会介绍信息
	 */
	@Override
	public int AddCommitteeIntroInfo(String type, String content,
			String author, int is_publish) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		
		int id = 0;		
		//获取当前时间
		String c_data=GetDateUtil.getData();
		//根据类型  获取类型id
		int type_id=new AllTypeIdImpl().getCommitteeIntroTypeId(type);
		String sql="insert into sys_committee_intro(content,add_time,type_id,author,is_publish) values(?,?,?,?,?)";
	    try {
			ps=(PreparedStatement)con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1,content);
		    ps.setString(2, c_data);
		    ps.setInt(3, type_id);
		    ps.setString(4, author);
		    ps.setInt(5, is_publish);
		    
		    ps.executeUpdate();
		    rs=ps.getGeneratedKeys();
		    if(rs.next()){
		    	id=rs.getInt(1);
		    }

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ps.close();
			    rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
        
		return id;
	}
}
