
$(function(){
	//根据日期判断是否显示最新图标  不用于主页
	$('.pub-data').each(function(){
		//获取日期的标志月份信息
		var data_m=$(this).text().substring(6,8);
		//获取日期的标志年份信息
		var data_y=$(this).text().substring(1,5);
		//获取系统时间的月份
		var today = new Date();
		var month=today.getMonth()+1;
		var year=today.getFullYear();
		if(month!=data_m || data_y!=year ){
			$(this).prev().hide();
		}
	});	
	
	//涉及到日期显示的截取 ，除去最新新闻
	
	$('.sub-time').each(function(){
		var time_c=$(this).text();
		var time_s=time_c.substr(0,11);
		time_ss=time_s+"]";
		$(this).text(time_ss);
	});
	
	//详细信息 发布日期 截取
	$('.sub-time-details').each(function(){
		var time_c=$(this).text();
		var time_s=time_c.substr(0,11);
		time_ss=time_s;
		$(this).text(time_ss);
	});
	
	$('.details-content > ul > li').each(function(){
		var text=$(this).find("a").text();
		var maxwidth=40;
       
		if(text.length>maxwidth){
			$(this).find('a').text(text.substring(0,maxwidth)+'...');
		}
			
	});
});
