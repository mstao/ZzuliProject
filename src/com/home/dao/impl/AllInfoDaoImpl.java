package com.home.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.home.dao.IAllInfo;
import com.home.db.DBMeans;
import com.home.web.service.AchievementBean;
import com.home.web.service.CommitteeBean;
import com.home.web.service.CommitteeIntroBean;
import com.home.web.service.ContactBean;
import com.home.web.service.EmployBean;
import com.home.web.service.FileBean;
import com.home.web.service.FoundationbBean;
import com.home.web.service.HorizontalCooperationBean;
import com.home.web.service.InstrumentRuleBean;
import com.home.web.service.InstrumentsBean;
import com.home.web.service.IntroBean;
import com.home.web.service.NewsBean;
import com.home.web.service.PersonBean;
import com.home.web.service.PersonIntroBean;
import com.home.web.service.ProvincialProjectBean;
import com.home.web.service.ResearchBean;
import com.home.web.service.ResultIdentificationBean;
import com.home.web.service.ResultPatentBean;
import com.home.web.service.ResultRewardsBean;
import com.home.web.service.ResultThesisBean;
import com.home.web.service.RulesBean;
import com.home.web.service.StudentBean;
import com.home.web.service.StudentCultivateBean;

/** 
 * @ClassName: AllInfoDaoImpl 
 * @Description: TODO  获取具体信息
 * @date 2016年12月20日 下午4:43:15 
 * @param <T> 
 */
