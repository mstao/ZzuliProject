package com.home.dao;

import java.util.List;
/**
 * @author Mingshan
 * @Description: 用于获取单个信息数据接口
 * @param <T>
 */
public interface IAllInfo<T> {
	 //获取简介方法(过滤草稿)
	 List<T> getIntroduceInfo(String type);
	 //获取简介(不过滤草稿)
	 List<T> getIntroduceDraftInfo(String type);
	 //获取规章制度方法
	 List<T> getRulesInfo(int id);
     //新闻公告类方法
	 List<T> getNewsInfo(int id);
	 //获取实验室系新闻简单信息用于图片新闻轮播
	 List<T> getSliderNewsInfo(String type);
	 //获取科学研究方法
	 List<T> getResearchInfo(int id);
	 //获取在研项目简单信息 用于在研项目图片轮播
	 List<T> getSliderProject(String type);
   	 //获取人才队伍方法
	 List<T> getPersonInfo(int id);
	 //获取人才队伍现状信息
	 List<T> getPersonIntro();
	 //获取学生培养方法(过滤草稿)
   	 List<T> getStudentInfo(String type);
   	 //获取学生培养方法(不过滤草稿)
   	 List<T> getStudentDraftInfo(String type);
   	 //获取科研成果--成果转化方法
   	 List<T> getAchievementInfo(int id); 	 
   	 //获取科研成果--发表论文，发明专利
     List<T> getAchievementInfo(String type);
   	 //获取文档信息方法 
   	 List<T> getDocumentInfo(int id,String type);
   	 //获取仪器设备信息方法
   	 List<T> getInstrumentInfo(int id);
   	 //获取仪器设备-规章制度的方法
   	 List<T> getInstrumentRuleInfo(int id);
   	 //获取招聘信息方法
   	 List<T> getEmployInfo();
   	 //获取联系方式
   	 List<T> getContactInfo();
   	 //获取委员会介绍信息
   	 List<T> getCommitteeIntroInfo(String type);
   	 //获取 委员会人员信息
   	 List<T> getCommitteeInfo(String type);
   	 
     //获取 国家自然科学基金
   	 List<T> getProjectFoundationInfo();
   	 //获取 省部级重大（点）项目
   	 List<T> getProvincialProjectInfo();
   	 //获取  	横向合作
   	 List<T> getHorizontalCooperationInfo();
   	 
   	 //获取奖励
   	 List<T> getResultRewardsInfo();
   	 //获取专利
   	 List<T> getPatentInfo();
   	 //获取鉴定
   	 List<T> getIdentificationInfo();
   	 //获取论文
   	 List<T> getThesisInfo();
   	 
   	 //获取学生培养的详细信息
   	 T getStudentCultivateInfo(int id);
}
