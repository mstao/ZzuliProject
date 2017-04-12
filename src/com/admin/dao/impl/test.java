package com.admin.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class test {
	
    public static void main(String[] args){
    	String username="han";
    	String password="han";
    	new LoginDaoImpl().registerUser(username, password);

    	String loginUserId="admin";
    	String pwd="admin";
    	try {
    		 if(new LoginDaoImpl().loginValid(loginUserId,pwd)){
    		 System.out.println("欢迎登陆！！！");
    		 }else{
    		 System.out.println("口令错误，请重新输入！！！");
    		 }
    		 } catch (NoSuchAlgorithmException e) {
    		 // TODO Auto-generated catch block
    		 e.printStackTrace();
    		 } catch (UnsupportedEncodingException e) {
    		 // TODO Auto-generated catch block
    		 e.printStackTrace();
    	} 
    }
}
