<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${type_name}-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/list.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="${pageContext.request.contextPath}/home/css/tab.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>


</head>
<body>
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>	
<!--E header-->
     
<!--S main-->
 <div class="new_div1"><span class="new_div1_span">${type_name}</span>
 <a href="${pageContext.request.contextPath}/writeintroduce.ado?type=${type}" class="add_list">
 <c:choose>
 	<c:when test="${empty intro}">
 	新增
 	</c:when>
 	<c:otherwise>
 	修改
 	</c:otherwise>
 </c:choose>
 </a>
 <c:forEach items="${intro}" var="intro_info">
 <c:if test="${intro_info.is_publish eq 0}"> <span class="intro-draft">草稿</span></c:if>
 </c:forEach>

 </div>
 
 
<c:choose>
<c:when test="${not empty intro}">
     <br><br>
	 <div class="new_div2  intro-show-div">
		 <c:forEach items="${intro}" var="intro_info">
		 ${intro_info.item_content}
		 </c:forEach>

	 </div>
</c:when>
<c:otherwise>

<center>
<br><br><br><br><br>
<h3>暂时还没有内容，点击新增按钮添加内容</h3>
<br><br><br>
</center>
</c:otherwise>
</c:choose>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" flush="true"/>	
<!--E footer-->
</body>
</html>
