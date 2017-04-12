package com.home.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @Project: ZzuliProject
 * @author Mingshan
 * @Date: 2016年12月17日
 * 
 */
public class ReadWebConfig extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 1L;

    //网站配置文件路径
    private static final String BUNDLE_NAM="/webconfig.properties";
    /*网站的配置信息声明*/
   	
    /*导航栏配置信息声明*/
	
	/*实验室简介配置信息声明*/
	public static String WEB_INTRO_NAVI;
	public static String WEB_INTRO_GAIKUANG;
	public static String WEB_INTRO_ZUZHI;
	public static String WEB_INTRO_GUANLI;
	public static String WEB_INTRO_XUESHU;
	public static String WEB_INTRO_SHIYAN;
	public static String WEB_INTRO_LOGO;
	public static String WEB_INTRO_THING;
	public static String WEB_INTRO_RULES;
	
	/*新闻公告信息声明*/
	public static String WEB_NEWS_NAVI;
	public static String WEB_NEWS_NEWS;
	public static String WEB_NEWS_NOTICE;
	public static String WEB_NEWS_JIANG;
	public static String WEB_NEWS_YANTAO;
	
	/*科学研究信息声明*/
	public static String WEB_RESEARCH_NAVI;
	public static String WEB_RESEARCH_LIANGDIAN;
	public static String WEB_RESEARCH_PROJECT;
	public static String WEB_RESEARCH_PROJECT_FOUNDATION;
	public static String WEB_RESEARCH_PROJECT_PROVINCIAL;
	public static String WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION;
	/*人才队伍信息声明*/
	public static String WEB_PERSON_NAVI;
	public static String WEB_PERSON_STATUS;
	public static String WEB_PERSON_GUGAN;
	public static String WEB_PERSON_XIE;
	
	/*学生培养信息声明*/
	public static String WEB_STUDENT_NAVI;
	public static String WEB_STUDENT_BEN;
	public static String WEB_STUDENT_YAN;
	public static String WEB_STUDENT_RESULT;
	
	/*科研成果信息声明*/
	public static String WEB_RESULT_NAVI;
	public static String WEB_RESULT_LUNWEN;
	public static String WEB_RESULT_ZHUANLI;
	public static String WEB_RESULT_REWRADS;
	public static String WEB_RESULT_JIANDING;
	/*文档下载*/
	public static String WEB_DOC_NAVI;
	
	/*大型仪器*/
	public static String WEB_INSTRUMENT_NAVI;
	public static String WEB_INSTRUMENT_DETAILS;
	public static String WEB_INSTRUMENT_RULES;
	
	/*人才招聘*/
	public static String WEB_EMPLOY_NAVI;
	
	
	/*网站其他配置信息 声明*/
	
	/*公共信息*/
	public static String WEB_COMMON_NEWS_TITLE;
	public static String WEB_COMMON_INSTRUMENT_TITLE;
	public static String WEB_ENGLISH_BLOCK_NOTICE;
	public static String WEB_ENGLISH_BLOCK_RULES;
	public static String WEB_ENGLISH_BLOCK_RESEARCH;
	public static String WEB_ENGLISH_BLOCK_PROJECT;
	
	/*网站底部*/
	public static String WEB_FOOTER_COPY;
	public static String WEB_FOOTER_CONTACT;
	public static String WEB_FOOTER_ZZULI;
	public static String WEB_FOOTER_ZZULI_URL;
	public static String WEB_FOOTER_HUAGONG;
	public static String WEB_FOOTER_HUAGONG_URL;
	public static String WEB_CURRENT_YEAR;
	static {   
		  //获取当前年份
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	      Date date = new Date();
	      String formatDate = sdf.format(date);
	      WEB_CURRENT_YEAR=formatDate;
	      //读取网站配置文件
	      Properties prop = new Properties();   
	      InputStream in = null;
		  in =ReadWebConfig.class.getResourceAsStream(ReadWebConfig.BUNDLE_NAM); 
		  BufferedReader bf = null;
		  try {
			//解决中文乱码 须将其转为字符流形式读取，中文不支持字节流读取
			bf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		   } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
		  try {   
	          prop.load(bf);   
	          /*实验室简介配置信息*/
	          WEB_INTRO_NAVI = prop.getProperty("WEB_INTRO_NAVI").trim();   
	          WEB_INTRO_GAIKUANG=prop.getProperty("WEB_INTRO_GAIKUANG").trim();
	          WEB_INTRO_ZUZHI=prop.getProperty("WEB_INTRO_ZUZHI").trim();
	          WEB_INTRO_GUANLI=prop.getProperty("WEB_INTRO_GUANLI").trim();
	          WEB_INTRO_XUESHU=prop.getProperty("WEB_INTRO_XUESHU").trim();
	          WEB_INTRO_SHIYAN=prop.getProperty("WEB_INTRO_SHIYAN").trim();
	          WEB_INTRO_LOGO=prop.getProperty("WEB_INTRO_LOGO").trim();
	          WEB_INTRO_THING=prop.getProperty("WEB_INTRO_THING").trim();
	          WEB_INTRO_RULES=prop.getProperty("WEB_INTRO_RULES").trim();
	          
	          /*新闻公告*/
	          WEB_NEWS_NAVI=prop.getProperty("WEB_NEWS_NAVI").trim();
	          WEB_NEWS_NEWS=prop.getProperty("WEB_NEWS_NEWS").trim();
	          WEB_NEWS_NOTICE=prop.getProperty("WEB_NEWS_NOTICE").trim();
	          WEB_NEWS_JIANG=prop.getProperty("WEB_NEWS_JIANG").trim();
	          WEB_NEWS_YANTAO=prop.getProperty("WEB_NEWS_YANTAO").trim();
	          
	          /*科学研究*/
	          WEB_RESEARCH_NAVI=prop.getProperty("WEB_RESEARCH_NAVI").trim();	        
	          WEB_RESEARCH_LIANGDIAN=prop.getProperty("WEB_RESEARCH_LIANGDIAN").trim();
	          WEB_RESEARCH_PROJECT=prop.getProperty("WEB_RESEARCH_PROJECT").trim();
	          WEB_RESEARCH_PROJECT_FOUNDATION=prop.getProperty("WEB_RESEARCH_PROJECT_FOUNDATION").trim();
	          WEB_RESEARCH_PROJECT_PROVINCIAL=prop.getProperty("WEB_RESEARCH_PROJECT_PROVINCIAL").trim();
	          WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION=prop.getProperty("WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION").trim();
	        
	          /*人才队伍*/
	          WEB_PERSON_NAVI=prop.getProperty("WEB_PERSON_NAVI").trim();
	          WEB_PERSON_STATUS=prop.getProperty("WEB_PERSON_STATUS").trim();
	          WEB_PERSON_GUGAN=prop.getProperty("WEB_PERSON_GUGAN").trim();
	          WEB_PERSON_XIE=prop.getProperty("WEB_PERSON_XIE").trim();
	          
	          /*学生培养*/
	          WEB_STUDENT_NAVI=prop.getProperty("WEB_STUDENT_NAVI").trim();
	          WEB_STUDENT_BEN=prop.getProperty("WEB_STUDENT_BEN").trim();
	          WEB_STUDENT_YAN=prop.getProperty("WEB_STUDENT_YAN").trim();
	          WEB_STUDENT_RESULT=prop.getProperty("WEB_STUDENT_RESULT").trim();
	          
	          /*科研成果*/
	          WEB_RESULT_NAVI=prop.getProperty("WEB_RESULT_NAVI").trim();
	          WEB_RESULT_LUNWEN=prop.getProperty("WEB_RESULT_LUNWEN").trim();
	          WEB_RESULT_ZHUANLI=prop.getProperty("WEB_RESULT_ZHUANLI").trim();
	          WEB_RESULT_JIANDING=prop.getProperty("WEB_RESULT_JIANDING").trim();
	          WEB_RESULT_REWRADS=prop.getProperty("WEB_RESULT_REWRADS").trim();
	          /*文档下载*/
	          WEB_DOC_NAVI=prop.getProperty("WEB_DOC_NAVI").trim();
	          
	          /*大型仪器*/
	          WEB_INSTRUMENT_NAVI=prop.getProperty("WEB_INSTRUMENT_NAVI").trim();
	          WEB_INSTRUMENT_DETAILS=prop.getProperty("WEB_INSTRUMENT_DETAILS").trim();
	          WEB_INSTRUMENT_RULES=prop.getProperty("WEB_INSTRUMENT_RULES").trim();
	          
	          /*人才招聘*/
	          WEB_EMPLOY_NAVI=prop.getProperty("WEB_EMPLOY_NAVI").trim();
	          
	          /*网站其他配置信息 声明*/
	      	
	          /*公共信息*/
	          WEB_COMMON_NEWS_TITLE=prop.getProperty("WEB_COMMON_NEWS_TITLE").trim();
	          WEB_COMMON_INSTRUMENT_TITLE=prop.getProperty("WEB_COMMON_INSTRUMENT_TITLE").trim();
	          WEB_ENGLISH_BLOCK_NOTICE=prop.getProperty("WEB_ENGLISH_BLOCK_NOTICE").trim();
	          WEB_ENGLISH_BLOCK_RULES=prop.getProperty("WEB_ENGLISH_BLOCK_RULES").trim();
	          WEB_ENGLISH_BLOCK_RESEARCH=prop.getProperty("WEB_ENGLISH_BLOCK_RESEARCH").trim();
	          WEB_ENGLISH_BLOCK_PROJECT=prop.getProperty("WEB_ENGLISH_BLOCK_PROJECT").trim();
	          
	          /*网站底部*/
	          WEB_FOOTER_COPY=prop.getProperty("WEB_FOOTER_COPY").trim();
	          WEB_FOOTER_CONTACT=prop.getProperty("WEB_FOOTER_CONTACT").trim();
	          WEB_FOOTER_ZZULI=prop.getProperty("WEB_FOOTER_ZZULI").trim();
	          WEB_FOOTER_ZZULI_URL=prop.getProperty("WEB_FOOTER_ZZULI_URL").trim();
	          WEB_FOOTER_HUAGONG=prop.getProperty("WEB_FOOTER_HUAGONG").trim();
	          WEB_FOOTER_HUAGONG_URL=prop.getProperty("WEB_FOOTER_HUAGONG_URL").trim();
	          
	          in.close();
	          bf.close();
	      } catch (IOException e) {   
	          e.printStackTrace();   
	      }   
	           
	  }
	//初始化信息
	public void init() throws ServletException{
		/*实验室简介配置信息*/
		getServletContext().setAttribute("WEB_INTRO_NAVI",WEB_INTRO_NAVI);
		getServletContext().setAttribute("WEB_INTRO_GAIKUANG",WEB_INTRO_GAIKUANG);
		getServletContext().setAttribute("WEB_INTRO_ZUZHI",WEB_INTRO_ZUZHI);
		getServletContext().setAttribute("WEB_INTRO_GUANLI",WEB_INTRO_GUANLI);
		getServletContext().setAttribute("WEB_INTRO_XUESHU",WEB_INTRO_XUESHU);
		getServletContext().setAttribute("WEB_INTRO_SHIYAN",WEB_INTRO_SHIYAN);
		getServletContext().setAttribute("WEB_INTRO_LOGO",WEB_INTRO_LOGO);
		getServletContext().setAttribute("WEB_INTRO_THING",WEB_INTRO_THING);
		getServletContext().setAttribute("WEB_INTRO_RULES",WEB_INTRO_RULES);
		/*新闻公告*/
		getServletContext().setAttribute("WEB_NEWS_NAVI",WEB_NEWS_NAVI);
		getServletContext().setAttribute("WEB_NEWS_NEWS",WEB_NEWS_NEWS);
		getServletContext().setAttribute("WEB_NEWS_NOTICE",WEB_NEWS_NOTICE);
		getServletContext().setAttribute("WEB_NEWS_JIANG",WEB_NEWS_JIANG);
		getServletContext().setAttribute("WEB_NEWS_YANTAO",WEB_NEWS_YANTAO);
		/*科学研究*/
		getServletContext().setAttribute("WEB_RESEARCH_NAVI",WEB_RESEARCH_NAVI);
		getServletContext().setAttribute("WEB_RESEARCH_LIANGDIAN",WEB_RESEARCH_LIANGDIAN);
		getServletContext().setAttribute("WEB_RESEARCH_PROJECT",WEB_RESEARCH_PROJECT);
		getServletContext().setAttribute("WEB_RESEARCH_PROJECT_FOUNDATION",WEB_RESEARCH_PROJECT_FOUNDATION);
		getServletContext().setAttribute("WEB_RESEARCH_PROJECT_PROVINCIAL",WEB_RESEARCH_PROJECT_PROVINCIAL);
		getServletContext().setAttribute("WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION",WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION);
		/*人才队伍*/
		getServletContext().setAttribute("WEB_PERSON_NAVI",WEB_PERSON_NAVI);
		getServletContext().setAttribute("WEB_PERSON_STATUS",WEB_PERSON_STATUS);
		getServletContext().setAttribute("WEB_PERSON_GUGAN",WEB_PERSON_GUGAN);
		getServletContext().setAttribute("WEB_PERSON_XIE",WEB_PERSON_XIE);
		/*学生培养*/
		getServletContext().setAttribute("WEB_STUDENT_NAVI",WEB_STUDENT_NAVI);
		getServletContext().setAttribute("WEB_STUDENT_BEN",WEB_STUDENT_BEN);
		getServletContext().setAttribute("WEB_STUDENT_YAN",WEB_STUDENT_YAN);
		getServletContext().setAttribute("WEB_STUDENT_RESULT",WEB_STUDENT_RESULT);
		/*科研成果*/
		getServletContext().setAttribute("WEB_RESULT_NAVI",WEB_RESULT_NAVI);
		getServletContext().setAttribute("WEB_RESULT_LUNWEN",WEB_RESULT_LUNWEN);
		getServletContext().setAttribute("WEB_RESULT_ZHUANLI",WEB_RESULT_ZHUANLI);
		getServletContext().setAttribute("WEB_RESULT_JIANDING",WEB_RESULT_JIANDING);
		getServletContext().setAttribute("WEB_RESULT_REWRADS",WEB_RESULT_REWRADS);
		/*文档下载*/
		getServletContext().setAttribute("WEB_DOC_NAVI",WEB_DOC_NAVI);
		/*大型仪器*/
		getServletContext().setAttribute("WEB_INSTRUMENT_NAVI",WEB_INSTRUMENT_NAVI);
		getServletContext().setAttribute("WEB_INSTRUMENT_DETAILS",WEB_INSTRUMENT_DETAILS);
		getServletContext().setAttribute("WEB_INSTRUMENT_RULES",WEB_INSTRUMENT_RULES);
		/*人才招聘*/
		getServletContext().setAttribute("WEB_EMPLOY_NAVI",WEB_EMPLOY_NAVI);
		/*公共信息*/
		getServletContext().setAttribute("WEB_COMMON_NEWS_TITLE",WEB_COMMON_NEWS_TITLE);
		getServletContext().setAttribute("WEB_COMMON_INSTRUMENT_TITLE",WEB_COMMON_INSTRUMENT_TITLE);		
		getServletContext().setAttribute("WEB_ENGLISH_BLOCK_NOTICE",WEB_ENGLISH_BLOCK_NOTICE);
		getServletContext().setAttribute("WEB_ENGLISH_BLOCK_RULES",WEB_ENGLISH_BLOCK_RULES);
		getServletContext().setAttribute("WEB_ENGLISH_BLOCK_RESEARCH",WEB_ENGLISH_BLOCK_RESEARCH);
		getServletContext().setAttribute("WEB_ENGLISH_BLOCK_PROJECT",WEB_ENGLISH_BLOCK_PROJECT);
		/*网站底部*/
		getServletContext().setAttribute("WEB_FOOTER_COPY",WEB_FOOTER_COPY);
		getServletContext().setAttribute("WEB_FOOTER_CONTACT",WEB_FOOTER_CONTACT);
		getServletContext().setAttribute("WEB_FOOTER_ZZULI",WEB_FOOTER_ZZULI);
		getServletContext().setAttribute("WEB_FOOTER_ZZULI_URL",WEB_FOOTER_ZZULI_URL);
		getServletContext().setAttribute("WEB_FOOTER_HUAGONG",WEB_FOOTER_HUAGONG);
		getServletContext().setAttribute("WEB_FOOTER_HUAGONG_URL",WEB_FOOTER_HUAGONG_URL);
		getServletContext().setAttribute("WEB_CURRENT_YEAR",WEB_CURRENT_YEAR);
	}
	 

	
	  
	  
}
