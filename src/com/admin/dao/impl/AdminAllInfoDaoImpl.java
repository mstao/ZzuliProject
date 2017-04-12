package com.admin.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.dao.IAdminAllInfoDao;
import com.home.db.DBMeans;
import com.home.web.service.AchievementBean;
import com.home.web.service.CommitteeBean;
import com.home.web.service.CommitteeIntroBean;
import com.home.web.service.InstrumentRuleBean;
import com.home.web.service.InstrumentsBean;
import com.home.web.service.NewsBean;
import com.home.web.service.PersonBean;
import com.home.web.service.PersonIntroBean;
import com.home.web.service.ResearchBean;
import com.home.web.service.RulesBean;


public class AdminAllInfoDaoImpl<T> implements IAdminAllInfoDao<T>{
	
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getRulesInfo(int)
	 * 获取规章制度信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getRulesInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sr.* from sys_rules sr where  sr.id='"+id+"' ";
	    rs=ss.Search(sql1);
	    List<RulesBean> rules=new ArrayList<RulesBean>();
	    try{
	    	while(rs.next()){
				RulesBean rb=new RulesBean();
				rb.setId(rs.getInt("sr.id"));
				rb.setRule_title(rs.getString("sr.rule_title"));
				rb.setRule_content(rs.getString("sr.rule_content"));
				rb.setAuthor(rs.getString("sr.author"));
				rb.setAdd_time(rs.getString("sr.add_time"));
				rb.setView_count(rs.getInt("sr.view_count"));
				rb.setIs_publish(rs.getInt("sr.is_publish"));
				rules.add(rb);
			}

	    }catch(SQLException e){
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }finally{
			ss.closeAll();
		}
		return (List<T>) rules;
	}

	
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getNewsInfo(int)
	 * 获取新闻公告信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getNewsInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sn.*,snt.type_name,snt.type_flag from sys_news sn,sys_news_type snt where sn.news_type_id=snt.id and sn.id='"+id+"' ";
	    rs=ss.Search(sql1);
		List<NewsBean> news=new ArrayList<NewsBean>();
		try {
			while(rs.next()){
				NewsBean nb=new NewsBean();
				nb.setId(rs.getInt("sn.id"));
				nb.setItem_title(rs.getString("sn.item_title"));
				nb.setItem_content(rs.getString("sn.item_content"));
				nb.setAdd_time(rs.getString("sn.add_time"));
				nb.setAuthor(rs.getString("sn.author"));
				nb.setView_count(rs.getInt("sn.view_count"));
				nb.setType_name(rs.getString("snt.type_name"));
				nb.setType_flag(rs.getString("snt.type_flag"));
				nb.setIs_publish(rs.getInt("sn.is_publish"));
				news.add(nb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) news;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getResearchInfo(int)
	 * 获取科学研究信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getResearchInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sr.*,srt.type_name,srt.type_flag from sys_research sr,sys_research_type srt where sr.research_type_id=srt.id and sr.id='"+id+"'";
	    rs=ss.Search(sql1);
		List<ResearchBean> research=new ArrayList<ResearchBean>();
		try {
			while(rs.next()){
				ResearchBean rb=new ResearchBean();
				rb.setId(rs.getInt("sr.id"));
			    rb.setItem_title(rs.getString("sr.item_title"));
			    rb.setItem_content(rs.getString("sr.item_content"));
				rb.setAuthor(rs.getString("sr.author"));
				rb.setAdd_time(rs.getString("sr.add_time"));
				rb.setView_count(rs.getInt("sr.view_count"));
				rb.setType_name(rs.getString("srt.type_name"));
				rb.setType_flag(rs.getString("srt.type_flag"));
				rb.setIs_publish(rs.getInt("sr.is_publish"));
				research.add(rb);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) research;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getPersonInfo(int)
	 * 获取 骨干信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPersonInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sp.* from sys_person sp where  sp.id='"+id+"'";
	    rs=ss.Search(sql1);
		List<PersonBean> person=new ArrayList<PersonBean>();
		try {
			while(rs.next()){
				PersonBean pb=new PersonBean();
				pb.setId(rs.getInt("sp.id"));
				pb.setPerson_name(rs.getString("sp.person_name"));
				pb.setAvatar_file(rs.getString("sp.avatar_file"));	
				pb.setPerson_post(rs.getString("sp.person_post"));
				pb.setPerson_info(rs.getString("sp.person_info"));
				pb.setIs_gugan(rs.getInt("sp.is_gugan"));
				pb.setAdd_time(rs.getString("sp.add_time"));
				pb.setView_count(rs.getInt("sp.view_count"));
				pb.setAuthor(rs.getString("sp.author"));
				person.add(pb);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) person;
	}

	
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getAchievementInfo(int)
	 * 获取科研成果--成果转化的详细信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAchievementInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sa.* from sys_achievement sa,sys_achievement_type sat where sa.achievement_type_id=sat.id and sa.id='"+id+"'";
	    rs=ss.Search(sql1);
		List<AchievementBean> achievement=new ArrayList<AchievementBean>();
		try {
			while(rs.next()){
				AchievementBean ab=new AchievementBean();
				ab.setId(rs.getInt("sa.id"));
				ab.setItem_title(rs.getString("sa.item_title"));
				ab.setItem_content(rs.getString("sa.item_content"));
				ab.setAuthor(rs.getString("sa.author"));
				ab.setAdd_time(rs.getString("sa.add_time"));				
				ab.setIs_publish(rs.getInt("sa.is_publish"));
				achievement.add(ab);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) achievement;
	}

	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getInstrumentInfo(int)
	 * 获取仪器信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInstrumentInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select si.* from sys_instruments si where id='"+id+"'"; 
	    rs=ss.Search(sql1);
		List<InstrumentsBean> instrument=new ArrayList<InstrumentsBean>();
		try {
			while(rs.next()){
				InstrumentsBean ib=new InstrumentsBean();
				ib.setId(rs.getInt("si.id"));
				ib.setInstrument_image(rs.getString("si.instrument_image"));
				ib.setInstrument_name(rs.getString("si.instrument_name"));
				ib.setInstrument_url(rs.getString("si.instrument_url"));
				ib.setInstrument_info(rs.getString("si.instrument_info"));
				ib.setIs_publish(rs.getInt("si.is_publish"));
				ib.setView_count(rs.getInt("si.view_count"));
				ib.setAuthor(rs.getString("si.author"));
				ib.setAdd_time(rs.getString("si.add_time"));
				instrument.add(ib);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) instrument;
	}

	
	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllInfoDao#getInstrumentRuleInfo(int)
	 * 获取  大型仪器-规章制度信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInstrumentRuleInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select si.* from sys_instrument_rule si where  id='"+id+"'"; 
	    rs=ss.Search(sql1);
		List<InstrumentRuleBean> instrument_rule=new ArrayList<InstrumentRuleBean>();
		try {
			while(rs.next()){
				InstrumentRuleBean ib=new InstrumentRuleBean();
				ib.setId(rs.getInt("si.id"));
				ib.setTitle(rs.getString("si.title"));
				ib.setContent(rs.getString("si.content"));
				ib.setAuthor(rs.getString("si.author"));
				ib.setAdd_time(rs.getString("si.add_time"));				
				ib.setView_count(rs.getInt("si.view_count"));
				ib.setIs_publish(rs.getInt("si.is_publish"));
				instrument_rule.add(ib);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) instrument_rule;
	}




	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllInfoDao#getPersonIntroInfo()
	 * 获取人才队伍现状信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPersonIntroInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_person_intro";
		rs=ss.Search(sql1);
		List<PersonIntroBean> personintro=new ArrayList<PersonIntroBean>();
		try{
			while(rs.next()){
				PersonIntroBean pb=new PersonIntroBean();
				pb.setId(rs.getInt("id"));
				pb.setAuthor(rs.getString("author"));
				pb.setIs_publish(rs.getInt("is_publish"));
				pb.setContent(rs.getString("content"));
				personintro.add(pb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) personintro;
	}


	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllInfoDao#getCommitteeIntroInfo(java.lang.String)
	 * 获取 委员会介绍信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getCommitteeIntroInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select sci.* from sys_committee_intro sci,sys_committee_intro_type scit where sci.type_id=scit.id and scit.type_flag='"+type+"'";
		rs=ss.Search(sql1);
		List<CommitteeIntroBean> commitintro=new ArrayList<CommitteeIntroBean>();
		try{
			while(rs.next()){
				CommitteeIntroBean cb=new CommitteeIntroBean();
				cb.setId(rs.getInt("id"));
				cb.setAuthor(rs.getString("author"));
				cb.setIs_publish(rs.getInt("is_publish"));
				cb.setContent(rs.getString("content"));
				commitintro.add(cb);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) commitintro;
	}


	/* (non-Javadoc)
	 * @see com.admin.dao.IAdminAllInfoDao#getCommitteeInfo(int)
	 * 获取学术委员会的人员信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getCommitteeInfo(int id,String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="";
		if(type.equals("academia")){ //专家委员会
			sql1="select sec.*,sps.post from sys_academia_committee sec,sys_post_style sps where sec.post_id=sps.id  and sec.id='"+id+"'";
		}else if(type.equals("manage")){ //管理委员会
			sql1="select smc.*,sps.post from sys_manage_committee smc,sys_post_style sps where smc.post_id=sps.id  and smc.id='"+id+"'";
		}else if(type.equals("director")){//主任委员会
			sql1="select * from sys_director_committee  where id='"+id+"'";
		}
	    rs=ss.Search(sql1);
		List<CommitteeBean> committee=new ArrayList<CommitteeBean>();
		try {
			while(rs.next()){
				CommitteeBean cb=new CommitteeBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setBirthday(rs.getString("birthday"));
				cb.setTitle(rs.getString("title"));
				cb.setAuhthor(rs.getString("author"));
				cb.setSex(rs.getString("sex"));
				cb.setUnit(rs.getString("unit"));
				cb.setPost(rs.getString("post"));
				cb.setResearch(rs.getString("research"));
				cb.setAdd_time(rs.getString("add_time"));
				cb.setIs_publish(rs.getInt("is_publish"));
				committee.add(cb);
				//System.out.print("sex--"+rs.getString("sex"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) committee;
	}
	

}
