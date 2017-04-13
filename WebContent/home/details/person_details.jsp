<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><c:forEach items="${person_details}" var="person_details">${person_details.person_post}${person_details.person_name}</c:forEach></title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/news_details.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/home/css/tab.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/common.js"></script>

</head>
<body>
	<jsp:include page="../static/header.jsp" flush="true"/>
	
	<!--S main-content-->
	<div class="main-content">
	<!--S news-details-->
	<div class="news-details-main person_info_div">
		<c:forEach items="${person_details}" var="person_details">
		<div class="news-details-navi"><a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="${pageContext.request.contextPath}/person.do?p=1">${WEB_PERSON_GUGAN}</a> - 详细信息</div>
		<div class="newstop">
		
			<div class="newsinfo">
			<center><h1>${person_details.person_post}${person_details.person_name} </h1></center>
			<center><div class="publish-about"><p>发布部门：${person_details.author}  &nbsp;发布时间：<i class="sub-time-details">${person_details.add_time}</i> &nbsp;浏览量： ${person_details.view_count}</p></div></center>
			
			<div class="news-content">
			   <center> <div class="person_avatar"><img src="${person_details.avatar_file}" /></div></center>
				${person_details.person_info}
			</div>
			</div>
			
		</div>
		</c:forEach>
	</div>
    <!--E news-details-->
	
	
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