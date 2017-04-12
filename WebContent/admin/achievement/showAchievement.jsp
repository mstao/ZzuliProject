<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${type_name}列表-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/list.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/static/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js" type="text/javascript" ></script>
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
						url:CTPPATH+"/deleteachievement.ado",
						data:{"ids":ids},
					
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
								window.location.href="${pageContext.request.contextPath}/showachievement.ado?type=${type}&p=1";
							
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
     <div class="new_div1"><span class="new_div1_span">${type_name}</span><a href="${pageContext.request.contextPath}/admin/achievement/writeAchievement.html?type=${type}" class="add_list">新增</a></div>
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
             <th>标题</th>
             <th>作者</th>
             <th>类别</th>
             <th>发布日期</th>
         </tr>
          <c:forEach items="${achievement}" var="achievement_list">
         <tr>
             <td width="5%" align="center"><input type="checkbox" name="info_id" value="${achievement_list.id}"/></td>
            
             <td width="35%"><a href="${pageContext.request.contextPath}/updateachievement.ado?type=${type}&id=${achievement_list.id}" class="item_title" title="${achievement_list.item_title}">${achievement_list.item_title}</a>
	             <c:if test="${achievement_list.is_publish eq 0}">
	             <span class="draft-span">草稿</span>
	             </c:if>
             </td>
             <td width="30%"><a href="javascript:;">${WEB_FOOTER_COPY}</a></td>
             <td width="20%"><a href="javascript:;">${type_name}</a></td>
             <td width="20%" class="sub-time">${achievement_list.add_time}</td>
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
