package com.home.dao;

import java.util.List;

/**
 * @author Mingshan
 * @Description: 用于分页和获取少量信息接口
 * @param <T>
 */
public interface IAllSimpleInfo<T> {
	
     //新闻公告类方法
	 List<T> getSimpleNewsInfo(String type,int position,int item_per_page);
	 //获取规章制度 方法
	 List<T> getSimpleRulesInfo(int position,int item_per_page);
	 //获取科学研究方法
	 List<T> getSimpleResearchInfo(String type,int position,int item_per_page);
  	 //获取人才队伍方法
	 List<T> getSimplePersonInfo(int position,int item_per_page);
  	 //获取科研成果方法
  	 List<T> getSimpleAchievementInfo(String type,int position,int item_per_page);
  	 //获取文档信息方法
  	 List<T> getSimpleDocumentInfo(int position,int item_per_page);
  	 //获取仪器设备信息方法
  	 List<T> getSimpleInstrumentInfo(int position,int item_per_page);
     //获取仪器设备-规章制度信息
  	 List<T> getSimpleInstrumentRuleInfo(int position,int item_per_page);
}
