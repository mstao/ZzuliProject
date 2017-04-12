package com.home.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTo {
	/* 
     * 将时间转换为时间戳  只有年月日
     */    
    public static int dateToStamp(long s) throws ParseException{
 /*       String res;*/
    	String ss;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ss=String.valueOf(s);
        Date date = simpleDateFormat.parse(ss);
        long ts = date.getTime();
        /*res = String.valueOf(ts);*/
        return (int) ts;
    }
    
    /* 
     * 将时间戳转换为时间 只有年月日
     */
    public static String stampToDate(int s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
    public static void main(String[] args){
    	try {
			System.out.print(dateToStamp(System.currentTimeMillis()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
}
