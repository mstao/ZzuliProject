﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_EMPLOY_NAVI}</title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/comm.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/tab.css" rel="stylesheet"/>
</head>
<body>
	<!--S header-->
	<jsp:include page="../static/header.jsp" flush="true"/>
	<!--E header-->
	<div class="main">
		
		<!--S 左边导航栏-->
		<div class="left-nav">
			<span class="common-tag">&nbsp;${WEB_EMPLOY_NAVI}</span>
	        <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/notice.png"/></div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/employ.do" >${WEB_EMPLOY_NAVI}</a></li>	
			</ul>
		</div>
		<!--S 左边导航栏-->
		
		<!--S 右边显示内容-->
		<div class="right-content">
			<div class="now-loaction-navi">您现在所在位置: <a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="javascript:void(0);">${WEB_EMPLOY_NAVI}</a></div>
		   	<!--S 具体内容-->
		   	<div class="details-content-text">
		   		<c:forEach items="${employ}" var="employ_info">
		   		${employ_info.content}
		   	   	</c:forEach>	
		    </div>
		   <!--E 具体内容-->

		</div>
		<!--E 右边显示内容-->
		
		<!--S 页脚-->
	    <jsp:include page="../static/footer.jsp" flush="true"/>
		<!--E 页脚-->
	</div>
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