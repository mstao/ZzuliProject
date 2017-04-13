<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
$(function(){
	//退出系统处理
	$('.loginout').bind('click',function(){
		layer.confirm('是否退出后台管理？', {
			  btn: ['退出','取消'] 
			}, function(){
				window.location.href="${pageContext.request.contextPath}/admin.ado";
			}, function(){
			  
			});
	});
});
//-->
</script>
<%--S 后台公共导航--%>
<div class="header">

			<div class="page-menu-wrapper clearfix" >
				<ul class="menu-function">
					<li>
						<a href="${pageContext.request.contextPath}/aindex.ado" title="" class="home" >后台管理</a>                                       
					</li>
				</ul>
				<ul class="menu-share">
                 <li><a href="javascript:void(0);">撰写</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/news/writeNews.html?type=xsx" >${WEB_NEWS_NEWS}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/news/writeNews.html?type=xgt" >${WEB_NEWS_NOTICE}</a></li>		
							<li><a href="${pageContext.request.contextPath}/admin/rules/writeRules.html" >${WEB_INTRO_RULES}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/research/writeResearch.html?type=kzx" >${WEB_RESEARCH_NAVI}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/achievement/writeAchievement.html" >${WEB_RESULT_ZHUANHUA}</a></li>
					</ul>
                 </li>
                 
                 <li><a href="javascript:void(0);">${WEB_INTRO_NAVI}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/showintroduce.ado?type=isg" >${WEB_INTRO_GAIKUANG}</a></li>
							<li><a href="${pageContext.request.contextPath}/showintroduce.ado?type=izj" >${WEB_INTRO_ZUZHI}</a></li>
							<li><a href="${pageContext.request.contextPath}/showcommittee.ado?type=manage&p=1" >${WEB_INTRO_GUANLI}</a></li>
							<li><a href="${pageContext.request.contextPath}/showcommittee.ado?type=academia&p=1" >${WEB_INTRO_XUESHU}</a></li>	
							<li><a href="${pageContext.request.contextPath}/showcommittee.ado?type=director&p=1" >${WEB_INTRO_SHIYAN}</a></li>
							<li><a href="${pageContext.request.contextPath}/showintroduce.ado?type=isl" >${WEB_INTRO_LOGO}</a></li>	
							<li><a href="${pageContext.request.contextPath}/showintroduce.ado?type=isd" >${WEB_INTRO_THING}</a></li>
							<li><a href="${pageContext.request.contextPath}/ruleslist.ado?p=1" >${WEB_INTRO_RULES}</a></li>
					</ul>
                 	
                 </li>
                 
                 <li><a href="javascript:void(0);">${WEB_NEWS_NAVI}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/newslist.ado?type=xsx&p=1">${WEB_NEWS_NEWS}</a></li>
							<li><a href="${pageContext.request.contextPath}/newslist.ado?type=xgt&p=1">${WEB_NEWS_NOTICE}</a></li>
							<li><a href="${pageContext.request.contextPath}/newslist.ado?type=xxb&p=1">${WEB_NEWS_JIANG}</a></li>
							<li><a href="${pageContext.request.contextPath}/newslist.ado?type=xzh&p=1">${WEB_NEWS_YANTAO}</a></li>
					</ul>
                 </li>
                 
                 <li><a href="javascript:void(0);">${WEB_RESEARCH_NAVI}</a>
                 	  <ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/researchlist.ado?type=kpj&p=1">${WEB_RESEARCH_PINGTAI}</a></li>
							<li><a href="${pageContext.request.contextPath}/researchlist.ado?type=kyl&p=1">${WEB_RESEARCH_LIANGDIAN}</a></li>
							<li><a href="${pageContext.request.contextPath}/showfoundation.ado?p=1" >${WEB_RESEARCH_PROJECT_FOUNDATION}</a></li>
							<li><a href="${pageContext.request.contextPath}/showprovincial.ado?p=1" >${WEB_RESEARCH_PROJECT_PROVINCIAL}</a></li>
							<li><a href="${pageContext.request.contextPath}/showcooperation.ado?p=1" >${WEB_RESEARCH_PROJECT_HORIZONTAL_COOPERATION}</a></li>
					</ul>
                 </li>
                 
                 <li><a href="javascript:void(0);">${WEB_PERSON_NAVI}</a>
                 	 <ul class="dropdown-menu follow">
							
							<li><a href="${pageContext.request.contextPath}/showperson.ado?p=1" >${WEB_PERSON_GUGAN}</a></li>
							
					</ul>
                 	
                 </li>
                 
                 <li><a href="javascript:void(0);">${WEB_STUDENT_NAVI}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/showstudent.ado?type=xbp">${WEB_STUDENT_BEN}</a></li>
							<li><a href="${pageContext.request.contextPath}/showstudent.ado?type=xyp">${WEB_STUDENT_YAN}</a></li>
							<li><a href="${pageContext.request.contextPath}/showstudent.ado?type=xxp">${WEB_STUDENT_RESULT}</a></li>	
					</ul>
                 </li>
                 
                 
                 <li><a href="javascript:void(0);">${WEB_RESULT_NAVI}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/showrewards.ado?p=1" >${WEB_RESULT_REWRADS}</a></li>
						    <li><a href="${pageContext.request.contextPath}/showpatent.ado?p=1" >${WEB_RESULT_ZHUANLI}</a></li>
							<li><a href="${pageContext.request.contextPath}/showidentification.ado?p=1" >${WEB_RESULT_JIANDING}</a></li>
							<li><a href="${pageContext.request.contextPath}/showthesis.ado?p=1" >${WEB_RESULT_LUNWEN}</a></li>
					</ul>
                 </li>
                 <li><a href="javascript:void(0);">${WEB_INSTRUMENT_NAVI}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/showinstrument.ado?p=1" >${WEB_INSTRUMENT_DETAILS}</a></li>
							<li><a href="${pageContext.request.contextPath}/showinstrumentrule.ado?p=1" >${WEB_INSTRUMENT_RULES}</a></li>
					</ul>
                 </li>
                 <li><a href="${pageContext.request.contextPath}/showemploy.ado">${WEB_EMPLOY_NAVI}</a>
                 	
                 </li>
				  <li><a href="javascript:void(0);" title="" >文档联系</a>
						<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/showdocument.ado?p=1" >文档列表</a></li>						
							<li><a href="${pageContext.request.contextPath}/showcontact.ado" >联系我们</a></li>		
						</ul>
					</li>
					
				</ul>	
				
				<ul class="menu-function user">
					<li>
						<a href="${pageContext.request.contextPath}/admin/user/updatePassword.html" title="" class="home" >管理员 ${sessionScope.username}</a>                                       
					</li>
					<li>
						<a href="javascript:void(0);" title="" class="home loginout" onClick="ChangeState();">退出</a>                                       
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/index.do" title="" class="home"  target="_blank">网站</a>                                       
					</li>
				</ul>
			</div>
	
</div>
<%--E 后台公共导航--%>