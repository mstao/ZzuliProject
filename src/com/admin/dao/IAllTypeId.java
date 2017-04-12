package com.admin.dao;


/** 
 * @ClassName: IAllTypeInfo 
 * @Description: TODO 获取类型信息，用于写信息时选择
 * @date 2016年12月23日 下午8:24:56  
 */
public interface IAllTypeId {
    //获取新闻公告的类型id
	int getNewsTypeId(String type_flag);
	//获取文件类型id
	int getFileTypeId(String type_flag);
	//获取科学研究的类型id
	int getResearchTypeId(String type_flag);
	//获取科研成果的类型id
	int getAchievementTypeId(String type_flag);
	//获取实验室简介相关类型id
	int getIntroduceTypeId(String type_flag);
	//获取学生培养相关的类型id
	int getStudentTypeId(String type_flag);
	//获取委员会介绍信息
	int getCommitteeIntroTypeId(String type_flag);
	//获取职位id
	int getPostTypeId(String type_flag);
}
