<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_FOOTER_COPY}</title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/liMarquee.css" rel="stylesheet">
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/index.css" rel="stylesheet" /> 
<link type="text/css" href="${pageContext.request.contextPath}/home/css/liMarqueeImg.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    	$(function(){
    		//新闻标题超出字数控制
    		$('.current-new-info').each(function(){
    			var maxwidth=21;
                var text=$(this).find('a').text();
    			if(text.length>maxwidth){
    				$(this).find('a').text(text.substring(0,maxwidth)+'...');
    			}
    				
    		});
    		//根据日期判断是否显示最新图标
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
    				$(this).next().hide();
    			}
    		});
    		//新闻日期截取
    		$('.data-sub').each(function(){
    			var data_c=$(this).text();
    			var data_s=data_c.substr(6,5);
    			data_ss="["+data_s+"]";
    			$(this).text(data_ss);
    		});
    		
    		//涉及到日期显示的截取 ，除去最新新闻
    		
    		$('.sub-time').each(function(){
    			var time_c=$(this).text();
    			var time_s=time_c.substr(0,11);
    			time_ss=time_s+"]";
    			$(this).text(time_ss);
    		});
    		//四个方块每行标题超出字数控制
    		$('.block_a').each(function(){
    			var maxwidth=25;
                var text=$(this).text();
    			if(text.length>maxwidth){
    				$(this).text(text.substring(0,maxwidth)+'...');
    			}
    		});
    		
    		//仪器介绍文字字数控制
    		
    		$('.instrument-content >a').each(function(){
    			var  maxwidth=8;
    			var text=$('>span',this).text();
    			var img_title_length=text.length;
    			if(img_title_length>maxwidth){
    			$('>span',this).text(text.substring(0,maxwidth)+'..');
    		    }
    		}); 
    		
    		
    	});
