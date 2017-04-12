<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${WEB_INTRO_XUESHU}列表-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/list.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/static/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		var CTPPATH="${pageContext.request.contextPath}";
		
        //批量删除信息
        $('.deleteInfo-btn').bind('click',function(){
        	var t=document.getElementsByName("info_id");
     		var ids = "";
             for (var i = 0; i < t.length; i++) {
                 if (t[i].checked) {
                 	ids +=t[i].value+',';
                 }
             }
             ids = ids.substring(0, ids.length - 1);
             if(ids==""){
            	 layer.msg("请选择您要删除的选项");
             }else{
            	layer.confirm('确定删除所选择的记录？', {
       			  btn: ['确定','取消'] 
       			}, function(){
       				//已选定，可以进行批量删除操作
       				//调用Ajax向后台发送请求 ，删除所选项
       				
       				$.ajax({
						type:'post',
						dataType:'text',
						url:CTPPATH+"/deletecommittee.ado",
						data:{"ids":ids,"type":"academia"},
					
						beforeSend:function(){
							//显示正在加载
							layer.load(2);
						},
						success:function(data){
		
							//关闭正在加载
							setTimeout(function(){
								  layer.closeAll('loading');
							}, 1000);
							
							if(data>0){
								layer.msg('删除成功', {icon: 1,time:2000});
								window.location.href="${pageContext.request.contextPath}/showcommittee.ado?type=academia&p=1";
							
							}else{
								layer.msg("删除出错了", {icon: 2,time:2000});
							}
						},
						error:function(){
		
							//关闭正在加载
							setTimeout(function(){
								  layer.closeAll('loading');
							}, 1000);
							layer.msg("出错了", {icon: 2,time:2000});
						}
					});
       				
       			   //end
       			}, function(){
       			    //取消操作 ，这里可以为空
       			});
            	
             }
        });
        
        
 });
	  
	</script>
</head>
<body>

<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>			
<!--E header-->
<!--S main-->
<div class="new_div1"><span class="new_div1_span">${WEB_INTRO_XUESHU}</span></div>
<div class="new_div1 committee_intro_span"><span class="new_div1_span">${WEB_INTRO_XUESHU}介绍信息</span><a href="${pageContext.request.contextPath}/updatecommitteeintro.ado?type=xsw&style=academia" class="add_list">
     <c:choose>
	 	<c:when test="${empty committeeintro}">
	 	新增
	 	</c:when>
	 	<c:otherwise>
	 	修改
	 	</c:otherwise>
    </c:choose>
</a>
  <c:forEach items="${committeeintro}" var="committeeintro">
     <c:if test="${committeeintro.is_publish eq 0}"> <span class="intro-draft">草稿</span></c:if>
  </c:forEach>
 
</div>
<!--S 介绍信息  -->     
<c:choose>
<c:when test="${not empty committeeintro}">
     <br><br>
	 <div class="new_div2  intro-show-div">
		 <c:forEach items="${committeeintro}" var="committeeintro">
		 ${committeeintro.content}
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
     
<!--E 介绍信息  -->     
<div class="new_div1"><span class="new_div1_span">${WEB_INTRO_XUESHU}人员列表</span><a href="${pageContext.request.contextPath}/admin/introduce/AddOtherCommittee.html?type=academia" class="add_list">新增</a></div>     
<div class="new_div2">
     	
         <input type="checkbox" class="new_div2_input"/>
         <ul>
             <li>
                 <a href="javascript:void(0);">已选定</a>
                 <ul>
                     <li><a href="javascript:void(0);" class="deleteInfo-btn">删除</a></li>
                 </ul>
             </li>
         </ul>
         <!-- <input type="button" class="new_button" value="筛选"/>
  
  <select name="type" class="new_select">
             <option>选择分类</option>
         </select>
         <input type="text" class="new_text" placeholder="请输入关键字" value="" name="keywords" />    -->
         <div class="clear"></div>
     </div>
 <div class="new_div3">            
     <table>
         <tr>
             <th></th>
             <th>姓名</th>
             <th>性别</th>
             <th>职务</th>
             <th>职称</th>
             <th>所在单位</th>
             <th>发布日期</th>
         </tr>
          <c:forEach items="${committee}" var="committee_list">
         <tr>
             <td width="5%" align="center"><input type="checkbox" name="info_id" value="${committee_list.id}"/></td>
            
             <td width="10%"><a href="${pageContext.request.contextPath}/updatecommittee.ado?type=academia&id=${committee_list.id}" class="item_title" title="${committee_list.name}">${committee_list.name}</a>
	             <c:if test="${committee_list.is_publish eq 0}">
	             <span class="draft-span">草稿</span>
	             </c:if>
             </td>
             <td width="10%"><a href="javascript:;">${committee_list.sex}</a></td>
             <td width="10%"><a href="javascript:;">${committee_list.post}</a></td>
             <td width="15%"><a href="javascript:;">${committee_list.title}</a></td>
             <td width="30%"><a href="javascript:;">${committee_list.unit}</a></td>
             <td width="15%" class="sub-time">${committee_list.add_time}</td>
         </tr>
         </c:forEach>
          
     </table>
     <!--分页工具条  -->
     ${toolbar}
 </div>
 <div></div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" flush="true"/>	
<!--E footer-->
</body>
</html>
