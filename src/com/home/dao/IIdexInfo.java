
package com.home.dao;

import java.util.List;


/** 
 * @ClassName: IIdexInfo 
 * @Description: TODO  用于获取首页描述信息接口
 * @author Mingshan
 * @param <T>
 * @date 2016年12月18日 下午2:27:19  
 */
public interface IIdexInfo<T> {
    //获取新闻公告信息
	List<T> getNews(String type);
    //获取规章制度信息
    List<T> getRules();
    //获取科学研究信息
    List<T> getResearch(String type);

}
