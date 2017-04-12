<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_INTRO_SHIYAN}</title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/comm.css" rel="stylesheet"/>
<style type="text/css">
.committee_table{
margin-top:20px;
}
.committee_table table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
.committee_table th,td{ text-align: center; border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
.committee_table th{font-weight:bold;background:#ccc;}

</style>

<script type="text/javascript">
function autoRowSpan(tb,row,col)
{
var lastValue="";
var value="";
var pos=1;
for(var i=row;i<tb.rows.length;i++){
value = tb.rows[i].cells[col].innerText;
if(lastValue == value){
tb.rows[i].deleteCell(col);
tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
pos++;
}else{
lastValue = value;
pos=1;
}
}
}

</script>
</head>
<body onload="autoRowSpan(tab,0,0)">
<!--S header-->
<jsp:include page="../static/header.jsp" flush="true"/>
<!--E header-->
<div class="main">
	
	<!--S 左边导航栏-->
	<div class="left-nav">
		<span class="common-tag">&nbsp;${WEB_INTRO_NAVI}</span>
        <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/notice.png"/></div>
		<ul>
		<li><a href="${pageContext.request.contextPath}/introduce.do?type=isg" >${WEB_INTRO_GAIKUANG}</a></li>
		<li><a href="${pageContext.request.contextPath}/introduce.do?type=izj" >${WEB_INTRO_ZUZHI}</a></li>
		<li><a href="${pageContext.request.contextPath}/committee.do?type=manage" >${WEB_INTRO_GUANLI}</a></li>
		<li><a href="${pageContext.request.contextPath}/committee.do?type=academia" >${WEB_INTRO_XUESHU}</a></li>	
		<li><a href="${pageContext.request.contextPath}/committee.do?type=director">${WEB_INTRO_SHIYAN}</a></li>
		<li><a href="${pageContext.request.contextPath}/introduce.do?type=isl" >${WEB_INTRO_LOGO}</a></li>	
		<li><a href="${pageContext.request.contextPath}/introduce.do?type=isd" >${WEB_INTRO_THING}</a></li>
		<li><a href="${pageContext.request.contextPath}/rules.do?p=1" >${WEB_INTRO_RULES}</a></li>
		</ul>
	</div>
	<!--E 左边导航栏-->
	
	<!--S 右边显示内容-->
	<div class="right-content">
	   
		<div class="now-loaction-navi">您现在所在位置: <a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="${pageContext.request.contextPath}/introduce.do?type=isg">${WEB_INTRO_NAVI}</a> - <a href="javascript:void(0);">${WEB_INTRO_SHIYAN}</a></div>
	       <!--S 具体内容-->
	       
			   <div class="details-content-text">
			   <!-- 介绍 -->
			     	<c:forEach items="${committeeintro}" var="committeeintro">
			     	${committeeintro.content}
			     	</c:forEach>
			     	<!--人员信息  -->
			     	<center>
			     	<div  class="committee_table">
						<table id="tab">
							<tr>
								<th>职务</th>
								<th>姓名</th>
								<th>性别</th>
								<th>出生年月</th>
								<th>职称</th>
								<th>研究方向</th>
								<th>所在单位</th>
							</tr>
							<c:forEach items="${committee}" var="committee_details">
							<tr>
								<td>${committee_details.post}</td>
								<td>${committee_details.name}</td>
								<td>${committee_details.sex}</td>
								<td>${committee_details.birthday}</td>
								<td>${committee_details.title}</td>
								<td>${committee_details.research}</td>
								<td>${committee_details.unit}</td>
							</tr>
							</c:forEach>
						</table>
					</div>
					</center>
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