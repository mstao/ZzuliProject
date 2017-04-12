<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_RESULT_ZHUANHUA}</title>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/header.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/home/css/comm.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/common.js"></script>
</head>
<body>
	<!--S header-->
	<jsp:include page="../static/header.jsp" flush="true"/>
	<!--E header-->
	<div class="main">
		
		<!--S 左边导航栏-->
		<div class="left-nav">
			<span class="common-tag">&nbsp;专利</span>
	        <div class="example-img"><img src="${pageContext.request.contextPath}/home/img/notice.png"/></div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/achievement.do?type=kfl" >奖励</a></li>
			    <li><a href="${pageContext.request.contextPath}/achievement.do?type=kfz" >专利</a></li>
				<li><a href="${pageContext.request.contextPath}/achievementzhuan.do?type=kcz&p=1" >鉴定</a></li>
				<li><a href="${pageContext.request.contextPath}/achievementzhuan.do?type=kcz&p=1" >论文</a></li>
			</ul>
		</div>
		<!--S 左边导航栏-->
		
		<!--S 右边显示内容-->
		<div class="right-content">
			<div class="now-loaction-navi">您现在所在位置: <a href="${pageContext.request.contextPath}/index.do">首页</a> - <a href="${pageContext.request.contextPath}/introduce.do?type=isg">${WEB_INTRO_NAVI}</a> - <a href="javascript:void(0);">${WEB_RESULT_ZHUANHUA}</a></div>
		   <!--S 具体内容-->
		   <div class="details-content">
		   	<div class="project-list">
		<table >
			<tr>
				<th width="10%">序号</th>
				<th width="40%">项目名称</th>
				<th width="10%">项目编号</th>
				<th width="15%">项目负责人</th>
				<th width="15%">资助经费(万元)</th>
				<th width="10%">起止时间</th>

			</tr>
			<tr>
				
				<td>1</td>
				<td>一维纳米结构稀土-聚氨酯阵列的构筑及光、热响应性能调控</td>
				<td>21671178</td>
				<td>周立明</td>
				<td>65</td>
				<td>2017.01-2020.12</td>
			</tr>
		
			<tr>
				
				<td>2</td>
				<td>具有动态CO2吸附行为的金属-有机框架的构筑及其吸附性能调控</td>
				<td>21671178</td>
				<td>周立明</td>
				<td>65</td>
				<td>2017.01-2020.12</td>
			</tr>
			
			<tr>
				
				<td>2</td>
				<td>=架的构筑及其吸附性能调控</td>
				<td>21671178</td>
				<td>周立明</td>
				<td>65</td>
				<td>2017.01-2020.12</td>
			</tr>
			<tr>
				
				<td>2</td>
				<td>具有垂直石墨烯表面介孔阵列的分级多孔碳/石墨烯复合碳纳米片及其电容性能研究</td>
				<td>21671178</td>
				<td>周立明</td>
				<td>65</td>
				<td>2017.01-2020.12</td>
			</tr>
			
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