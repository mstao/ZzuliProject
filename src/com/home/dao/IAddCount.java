package com.home.dao;


/** 
 * @ClassName: IAddCount 
 * @Description: TODO 浏览量+1 接口
 * @date 2016年12月21日 上午11:09:13  
 */
public interface IAddCount {
   
	//新闻公告  浏览量+1
	boolean addNewsCount(int id);
	//规章制度  浏览量+1
	boolean addRuleCount(int id);
	//科学研究 浏览量+1
	boolean addResearchCount(int id);
	//人才队伍 浏览量+1
	boolean addPersonCount(int id);
	//大型仪器  浏览量+1
	boolean addInstrumentCount(int id);
	//大型仪器 -规章制度  浏览量+1
	boolean addInstrumentRuleCount(int id);
}