</script>
	</head>
	<body>
		
		<jsp:include page="static/header.jsp" flush="true"/>
	
		<!--S main-content-->
		<div class="main-content">
		<div class="center-news">
			<span class="center-news-span"><img src="${pageContext.request.contextPath}/home/img/news.png" />  ${WEB_COMMON_NEWS_TITLE}</span>
		</div>
		
		<!--S 轮播图-->
		<div class="slider"><%--主体结构，请用此类名调用插件，此类名可自定义--%>
		<ul>
	    <c:forEach items="${slidernews}" var="s_news_list">  
			<li class="slider-li"><a href="${pageContext.request.contextPath}/newsdetails.do?id=${s_news_list.id}&type=xsx" target="_blank" ><img src="${s_news_list.image_path}" alt="${s_news_list.item_title}"  /></a></li>
		</c:forEach>	
		</ul>
	    </div>
	  
		<!--E 轮播图-->
		
		<!--S 右侧新闻-->
		<div class="news">
			<div class="current-new">
			<c:forEach items="${news}" var="news_info">
              <div class="current-new-info"><img src="${pageContext.request.contextPath}/home/img/dot.png"/><a href="${pageContext.request.contextPath}/newsdetails.do?id=${news_info.id}&type=${news_info.type_flag}" target="_blank">${news_info.item_title}</a><span class="data-sub pub-data">[${news_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif" /></div>
            </c:forEach>
				
			    <div class="look-more-news"><span><a href="${pageContext.request.contextPath}/news.do?type=xsx&p=1">更多新闻<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
			</div>
			
				<!--S 滚动-->
					<div class="roll-new-info-list">
									
					<ul>
					<c:forEach items="${news}" var="news_info">
					<li><img src="${pageContext.request.contextPath}/home/img/dot.png"/><a href="${pageContext.request.contextPath}/home/img/dot.png"/><a href="${pageContext.request.contextPath}/newsdetails.do?id=${news_info.id}&type=${news_info.type_flag}">${news_info.item_title}</a><span class="pub-data sub-time">[${news_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/></li>
					</c:forEach>
					</ul>
					
					</div>
					
			   <!--E 滚动-->			
		</div>
		<!--E 右侧新闻-->
		
		<!--S 公告通知-->
		<div class="notice small-div">
			<span class="notice-span  common-tag">&nbsp;${WEB_NEWS_NOTICE} ${WEB_ENGLISH_BLOCK_NOTICE}</span>
		    <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/notice.png"/></div>
		    <div class="small-div-content">
		    	<ul>
		    		<c:forEach items="${notice}" var="notice_info">        
		    		<li><a href="${pageContext.request.contextPath}/newsdetails.do?id=${notice_info.id}&type=${notice_info.type_flag}" target="_blank" class="block_a">${notice_info.item_title}</a><span class="pub-data sub-time">[${notice_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/> </li>
		    		</c:forEach>
		    	</ul>
		    </div>
		    <div class="look-more"><span><a href="${pageContext.request.contextPath}/news.do?type=xgt&p=1">查看更多<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
		</div>
		<!--E 公告通知-->
		
	    <!--S 学术动态 -->
		<div class="academic small-div">
			<span class="academic-span  common-tag">&nbsp;学术动态  ACADEMIC</span>
		    <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/academic.jpg"/></div>
		    <div class="small-div-content">
		    	<ul>
		    		<c:forEach items="${academic}" var="academic_info">        
		    		<li><a href="${pageContext.request.contextPath}/newsdetails.do?id=${academic_info.id}&type=${academic_info.type_flag}" target="_blank" class="block_a">${academic_info.item_title}</a><span class="pub-data sub-time">[${academic_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/> </li>
		    		</c:forEach>
		    	</ul>
		    </div>
		    <div class="look-more"><span><a href="${pageContext.request.contextPath}/news.do?type=xxb&p=1">查看更多<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
		</div>
		
		<!--S 学术动态  -->
		
		<!--S 研究亮点-->
		<div class="research-highlights small-div">
			<span class="research-highlights-span common-tag">&nbsp;${WEB_RESEARCH_LIANGDIAN} ${WEB_ENGLISH_BLOCK_RESEARCH}</span>
		    <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/research.jpg"/></div>
		    <div class="small-div-content">
		    	<ul>
		    	<c:forEach items="${research}" var="research_info"> 
		    		<li><a href="${pageContext.request.contextPath}/researchdetails.do?id=${research_info.id}&type=${research_info.type_flag}" target="_blank" class="block_a">${research_info.item_title}</a><span class="pub-data sub-time">[${research_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/> </li>
		    	</c:forEach>	
		    	</ul>
		    </div>
		    <div class="look-more"><span><a href="${pageContext.request.contextPath}/research.do?type=kyl&p=1">查看更多<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
		    
		</div>
		<!--E 研究亮点-->
		
		<!--S 规章制度-->
		<div class="rules small-div">
			<span class="rules-span common-tag">&nbsp;${WEB_INTRO_RULES} ${WEB_ENGLISH_BLOCK_RULES}</span>
		    <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/rules.jpg"/></div>
		    <div class="small-div-content">
		    	<ul>
		    	<c:forEach items="${rules}" var="rules_info"> 
		    		<li><a href="${pageContext.request.contextPath}/ruledetails.do?rid=${rules_info.id}" target="_blank" class="block_a">${rules_info.rule_title}</a><span class="pub-data sub-time">[${rules_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/> </li>		    		
		    	</c:forEach>
		    	</ul>
		    </div>
		    <div class="look-more"><span><a href="${pageContext.request.contextPath}/rules.do?p=1">查看更多<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
		</div>
		<!--E 规章制度 -->
		
		<!--S 在研项目-->
		<%-- <div class="research-project small-div">
			<span class="research-project-span common-tag">&nbsp;${WEB_RESEARCH_PROJECT} ${WEB_ENGLISH_BLOCK_PROJECT}</span>
		    <!--<div class="example-img"><img src="img/project.png"/></div>-->
		    <div class="example-research">主体结构，请用此类名调用插件，此类名可自定义
			<ul>
			 <c:forEach items="${sliderproject}" var="s_project_list">  
		     	<li class="slider-li"><a href="${pageContext.request.contextPath}/researchdetails.do?id=${s_project_list.id}&type=kzx" target="_blank" ><img src="" alt="${s_project_list.item_title}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_project_list.item_content}</div></li>
		     </c:forEach>
				
			</ul>
		    </div>
		    <div class="small-div-content research-ulli">
		    	<ul>
		    	<c:forEach items="${project}" var="project_info"> 
		    		<li><a href="${pageContext.request.contextPath}/researchdetails.do?id=${project_info.id}&type=${project_info.type_flag}" target="_blank" class="block_a">${project_info.item_title}</a><span class="pub-data sub-time">[${project_info.add_time}]</span><img src="${pageContext.request.contextPath}/home/img/hot.gif"/> </li>
		    	</c:forEach>	
		    	</ul>
		    </div>
		    <div class="look-more"><span><a href="${pageContext.request.contextPath}/research.do?type=kzx&p=1">查看更多<img src="${pageContext.request.contextPath}/home/img/more.png"/></a></span></div>
		</div> --%>
		<!--E 在研项目-->
		<div class="clear"></div>
		
		<!--S 仪器展示-->
		
		<div class="instrument">
			<div class="instrument-title"><img src="${pageContext.request.contextPath}/home/img/instrument.png"/><span> ${WEB_COMMON_INSTRUMENT_TITLE} </span></div>
		    <div class="instrument-content">
	           <c:forEach items="${instrument_show}" var="instrument_list">
	            <a href="${pageContext.request.contextPath}/instrumentdestails.do?id=${instrument_list.id}"><img src="${instrument_list.instrument_image}"  title="${instrument_list.instrument_name}"/><span>${instrument_list.instrument_name}</span></a>
		       </c:forEach>
		    	
		    </div>
		</div>
		<!--E 仪器展示-->
		
		<jsp:include page="static/footer.jsp" flush="true"/>
</div>
<!--E main-content-->
		
</body>
</html>
<script src="${pageContext.request.contextPath}/home/js/jquery.liMarquee.js"></script>
<script src="${pageContext.request.contextPath}/home/js/YuxiSlider.jQuery.min.js"></script>
<script type="text/javascript">



$(function(){
	    //新闻循环展示
        $('.roll-new-info-list').liMarquee({
            direction: 'up',//向上滚动
            scrollamount: 30//滚动速度
        });
        
        //仪器展示
        $('.instrument-content').liMarquee({
        	  direction: 'left',//向左滚动
        });
        //新闻轮播
        $(".slider").YuxiSlider({
			width:350, //容器宽度
			height:230, //容器高度
			control:$('.control'), //绑定控制按钮
			during:3000, //间隔3秒自动滑动
			speed:800, //移动速度0.8秒
			mousewheel:true, //是否开启鼠标滚轮控制
			direkey:false //是否开启左右箭头方向控制
		});
	
});


function showLocale(objD)
{
	var str,colorhead,colorfoot;
	var yy = objD.getYear();
	if(yy<1900) yy = yy+1900;
	var MM = objD.getMonth()+1;
	if(MM<10) MM = '0' + MM;
	var dd = objD.getDate();
	if(dd<10) dd = '0' + dd;
	var hh = objD.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = objD.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = objD.getSeconds();
	if(ss<10) ss = '0' + ss;
	var ww = objD.getDay();
	if  ( ww==0 )  colorhead="<font color=\"#FFFFFF\">";
	if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"#FFFFFF\">";
	if  ( ww==6 )  colorhead="<font color=\"#FFFFFF\">";
	if  (ww==0)  ww="星期日";
	if  (ww==1)  ww="星期一";
	if  (ww==2)  ww="星期二";
	if  (ww==3)  ww="星期三";
	if  (ww==4)  ww="星期四";
	if  (ww==5)  ww="星期五";
	if  (ww==6)  ww="星期六";
	colorfoot="</font>"
	str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "  " + ww + colorfoot;
	return(str);
}
function tick()
{
	var today;
	today = new Date();
	document.getElementById("localtime").innerHTML = showLocale(today);
	window.setTimeout("tick()", 1000);
}
tick();



</script>