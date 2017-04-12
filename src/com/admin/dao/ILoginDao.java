package com.admin.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/** 
 * @ClassName: ILoginDao 
 * @Description: TODO 登录处理接口
 * @date 2017年1月5日 上午11:15:04  
 */
public interface ILoginDao {
	//通过用户名称获取用户密码，防止Sql注入
	String getPassword(String userName);
	//验证用户密码是否正确(经过MD5加密后验证)
	boolean loginValid(String username,String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
    //注册用户  ,该功能不对外提供,仅测试和添加管理用户
	void registerUser(String username,String password);
	//修改密码
	boolean updatePassword(String username,String password);
}