public class AllInfoDaoImpl<T> implements IAllInfo<T> {

	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getIntroduceInfo(java.lang.String)
	 * 获取实验室简介 。。过滤草稿
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getIntroduceInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select si.* from sys_intro si,sys_intro_type sit where si.intro_type_id=sit.id and is_publish=1 and sit.type_flag='"+type+"'";
	    rs=ss.Search(sql1);
		List<IntroBean> intro=new ArrayList<IntroBean>();
		try {
			while(rs.next()){
				IntroBean ib=new IntroBean();
				ib.setId(rs.getInt("si.id"));
				ib.setItem_content(rs.getString("si.item_content"));
				ib.setAdd_time(rs.getString("si.add_time"));
				intro.add(ib);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) intro;
	}
	
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getIntroduceDraftInfo(java.lang.String)
	 * 获取简介，不过滤草稿
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getIntroduceDraftInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select si.* from sys_intro si,sys_intro_type sit where si.intro_type_id=sit.id  and sit.type_flag='"+type+"'";
	    rs=ss.Search(sql1);
		List<IntroBean> intro=new ArrayList<IntroBean>();
		try {
			while(rs.next()){
				IntroBean ib=new IntroBean();
				ib.setId(rs.getInt("si.id"));
				ib.setItem_content(rs.getString("si.item_content"));
				ib.setAdd_time(rs.getString("si.add_time"));
				ib.setIs_publish(rs.getInt("si.is_publish"));
				intro.add(ib);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) intro;
	}
	
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
	    String sql1="select sr.* from sys_rules sr where sr.is_publish=1 and sr.id='"+id+"' ";
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
	    String sql1="select sn.*,snt.type_name,snt.type_flag from sys_news sn,sys_news_type snt where sn.news_type_id=snt.id and sn.is_publish=1  and sn.id='"+id+"' ";
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
	    String sql1="select sr.*,srt.type_name,srt.type_flag from sys_research sr,sys_research_type srt where sr.research_type_id=srt.id and sr.is_publish=1 and sr.id='"+id+"'";
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
	 * 获取 人才队伍信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPersonInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sp.* from sys_person sp where sp.is_publish=1 and sp.id='"+id+"'";
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
	    String sql1="select sa.* from sys_achievement sa,sys_achievement_type sat where sa.achievement_type_id=sat.id and sa.is_publish=1 and sa.id='"+id+"'";
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
				ab.setView_count(rs.getInt("sa.view_count"));
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
	 * @see com.home.dao.IAllInfo#getDocumentInfo(int)
	 * 获取文件信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getDocumentInfo(int id,String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sf.id,sf.file_name,sf.real_name,sf.add_time from sys_file sf,sys_file_belong sfb where sf.item_id='"+id+"' and sf.file_belong_id=sfb.id and sfb.type_flag='"+type+"' order by sf.add_time desc";
	    rs=ss.Search(sql1);
		List<FileBean> file=new ArrayList<FileBean>();
		try {
			while(rs.next()){
				FileBean fb=new FileBean();
				fb.setId(rs.getInt("sf.id"));
				fb.setReal_name(rs.getString("sf.real_name"));
				fb.setAdd_time(rs.getString("sf.add_time"));
                fb.setFile_name(rs.getString("sf.file_name"));
				file.add(fb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) file;
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
	    String sql1="select si.* from sys_instruments si where is_publish=1 and id='"+id+"'"; 
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
	 * @see com.home.dao.IAllInfo#getEmployInfo()
	 * 获取招聘信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEmployInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_employ se where is_publish=1";
		rs=ss.Search(sql1);
		List<EmployBean> employ=new ArrayList<EmployBean>();
		try{
			while(rs.next()){
				EmployBean eb=new EmployBean();
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
	 * @see com.home.dao.IAllInfo#getStudentInfo(java.lang.String)
	 * 获取学生培养的详细信息(过滤草稿)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getStudentInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select ss.item_content from sys_student ss,sys_student_type sst where ss.student_type_id=sst.id and is_publish=1 and sst.type_flag='"+type+"'";
	    rs=ss.Search(sql1);
		List<StudentBean> student=new ArrayList<StudentBean>();
		try {
			while(rs.next()){
				StudentBean sb=new StudentBean();
				sb.setItem_content(rs.getString("ss.item_content"));
				student.add(sb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) student;
	}
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getStudentDraftInfo(java.lang.String)
	 * 获取学生培养的详细信息(不过滤草稿)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getStudentDraftInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select ss.* from sys_student ss,sys_student_type sst where ss.student_type_id=sst.id and sst.type_flag='"+type+"'";
	    rs=ss.Search(sql1);
		List<StudentBean> student=new ArrayList<StudentBean>();
		try {
			while(rs.next()){
				StudentBean sb=new StudentBean();
				sb.setId(rs.getInt("ss.id"));
				sb.setItem_content(rs.getString("ss.item_content"));
				sb.setIs_publish(rs.getInt("ss.is_publish"));
				student.add(sb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) student;
	}
	/* (non-Javadoc)
	 * @see com.home.dao.IAllInfo#getSliderNewsInfo()
	 * 用于实验室新闻轮播  含有图片的新闻 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSliderNewsInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sn.id,sn.item_title,sn.item_content from sys_news sn,sys_news_type snt where sn.news_type_id=snt.id and snt.type_flag='"+type+"'  and sn.is_publish=1 and sn.is_image=1 order by sn.add_time desc limit 0,5";
	    rs=ss.Search(sql1);
		List<NewsBean> news=new ArrayList<NewsBean>();
		try {
			while(rs.next()){
				NewsBean nb=new NewsBean();
				nb.setId(rs.getInt("sn.id"));
				nb.setItem_title(rs.getString("sn.item_title"));
				nb.setItem_content(rs.getString("sn.item_content"));
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
	 * @see com.home.dao.IAllInfo#getSliderProject(java.lang.String)
	 *  用于获取在研项目简单信息  用于在研项目图片轮播
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getSliderProject(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sr.id,sr.item_title,sr.item_content from sys_research sr,sys_research_type srt where sr.research_type_id=srt.id and srt.type_flag='"+type+"' and is_publish=1 and is_image=1 order by add_time desc limit 0,5";
	    rs=ss.Search(sql1);
		List<ResearchBean> research=new ArrayList<ResearchBean>();
		try {
			while(rs.next()){
				ResearchBean rb=new ResearchBean();
				rb.setId(rs.getInt("sr.id"));
			    rb.setItem_title(rs.getString("sr.item_title"));
			    rb.setItem_content(rs.getString("sr.item_content"));
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
	 * @see com.home.dao.IAllInfo#getAchievementInfo(java.lang.String)
	 * 获得科研成果 的 发表论文和发明专利
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAchievementInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sa.* from sys_achievement sa,sys_achievement_type sat where sa.achievement_type_id=sat.id and sat.type_flag='"+type+"' and sa.is_publish=1";
	    rs=ss.Search(sql1);
		List<AchievementBean> achievement=new ArrayList<AchievementBean>();
		try {
			while(rs.next()){
				AchievementBean ab=new AchievementBean();				
				ab.setItem_content(rs.getString("sa.item_content"));
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
	 * @see com.home.dao.IAllInfo#getContactInfo()
	 *  获取联系方式信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getContactInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select sc.* from sys_contact sc where sc.is_publish=1";
		rs=ss.Search(sql1);
		List<ContactBean> contact=new ArrayList<ContactBean>();
		try{
			while(rs.next()){
				ContactBean cb=new ContactBean();
				cb.setContent(rs.getString("sc.content"));
				contact.add(cb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) contact;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInstrumentRuleInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select si.* from sys_instrument_rule si where is_publish=1 and id='"+id+"'"; 
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
	 * @see com.home.dao.IAllInfo#getPersonIntro()
	 * 获取人才队伍现状信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPersonIntro() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_person_intro where is_publish=1";
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
		String sql1="select sci.* from sys_committee_intro sci,sys_committee_intro_type scit where sci.type_id=scit.id and sci.is_publish=1 and scit.type_flag='"+type+"'";
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
	 * 获取委员会的人员信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getCommitteeInfo(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="";
		if(type.equals("academia")){ //专家委员会
			sql1="select sec.*,sps.post from sys_academia_committee sec,sys_post_style sps where sec.post_id=sps.id and sec.is_publish=1 order  by post_id asc ";
		}else if(type.equals("manage")){ //管理委员会
			sql1="select smc.*,sps.post from sys_manage_committee smc,sys_post_style sps where smc.post_id=sps.id and smc.is_publish=1  order  by post_id asc";
		}else if(type.equals("director")){//主任委员会
			sql1="select * from sys_director_committee  where is_publish=1 order by id asc";
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

	
	/**
	 * 获取 国家自然科学基金
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getProjectFoundationInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_project_foundation where is_publish=1  order by add_time desc";
		rs=ss.Search(sql1);
		
		ArrayList<FoundationbBean> foundation=new ArrayList<FoundationbBean>();
		
		try{
			while(rs.next()){
				FoundationbBean fb=new FoundationbBean();
				fb.setId(rs.getInt("id"));
				fb.setName(rs.getString("name"));
				fb.setNumber(rs.getString("number"));
				fb.setOutlay(rs.getDouble("outlay"));
				fb.setPerson(rs.getString("person"));
				fb.setTime(rs.getString("time"));
				foundation.add(fb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) foundation;
	}

	/**
	 * 获取省部级重大（点）项目
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getProvincialProjectInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_project_provincial where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<ProvincialProjectBean> provincial=new ArrayList<ProvincialProjectBean>();
		try{
			while(rs.next()){
				ProvincialProjectBean pb=new ProvincialProjectBean();
				pb.setId(rs.getInt("id"));
				pb.setNameid(rs.getString("nameid"));
				pb.setOutlay(rs.getDouble("outlay"));
				pb.setPerson(rs.getString("person"));
				pb.setSource(rs.getString("source"));
				pb.setTime(rs.getString("time"));
				provincial.add(pb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) provincial;
	}

	/**
	 * 获取  	横向合作
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getHorizontalCooperationInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_project_horizontal_cooperation where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<HorizontalCooperationBean> cooperation=new ArrayList<HorizontalCooperationBean>();
		try{
			while(rs.next()){
				HorizontalCooperationBean hb=new HorizontalCooperationBean();
				hb.setId(rs.getInt("id"));
				hb.setName(rs.getString("name"));
				hb.setOutlay(rs.getDouble("outlay"));
				hb.setPerson(rs.getString("person"));
				hb.setCooperator(rs.getString("cooperator"));
				hb.setTime(rs.getString("time"));
				cooperation.add(hb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) cooperation;
	}

	/**
	 * 获取奖励
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getResultRewardsInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_result_awards where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<ResultRewardsBean> rewards=new ArrayList<ResultRewardsBean>();
		try{
			while(rs.next()){
				ResultRewardsBean rb=new ResultRewardsBean();
				rb.setId(rs.getInt("id"));
				rb.setName(rs.getString("name"));
				rb.setPerson(rs.getString("person"));
				rb.setAwards(rs.getString("awards"));
				rb.setTime(rs.getString("time"));
				rewards.add(rb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) rewards;
	}

	/**
	 * 获取专利
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPatentInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_result_patent where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<ResultPatentBean> patent=new ArrayList<ResultPatentBean>();
		try{
			while(rs.next()){
				ResultPatentBean rb=new ResultPatentBean();
				rb.setId(rs.getInt("id"));
				rb.setName(rs.getString("name"));
				rb.setPerson(rs.getString("person"));
				rb.setStyle(rs.getString("style"));
				rb.setTime(rs.getString("time"));
				patent.add(rb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) patent;
	}

	/**
	 * 获取鉴定
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getIdentificationInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_result_identification where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<ResultIdentificationBean> identification=new ArrayList<ResultIdentificationBean>();
		try{
			while(rs.next()){
				ResultIdentificationBean rb=new ResultIdentificationBean();
				rb.setId(rs.getInt("id"));
				rb.setName(rs.getString("name"));
				rb.setPerson(rs.getString("person"));
				rb.setTime(rs.getString("time"));
				rb.setLevel(rs.getString("level"));
				rb.setIdentification_number(rs.getString("identification_number"));
				identification.add(rb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) identification;
	}

	/**
	 * 获取论文
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getThesisInfo() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		DBMeans ss=new DBMeans();
		String sql1="select * from sys_result_thesis where is_publish=1 order by add_time desc";
		rs=ss.Search(sql1);
		ArrayList<ResultThesisBean> thesis=new ArrayList<ResultThesisBean>();
		try{
			while(rs.next()){
				ResultThesisBean rb=new ResultThesisBean();
				rb.setId(rs.getInt("id"));
				rb.setName(rs.getString("name"));
				rb.setAuthor(rs.getString("author"));
				rb.setPage_number(rs.getString("page_number"));
				rb.setPublication_division(rs.getString("publication_division"));
				rb.setStyle(rs.getString("style"));
				thesis.add(rb);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (List<T>) thesis;
	}

	/**
	 * 获取学生培养详细信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getStudentCultivateInfo(int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sn.*,snt.type_name,snt.type_flag from sys_student_cultivate sn,sys_student_cultivate_type snt where sn.type_id=snt.id and sn.is_publish=1  and sn.id='"+id+"' ";
	    rs=ss.Search(sql1);
		StudentCultivateBean st=new StudentCultivateBean();
		try {
			while(rs.next()){
			
				st.setId(rs.getInt("sn.id"));
				st.setItem_title(rs.getString("sn.item_title"));
				st.setItem_content(rs.getString("sn.item_content"));
				st.setAdd_time(rs.getString("sn.add_time"));
				st.setAuthor(rs.getString("sn.author"));
				st.setView_count(rs.getInt("sn.view_count"));
				st.setType_name(rs.getString("snt.type_name"));
				st.setType_flag(rs.getString("snt.type_flag"));
				st.setIs_publish(rs.getInt("sn.is_publish"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
		}
		return (T) st;
	}
	
	

}
