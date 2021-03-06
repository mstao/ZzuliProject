package com.admin.dao;

/** 
 * @ClassName: IAddContentDao 
 * @Description: TODO 后台向数据库添加信息接口 
 * @date 2016年12月25日 下午6:44:11  
 */
public interface IAddContentDao {
     //添加新闻公告
	int AddNewsInfo(String type,String title,String content,String author,int is_publish,int is_image,String image_path,String add_time);
	//添加规章制度
	int AddRuleInfo(String title,String content,String author,int is_publish);
    //添加科学研究
	int AddResearchInfo(String type,String title,String content,String author,int is_publish,int is_image);
    //添加成果转化
	int AddAchievementInfo(String type,String title,String content,String author,int is_publish);
    //添加科学研究 -论文etc
	int AddAchievementLunInfo(String type,String content,String author,int is_publish);
	//添加实验室简介相关
	int AddIntroduceInfo(String type,String content,String author,int is_publish);
    //添加学生培养信息
	int AddStudentInfo(String type,String content,String author,int is_publish);
    //添加人才招聘信息
	int AddEmployInfo(String content,String author,int is_publish);
	//添加联系我们 信息
	int AddContactInfo(String content,String author,int is_publish);
	//添加 大型仪器-规章制度信息
	int AddInstrumentRuleInfo(String title,String content,String author,int is_publish);
	//添加  仪器设备
	int AddInstrumentInfo(String name,String content,String author,String img_url,String url, int is_publish);
    //添加人才队伍现状
	int AddPersonIntroInfo(String content,String author,int is_publish);
	//添加骨干信息
	int AddPersonInfo(String person_name,String person_info,String avatar_file ,String person_post,String author,int is_gugan,int is_publish);
    //添加委员会介绍信息
	int AddCommitteeIntroInfo(String type,String content,String author,int is_publish);
	//添加主任委员会人员信息
    int AddDirectorCommitteeInfo(String name,String birthday,String sex,String post,String title,String research,String unit,String author,int is_publish);
    //添加管理委员会，学术委员会人员信息
    int AddOtherCommitteeInfo(String style,String name,String birthday,String sex,String post,String title,String research,String unit,String author,int is_publish);
    
    //添加国家自然科学基金
    int AddFoundationInfo(String name,String number,String person,double outlay,String time,int is_publish);
    
    //添加省部级项目
    int AddProvincialInfo(String nameid,String person,String source,double outlay,String time,int is_publish );
    
    //添加横向合作
    int AddHorizontalCooperationInfo(String name,String cooperator,String person,double outlay,String time,int is_publish);
    
    //添加奖励
    int AddRewardsInfo(String name,String awards,String person,String time,int is_publish);
    
    //添加专利
    int AddPatentInfo(String name,String style,String person,String time,int is_publish);
    
    //添加论文
    int AddThesisInfo(String style,String author,String name,String publication_division,String page_number,int is_publish);
    
    //添加鉴定
    int AddIdentificationInfo(String name,String identification_number,String person,String time,String level,int is_publish);
    
    //添加学生培养信息
    int AddStudentCultivateInfo(String type,String title,String content,String author,int is_publish,int is_image);
}
