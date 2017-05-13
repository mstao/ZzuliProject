package com.admin.dao;

/** 
 * @ClassName: IUpdateContentDao 
 * @Description: TODO 更新信息
 * @date 2016年12月28日 下午4:22:10  
 */
public interface IUpdateContentDao {
    //更新实验室简介信息
	boolean upadteIntroInfo(int id,String content,String author,int is_publish); 
    //更新新闻公告信息
	boolean updateNewsInfo(int id,String title,String content,String author,int is_publish,int is_image,String image_path);
    //更新规章制度信息
	boolean updateRuleInfo(int id ,String title,String content,String author,int is_publish);
    //更新科学研究信息
	boolean updateResearchInfo(int id,String title,String content,String author,int is_publish,int is_image);
    //更改学生培养信息
	boolean updateStudentInfo(int id,String content,String author,int is_publish);
    //更改人才招聘信息
	boolean updateEmployInfo(int id,String content,String author,int is_publish);
    //更新联系我们信息
	boolean  updateContactInfo(int id ,String content,String author,int is_publish);
    //更新科研成果 --成果转化
	boolean updateAchievementZhuan(int id,String  title,String content,String author,int is_publish);
    //更新 科研成果 --其他项
	boolean updateAchievementOther(int id,String content,String author,int is_publish);
    //更新  大型仪器--规章制度信息
	boolean updateInstrumentRuleInfo(int id,String title,String content,String author,int is_publish);
	//修改   大型仪器--仪器设备信息
	boolean updateInstrumentInfo(int id,String name,String content,String author,String img_url,String url, int is_publish);
    //修改  人才队伍现状信息
	boolean updatePersonIntroInfo(int id ,String content,String author,int is_publish);
	//修改 骨干信息
	boolean updatePersonInfo(int id,String person_name,String person_info,String avatar_file ,String person_post,String author,int is_gugan,int is_publish);
    //修改 委员会介绍信息
	boolean updateCommitteeIntroInfo(int id,String content,String author,int is_publish);
    //修改实验主任委员会主任信息
	boolean updateDirectorCommitteeInfo(int id,String name,String birthday,String sex,String post,String title,String research,String unit,String author,int is_publish);
	//修改 管理委员会，学术委员,实验主任委员会主任会信息
	boolean updateCommitteeInfo(int id,String type,String name,String birthday,String sex,String post,String title,String research,String unit,String author,int is_publish);
    
	//添加国家自然科学基金
    boolean updateFoundationInfo(int id,String name,String number,String person,double outlay,String time,int is_publish);
    
    //添加省部级项目
    boolean updateProvincialInfo(int id,String nameid,String person,String source,double outlay,String time,int is_publish );
    
    //添加横向合作
    boolean updateHorizontalCooperationInfo(int id,String name,String cooperator,String person,double outlay,String time,int is_publish);
    
    //添加奖励
    boolean updateRewardsInfo(int id,String name,String awards,String person,String time,int is_publish);
    
    //添加专利
    boolean updatePatentInfo(int id,String name,String style,String person,String time,int is_publish);
    
    //添加论文
    boolean updateThesisInfo(int id,String style,String author,String name,String publication_division,String page_number,int is_publish);
    
    //添加鉴定
    boolean updateIdentificationInfo(int id,String name,String identification_number,String person,String time,String level,int is_publish);
    
    //修改学生培养信息
    boolean updateStudentCultivateInfo(int id,String title,String content,String author,int is_publish,int is_image);
}
