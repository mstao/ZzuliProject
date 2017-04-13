<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><c:forEach items="${rule_details}" var="rule_details">${rule_details.title}</c:forEach></title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/news_details.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/home/css/tab.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/common.js"></script>
<script type="text/javascript">
$(function(){
	//右边每行标题超出字数控制
	$('.block_a').each(function(){
		var maxwidth=30;
        var text=$(this).text();
		if(text.length>maxwidth){
			$(this).text(text.substring(0,maxwidth)+'..');
		}
	});
});

</script>
</head>
<body>
	<jsp:include page="../static/header.jsp" flush="true"/>
	
	<!--S main-content-->
	<div class="main-content">
	<!--S details-->
	<div class="news-details-main">
		<c:forEach items="${rule_details}" var="rule_details">
		<div class="news-details-navi"><a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="${pageContext.request.contextPath}/instrumentrule.do?p=1">仪器规章制度</a> - 内容</div>
		<div class="newstop">
		
			<div class="newsinfo">
			<center><h1>${rule_details.title} </h1></center>
			<center><div class="publish-about"><p>发布部门：${rule_details.author}  &nbsp;发布时间： <i class="sub-time-details">${rule_details.add_time}</i> &nbsp;浏览量： ${rule_details.view_count}</p></div></center>
			
			<div class="news-content">
				${rule_details.content}
			</div>
			</div>
			
		</div>
		</c:forEach>
		
		<c:if test="${not empty file}">
		<!--S 附件区  -->
		<div class="draft-div">
		<span><b>附件：</b></span>
		 <ul>
		 <c:forEach items="${file}" var="file_list">
		 	 <li ><img src="${pageContext.request.contextPath}/home/img/j_do.png" class="dot"/> 
		 	 <a href="javascript:location.href='${pageContext.request.contextPath}/download.do?realname='+encodeURIComponent('${file_list.real_name}')+'&filename='+encodeURIComponent('${file_list.file_name}');" class="file-name">${file_list.file_name}</a></li>
		 </c:forEach>
		 </ul>
		</div>
		<!--E 附件区  -->
		</c:if>
		
	</div>
    <!--E details-->
	
	<!--S 最近更新-->
	<div class="last-updated-news">
		<span class="last-updated-news-span"><img src="${pageContext.request.contextPath}/home/img/lasttrends.png"/> 最近更新</span>
	     <div class="small-div-content  current_new">
	    	<ul>
	    	<c:forEach items="${rules_current}" var="rules_current">    
	    		<li><a href="${pageContext.request.contextPath}/inruledestails.do?id=${rules_current.id}" class="block_a">${rules_current.title}</a><span class="sub-time">[${rules_current.add_time}]</span> </li>
	        </c:forEach>
	    	</ul>
	    </div>
	</div>
	<!--E 最近更新-->
	
		<!--S 页脚-->
    <jsp:include page="../static/footer.jsp" flush="true"/>
	<!--E 页脚-->
	</div>		
	<!--E main-content-->
	
</body>
</html>
<script type="text/javascript">
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