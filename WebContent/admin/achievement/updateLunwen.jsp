<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>修改内容-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/edit.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<script type="text/javascript">

    var CTPPATH="${pageContext.request.contextPath}";

	
	//刷新恢复下拉框的默认值
	function resetSelect(){
		var s=document.getElementById('publish-style');
		var os=s.options;
		for(var i=0;os.length;i++){
			if(os[i].selected!=os[i].defaultSelected){
				os[i].selected=os[i].defaultSelected;
			}
		}
	}
	window.onload=resetSelect;
	
	
</script>
   
</head>
<body onbeforeunload="return CheckUnsave();">
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>		
<!--E header-->

<!--S main-->
<div class="main">
	<!--S 编辑区域-->
	<div class="edit-div"> 

		<span class="edit-span">修改${type_name}
		<c:forEach items="${intro}" var="intro_details">
		   <c:if test="${intro_details.is_publish eq 0}"><b>草稿</b></c:if>
		</c:forEach>
		</span>
		<!-- <input type="text" name="eidt_title" class="edit-title" placeholder="标题"> -->
		<span class="content-span">${type_name}内容</span>

        <input type="hidden" class="hidden-id-ac" value="${id}">
		<!--S 编辑器 -->                
        <textarea rows="100" cols="50" class="edit-title-textarea" ><c:forEach items="${ac_details}" var="ac_details">${ac_details.item_content}</c:forEach></textarea>
        <!--E 编辑器  -->
        <div class="edit-submit">
            <input type="hidden" id="hidden-isnull-content" value=""/>
        	<a href="javascript:void(0);" class="draft-btn draft-actext-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-actext-btn" onClick="ChangeState();">发布内容</a>
        </div>
	</div>
	<!--E 编辑区域-->
	
	<!--S 附件选择区-->
	<div class="check-zone ">
		<div class="only-check-btn">
			<ul>
				<li ><a href="javascript:void(0);"  id='sb' >选项</a></li>
				
			</ul>
		</div>
		<!--clear-->
		<div class="clear"></div>
		<!--clear-->
		<div class="options-checked-div" id="s">
			<span class="publish-dept-span">发布部门</span>
			<input type="text" name="publish_dept" class="publish-dept" value="${WEB_FOOTER_COPY}">
		    <span class="publish-dept-span">分类(${WEB_INTRO_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    
		    	<option value="${type}" >${type_name}</option>
		    	
		    </select>
		    
		</div>
		
	</div>
	<!--E 附件选择区-->
	
	<!--clear-->
	<div class="clear"></div>
	<!--clear-->
</div>
<!--E main-->
<!--S footer-->
<jsp:include page="../common/footer.jsp" flush="true"/>	
<!--E footer-->
</body>
</html>

<script type="text/javascript">

//获得信息
$(function(){
	
    //初始化内容
    //$('.edit-title-textarea').val('<c:forEach items="${ac_details}" var="ac_details">${ac_details.item_content}</c:forEach>');
  
    /**************修改  科研成果 --论文etc***************/
	$('.publish-actext-btn').bind('click',function(){
		
        //获取隐藏id
        var ac_id=$('.hidden-id-ac').val();
		//获取内容
		var content=$('.edit-title-textarea').val();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
	  //	alert(intro_id);
		//判断内容和发布部门是否为空
		if(content=="" || publish_dept==""){
			layer.msg("内容和发布部门不能为空");
		}else{
			
    		var is_publish=1; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdateaclun.ado',
				data:{'id':ac_id,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('操作成功'+data, {icon: 1,time:2000});
						window.location.href=CTPPATH+"/showachievement.ado?type=${type}&p=1";
					}else{
						layer.msg("操作出错了", {icon: 2,time:2000});
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
		}
	  });
    
	/**************修改 科研成果 -论文etc 存为草稿***************/
	
$('.draft-actext-btn').bind('click',function(){
		
        //获取隐藏id
        var ac_id=$('.hidden-id-ac').val();
		//获取内容
		var content=$('.edit-title-textarea').val();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
	  //	alert(intro_id);
		//判断内容和发布部门是否为空
		if(content=="" || publish_dept==""){
			layer.msg("内容和发布部门不能为空");
		}else{
			
    		var is_publish=0; //存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdateaclun.ado',
				data:{'id':ac_id,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('操作成功'+data, {icon: 1,time:2000});
						window.location.href=CTPPATH+"/showachievement.ado?type=${type}&p=1";
					}else{
						layer.msg("操作出错了", {icon: 2,time:2000});
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
		}
	  });
	
	
});
 


</script>
