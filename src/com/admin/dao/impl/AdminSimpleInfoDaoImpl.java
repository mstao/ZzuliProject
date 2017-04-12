package com.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.dao.IAdminAllSimpleInfoDao;
import com.home.db.DB;
import com.home.db.DBMeans;
import com.home.web.service.AchievementBean;
import com.home.web.service.CommitteeBean;
import com.home.web.service.ContactBean;
import com.home.web.service.EmployBean;
import com.home.web.service.FileBean;
import com.home.web.service.InstrumentRuleBean;
import com.home.web.service.InstrumentsBean;
import com.home.web.service.NewsBean;
import com.home.web.service.PersonBean;
import com.home.web.service.ResearchBean;
import com.home.web.service.RulesBean;

/** 
 * @ClassName: AdminSimpleInfoDaoImpl 
 * @Description: TODO 获取简单信息，用于分页，包含所有信息(草稿)
 * @date 2016年12月29日 下午3:22:21 
 * @param <T> 
 */
public class AdminSimpleInfoDaoImpl<T> implements IAdminAllSimpleInfoDao<T> {
	
	
	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimpleNewsInfo(java.lang.String, int, int)
	 * 获取新闻公告的简单信息
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleNewsInfo(String type, int position,int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select sn.id,sn.item_title,sn.add_time,sn.is_publish,snt.type_flag from sys_news sn,sys_news_type snt where sn.news_type_id=snt.id and snt.type_flag='"+type+"'  order by add_time desc limit ?,?";
	   /* System.out.print(sql1);*/
	    ps=DB.getPstmt(con, sql1);
	    
	    try {
	    	ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    rs=DB.getRs(ps);
		List<NewsBean> news=new ArrayList<NewsBean>();
		try {
			while(rs.next()){
				NewsBean nb=new NewsBean();
				nb.setId(rs.getInt("sn.id"));
				nb.setItem_title(rs.getString("sn.item_title"));
				nb.setAdd_time(rs.getString("sn.add_time"));
				nb.setType_flag(rs.getString("snt.type_flag"));
				nb.setIs_publish(rs.getInt("sn.is_publish"));
				news.add(nb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) news;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimpleRulesInfo(int, int)
	 * 获取规章制度的简单信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleRulesInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select r.* from sys_rules r  order by add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    try {
			ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    rs=DB.getRs(ps);
		List<RulesBean> rules=new ArrayList<RulesBean>();
		try {
			while(rs.next()){
				RulesBean rb=new RulesBean();
				rb.setId(rs.getInt("r.id"));
				rb.setRule_title(rs.getString("r.rule_title"));
				rb.setAdd_time(rs.getString("r.add_time"));
				rb.setIs_publish(rs.getInt("r.is_publish"));
				rules.add(rb);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) rules;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimpleResearchInfo(java.lang.String, int, int)
	 * 获取科学研究的简单信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleResearchInfo(String type, int position,int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select sr.id,sr.item_title,sr.add_time,sr.is_publish,srt.type_flag from sys_research sr,sys_research_type srt where sr.research_type_id=srt.id and srt.type_flag='"+type+"' order by add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    try {
			ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    rs=DB.getRs(ps);
		List<ResearchBean> research=new ArrayList<ResearchBean>();
		try {
			while(rs.next()){
				ResearchBean rb=new ResearchBean();
				rb.setId(rs.getInt("sr.id"));
			    rb.setItem_title(rs.getString("sr.item_title"));
				rb.setAdd_time(rs.getString("sr.add_time"));
				rb.setType_flag(rs.getString("srt.type_flag"));
				rb.setIs_publish(rs.getInt("sr.is_publish"));
				research.add(rb);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) research;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimplePersonInfo(java.lang.String, int, int)
	 * 获取人才队伍列表
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimplePersonInfo(int position,int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select sp.* from sys_person sp order by add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    try {
			ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    rs=DB.getRs(ps);
		List<PersonBean> person=new ArrayList<PersonBean>();
		try {
			while(rs.next()){
				PersonBean pb=new PersonBean();
				pb.setId(rs.getInt("sp.id"));
			    pb.setPerson_name(rs.getString("sp.person_name"));
			    pb.setPerson_post(rs.getString("sp.person_post"));
			    pb.setAvatar_file(rs.getString("sp.avatar_file"));
			    pb.setIs_publish(rs.getInt("sp.is_publish"));
			    pb.setAdd_time(rs.getString("sp.add_time"));
				person.add(pb);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) person;
	}
    
	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimpleAchievementInfo(java.lang.String, int, int)
	 * 科研成果
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleAchievementInfo(String type, int position,int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select sa.*,sat.type_flag from sys_achievement sa,sys_achievement_type sat where sa.achievement_type_id=sat.id and sat.type_flag='"+type+"' order by add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    try {
			ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    rs=DB.getRs(ps);
		List<AchievementBean> achievement=new ArrayList<AchievementBean>();
		try {
			while(rs.next()){
				AchievementBean ab=new AchievementBean();
				ab.setId(rs.getInt("sa.id"));
			    ab.setItem_title(rs.getString("sa.item_title"));
			    ab.setItem_content(rs.getString("sa.item_content"));
				ab.setAdd_time(rs.getString("sa.add_time"));
				ab.setAuthor(rs.getString("sa.author"));
				ab.setIs_publish(rs.getInt("sa.is_publish"));
				ab.setType_flag(rs.getString("sat.type_flag"));
				achievement.add(ab);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) achievement;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllSimpleInfo#getSimpleDocumentInfo(int, int)
	 * 文件
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleDocumentInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select sf.id,sf.file_name,sf.real_name,sf.add_time  from sys_file sf order by add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    try {
			ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    rs=DB.getRs(ps);
		List<FileBean> file=new ArrayList<FileBean>();
		try {
			while(rs.next()){
				FileBean fb=new FileBean();
				fb.setId(rs.getInt("sf.id"));
	            fb.setFile_name(rs.getString("sf.file_name"));
	            fb.setReal_name(rs.getString("sf.real_name"));
				fb.setAdd_time(rs.getString("sf.add_time"));
				file.add(fb);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) file;
	}


	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllSimpleInfoDao#getSimpleInstrumentInfo(int, int)
	 *  获取仪器设备的列表信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleInstrumentInfo(int position, int item_per_page) {
		
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select si.id,si.instrument_name,si.instrument_image,si.is_publish,si.add_time from sys_instruments si order by si.add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    
	    try {
	    	ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    rs=DB.getRs(ps);
		List<InstrumentsBean> instrument=new ArrayList<InstrumentsBean>();
		try {
			while(rs.next()){
				InstrumentsBean ib=new InstrumentsBean();
				ib.setId(rs.getInt("si.id"));
				ib.setInstrument_name(rs.getString("si.instrument_name"));
				ib.setInstrument_image(rs.getString("si.instrument_image"));
				ib.setAdd_time(rs.getString("si.add_time"));
				ib.setIs_publish(rs.getInt("si.is_publish"));
				instrument.add(ib);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) instrument;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllSimpleInfoDao#getSimpleEmployInfo()
	 * 获取人才招聘信息(包含草稿)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleEmployInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_employ";
		rs=ss.Search(sql1);
		List<EmployBean> employ=new ArrayList<EmployBean>();
		try{
			while(rs.next()){
				EmployBean eb=new EmployBean();
				eb.setId(rs.getInt("id"));
				eb.setAuthor(rs.getString("author"));
				eb.setIs_publish(rs.getInt("is_publish"));
				eb.setContent(rs.getString("content"));
				employ.add(eb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) employ;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllSimpleInfoDao#getSimpleContactInfo()
	 * 
	 * 获取 联系我们信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleContactInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_contact";
		rs=ss.Search(sql1);
		List<ContactBean> con=new ArrayList<ContactBean>();
		try{
			while(rs.next()){
				ContactBean cb=new ContactBean();
				cb.setId(rs.getInt("id"));
				cb.setAuthor(rs.getString("author"));
				cb.setIs_publish(rs.getInt("is_publish"));
				cb.setContent(rs.getString("content"));
				con.add(cb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) con;
	}

	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllSimpleInfoDao#getSimpleInstrumentRulesInfo(int, int)
	 * 获取仪器设备规章制度信息列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleInstrumentRulesInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
	    String sql1="select si.* from sys_instrument_rule si  order by si.add_time desc limit ?,?";
	    ps=DB.getPstmt(con, sql1);
	    
	    try {
	    	ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    rs=DB.getRs(ps);
		List<InstrumentRuleBean> instrument_rule=new ArrayList<InstrumentRuleBean>();
		try {
			while(rs.next()){
				InstrumentRuleBean ir=new InstrumentRuleBean();
				ir.setId(rs.getInt("si.id"));
				ir.setTitle(rs.getString("si.title"));
				ir.setAdd_time(rs.getString("si.add_time"));
				ir.setIs_publish(rs.getInt("si.is_publish"));
				instrument_rule.add(ir);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) instrument_rule;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSimpleCommitteeInfo(String type, int position,
			int item_per_page) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=DB.getConn();
		String sql1="";
		if(type.equals("academia")){ //专家委员会
			sql1="select sec.*,sps.post from sys_academia_committee sec,sys_post_style sps where sec.post_id=sps.id  order by sec.add_time desc limit ?,?";
		}else if(type.equals("manage")){ //管理委员会
			sql1="select smc.*,sps.post from sys_manage_committee smc,sys_post_style sps where smc.post_id=sps.id  order by smc.add_time desc limit ?,?";
		}else if(type.equals("director")){//主任委员会
			sql1="select * from sys_director_committee order by id asc limit ?,?";
		}
	    ps=DB.getPstmt(con, sql1);
	    
	    try {
	    	ps.setInt(1, position);
			ps.setInt(2, item_per_page);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    rs=DB.getRs(ps);
		List<CommitteeBean> committee=new ArrayList<CommitteeBean>();
		try {
			while(rs.next()){
				CommitteeBean cb=new CommitteeBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setTitle(rs.getString("title"));
				cb.setSex(rs.getString("sex"));
				cb.setUnit(rs.getString("unit"));
				cb.setPost(rs.getString("post"));
				cb.setAdd_time(rs.getString("add_time"));
				cb.setIs_publish(rs.getInt("is_publish"));
				committee.add(cb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.close(con);
			DB.close(rs);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (List<T>) committee;
	}

	
}
