package com.admin.dao;

import java.util.List;

/** 
 * @ClassName: IAdminAllSimpleInfoDao 
 * @Description: TODO 获取信息 （包含草稿） 
 * @date 2016年12月30日 下午2:59:53 
 * @param <T> 
 */
public interface IAdminAllSimpleInfoDao<T> {
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

 	 //获取仪器设备信息方法
 	 List<T> getSimpleInstrumentInfo(int position,int item_per_page);
 	 //获取仪器设备规章制度
 	 List<T> getSimpleInstrumentRulesInfo(int position,int item_per_page);
     //获取 人才招聘信息
 	 List<T> getSimpleEmployInfo();
 	 //获取联系我们信息
 	 List<T> getSimpleContactInfo();
	 //获取文档信息
 	 List<T> getSimpleDocumentInfo(int position, int item_per_page);
 	 //获取 管理和学术委员会人员信息
 	 List<T> getSimpleCommitteeInfo(String type,int position, int item_per_page);
 	 
 	 
 	 //获取国家自然科学基金信息
 	 List<T> getSimpleFoundationInfo(int position, int item_per_page);
 	 //获取省部级重点（大）项目
 	 List<T> getSimpleProvincialInfo(int position, int item_per_page);
 	 //获取横向合作信息
 	 List<T> getSimpleHorizontalCooperationInfo(int position, int item_per_page);
 	 
 	 //获取奖励信息
 	 List<T> getSimpleRewardsInfo(int position, int item_per_page);
 	 //获取专利信息
 	 List<T> getSimplePatentInfo(int position, int item_per_page);
 	 //获取鉴定信息
 	 List<T> getSimpleIdentificationInfo(int position, int item_per_page);
 	 //获取论文信息
 	 List<T> getSimpleThesisInfo(int position, int item_per_page);
}
