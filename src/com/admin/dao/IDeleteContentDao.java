package com.admin.dao;

/** 
 * @ClassName: IDeleteContentDao 
 * @Description: TODO 删除信息（批处理）
 * @date 2016年12月29日 上午10:32:03  
 */
public interface IDeleteContentDao {
    //删除新闻公告信息
	boolean  deleteNews(String[] ids);
	//删除规章制度信息
	boolean  deleteRule(String[] ids);
	//删除科学研究信息
	boolean  deleteResearch(String[] ids);
    //删除文档
	boolean  deleteDocument(String[] ids);
	//删除科研成果
	boolean  deleteAchievement(String[] ids);
	//删除 大型仪器-规章制度
	boolean  deleteInstrumentRule(String[] ids);
	//删除  大型仪器-仪器设备
	boolean  deleteInstrument(String[] ids);
	//删除人才队伍-实验室骨干信息
	boolean  deletePerosn(String[] ids);
	//删除 委员会人员信息
	boolean  deleteCommittee(String[] ids,String type);
}
