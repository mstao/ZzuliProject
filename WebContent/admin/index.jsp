<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>主页-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js"></script>
<script type="text/javascript">
$(function(){
	
	
	//日期截取
	$('.data-sub').each(function(){
		var data_c=$(this).text();
		var data_s=data_c.substr(6,5);
		data_ss="["+data_s+"]";
		$(this).text(data_ss);
	});
	
	
	//每行标题超出字数控制
	$('.block_a').each(function(){
		var maxwidth=40;
        var text=$(this).text();
		if(text.length>maxwidth){
			$(this).text(text.substring(0,maxwidth)+'...');
		}
	});
});

</script>
</head>
<body>
<!--S header-->
<jsp:include page="common/header.jsp" flush="true"/>		
<!--E header-->

<!--S main-->
<div class="main">
	<span class="web_summary_span">网站概要</span>
	<div class="web_summary_content">
		<span class="current_tag">目前网站有</span>
		<table>
			<tr>
				<td>${WEB_NEWS_NEWS}:</td><td><span><em>${newsCount}</em></span> 条新闻</td>
				<td>${WEB_NEWS_NOTICE}:</td><td><span><em>${noticeCount}</em></span> 条公告</td>
			</tr>
			<tr>
				<td>${WEB_INTRO_RULES}:</td><td><span><em>${ruleCount}</em></span> 条规章</td>
				<td>${WEB_RESEARCH_PROJECT}:</td><td><span><em>${projectCount}</em></span> 条项目</td>
			</tr>

		</table>
		<span class="link_operation_span">点击下面的链接快速操作</span>
		<div class="operate_div">
		<a href="${pageContext.request.contextPath}/admin/news/writeNews.html">撰写新闻公告</a><a href="${pageContext.request.contextPath}/admin/rules/writeRules.html">撰写规章制度</a><a href="${pageContext.request.contextPath}/admin/research/writeResearch.html">撰写在研项目</a><a href="${pageContext.request.contextPath}/showdocument.ado?p=1">查看文档</a>
		</div>
		<br><br><hr style="color:#CCCCCC;border:0.5px solid #CCCCCC" >
	    
	    <!--S 最近更新-->
	    <div class="last-update"> 
	    	<div class="last-update-news">
	    		<span class="last-update-span">最近更新${WEB_NEWS_NEWS}：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			<c:forEach items="${news}" var="news_list">
	    				<li><span class="data-sub">[${news_list.add_time}]</span><a href="${pageContext.request.contextPath}/updatenews.ado?id=${news_list.id}&type=${news_list.type_flag}" class="block_a">${news_list.item_title}</a></li>
	    			</c:forEach>	
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-notices">
	    		<span class="last-update-span">最近更新${WEB_NEWS_NOTICE}：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			<c:forEach items="${notice}" var="notice_list">
	    				<li><span class="data-sub">[${notice_list.add_time}]</span><a href="${pageContext.request.contextPath}/updatenews.ado?id=${notice_list.id}&type=${notice_list.type_flag}" class="block_a">${notice_list.item_title}</a></li>
	    			</c:forEach>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-research">
	    		<span class="last-update-span">最近更新${WEB_RESEARCH_LIANGDIAN}：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			<c:forEach items="${research}" var="research_list">
	    				<li><span class="data-sub">[${research_list.add_time}]</span><a href="${pageContext.request.contextPath}/updateresearch.ado?id=${research_list.id}&type=${research_list.type_flag}" class="block_a">${research_list.item_title}</a></li>
	    			</c:forEach>
	    			</ul>
	    		</div>
	    	</div>
	    </div>
	    <!--E 最近更新-->
	</div>
	
</div>
<!--E main-->

<!--S footer-->
<jsp:include page="common/footer.jsp" flush="true"/>	
<!--E footer-->
	</body>
</html>