<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_RESULT_ZHUANLI}</title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/comm.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/common.js"></script>
</head>
<body>

<%--专利 --%>
	<!--S header-->
	<jsp:include page="../static/header.jsp" flush="true"/>
	<!--E header-->
	<div class="main">
		
		<!--S 左边导航栏-->
		<div class="left-nav">
			<span class="common-tag">&nbsp;${WEB_RESULT_NAVI}</span>
	        <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/notice.png"/></div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/reward.do" >${WEB_RESULT_REWRADS}</a></li>
			    <li><a href="${pageContext.request.contextPath}/patent.do" >${WEB_RESULT_ZHUANLI}</a></li>
				<li><a href="${pageContext.request.contextPath}/identification.do" >${WEB_RESULT_JIANDING}</a></li>
				<li><a href="${pageContext.request.contextPath}/thesis.do" >${WEB_RESULT_LUNWEN}</a></li>
			</ul>
		</div>
		<!--S 左边导航栏-->
		
		<!--S 右边显示内容-->
		<div class="right-content">
			<div class="now-loaction-navi">您现在所在位置: <a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="${pageContext.request.contextPath}/reward.do">${WEB_RESULT_NAVI}</a> - <a href="javascript:void(0);">${WEB_RESULT_ZHUANLI}</a></div>
		   <!--S 具体内容-->
		   <div class="details-content">
		   	<div class="project-list">
		<table >
		<c:if test="${not empty patent}">
			<tr>
				<th width="8%">序号</th>
				<th width="40%">专利名称</th>
				<th width="22%">专利类别及专利号</th>
				<th width="15%">获得者</th>
				<th width="15%">时间</th>


			</tr>
		</c:if>
			<c:set var="idx" value="0"></c:set>
			<c:forEach items="${patent}" var="patent" varStatus="xh">
			<tr>
				
				<td>${xh.count}</td>
				<td>${patent.name}</td>
				<td>${patent.style}</td>
				<td>${patent.person}</td>
				<td>${patent.time}</td>
			</tr>
		</c:forEach>
			
		</table>
		</div>
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