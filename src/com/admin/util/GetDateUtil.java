package com.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @ClassName: GetDateUtil 
 * @Description: TODO 获取系统时间
 * @date 2016年12月26日 下午8:56:36  
 */
public class GetDateUtil {
     public static String getData(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
 	    String condate=df.format(new Date());// new Date()为获取当前系统时间
 	    return condate;
     }
}
