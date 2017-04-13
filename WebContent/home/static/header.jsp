<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--S header-->
<div class="header"> 
<!--S navigation-->
<div class="header-info"></div>		
<div class="navi">
	<ul>
		<li><a href="${pageContext.request.contextPath}/index.do">首页 </a></li>
		<li><a href="${pageContext.request.contextPath}/introduce.do?type=isg">${WEB_INTRO_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/news.do?type=xsx&p=1">${WEB_NEWS_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/research.do?type=kyl&p=1">${WEB_RESEARCH_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/person.do?p=1">${WEB_PERSON_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/student.do?type=xbp">${WEB_STUDENT_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/reward.do">${WEB_RESULT_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/document.do?p=1">${WEB_DOC_NAVI}</a></li>
		<li><a href="${pageContext.request.contextPath}/instrument.do?p=1">${WEB_INSTRUMENT_NAVI}</a>
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/instrument.do?p=1">${WEB_INSTRUMENT_DETAILS}</a></li><br>
				<li><a href="${pageContext.request.contextPath}/instrumentrule.do?p=1">${WEB_INSTRUMENT_RULES}</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/employ.do">${WEB_EMPLOY_NAVI}</a></li>
    </ul>
    <span id='localtime'></span>
</div>
<!--E navigation-->

</div>
<!--E header-->