package com.home.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.home.dao.IIdexInfo;
import com.home.db.DBMeans;
import com.home.web.service.NewsBean;
import com.home.web.service.ResearchBean;
import com.home.web.service.RulesBean;

/** 
 * @ClassName: IndexDaoImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Mingshan
 * @param <T>
 * @date 2016年12月18日 下午2:42:42  
 */
public class IndexDaoImpl<T> implements IIdexInfo<T> {

	/* (non-Javadoc)
	 * @see com.home.dao.IIdexInfo#getNews()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getNews(String type){
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sn.id,sn.item_title,sn.add_time,snt.type_flag from sys_news sn,sys_news_type snt where sn.news_type_id=snt.id and snt.type_flag='"+type+"' and sn.is_publish=1 order by add_time desc limit 0,7";
	    rs=ss.Search(sql1);
		List<NewsBean> news=new ArrayList<NewsBean>();
		try {
			while(rs.next()){
				NewsBean nb=new NewsBean();
				nb.setId(rs.getInt("sn.id"));
				nb.setItem_title(rs.getString("sn.item_title"));
				nb.setAdd_time(rs.getString("sn.add_time"));
				nb.setType_flag(rs.getString("snt.type_flag"));
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



	@SuppressWarnings("unchecked")
	@Override
	public List<T> getRules() {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select r.id,r.rule_title,r.add_time from sys_rules r where is_publish=1 order by add_time desc limit 0,5";
	    rs=ss.Search(sql1);
		List<RulesBean> rules=new ArrayList<RulesBean>();
		try {
			while(rs.next()){
				RulesBean rb=new RulesBean();
				rb.setId(rs.getInt("r.id"));
				rb.setRule_title(rs.getString("r.rule_title"));
				rb.setAdd_time(rs.getString("r.add_time"));
				rules.add(rb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ss.closeAll();
	
		}
		return (List<T>) rules;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getResearch(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
	    DBMeans ss=new DBMeans();
	    String sql1="select sr.id,sr.item_title,sr.add_time,srt.type_flag from sys_research sr,sys_research_type srt where sr.research_type_id=srt.id and srt.type_flag='"+type+"' and is_publish=1 order by add_time desc limit 0,5";
	    rs=ss.Search(sql1);
		List<ResearchBean> research=new ArrayList<ResearchBean>();
		try {
			while(rs.next()){
				ResearchBean rb=new ResearchBean();
				rb.setId(rs.getInt("sr.id"));
			    rb.setItem_title(rs.getString("sr.item_title"));
				rb.setAdd_time(rs.getString("sr.add_time"));
				rb.setType_flag(rs.getString("srt.type_flag"));
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

	
}
