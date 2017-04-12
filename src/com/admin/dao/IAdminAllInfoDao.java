package com.admin.dao;

import java.util.List;

/** 
 * @ClassName: IAdminAllInfoDao 
 * @Description: TODO  获取信息  （不过滤草稿）
 * @date 2016年12月30日 下午4:25:34 
 * @param <T> 
 */
public interface IAdminAllInfoDao<T> {
     //获取规章制度方法
	 List<T> getRulesInfo(int id);
     //新闻公告类方法
	 List<T> getNewsInfo(int id);
	 //获取科学研究方法
	 List<T> getResearchInfo(int id);
   	 //获取人才队伍方法
	 List<T> getPersonInfo(int id);
   	 //获取科研成果--成果转化方法
   	 List<T> getAchievementInfo(int id); 	 
   	 //获取仪器设备信息方法
   	 List<T> getInstrumentInfo(int id);
   	 //获取仪器设备-规章制度的方法
   	 List<T> getInstrumentRuleInfo(int id);  	
   	 //获取人才队伍现状
   	 List<T> getPersonIntroInfo();
   	 //获取委员会介绍信息
   	 List<T> getCommitteeIntroInfo(String type);
   	 //获取 委员会人员信息
   	 List<T> getCommitteeInfo(int id,String type);
}
