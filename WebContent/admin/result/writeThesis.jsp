<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>撰写-${WEB_RESULT_LUNWEN}</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/edit.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<script type="text/javascript">

    var CTPPATH="${pageContext.request.contextPath}";
    
    
	function check(val,obj){
		    obj.style.backgroundColor="#E9E9E6";
			if(val=='f'){
				    $('#f').css("visibility","visible");
				    $('#s').css("visibility",'hidden')
					sb.style.backgroundColor="#F6F6F3";
		    }else if(val=='s'){
		    	    $('#f').css("visibility","hidden");
				    $('#s').css("visibility",'visible')
					fb.style.backgroundColor="#F6F6F3";
		    }
	}
</script>
</head>
<body>
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>		
<!--E header-->

<!--S main-->
<div class="main">
	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span class="edit-span">撰写${WEB_RESULT_LUNWEN}信息</span>
		<span class="title-span">成果类型</span>
		<input type="text"  class="edit-title edit-project-style" placeholder="成果类型">
		<span class="title-span">主要作者</span>
		<input type="text"  class="edit-title edit-project-author" placeholder="主要作者">
        <span class="title-span">论文名称</span>
		<input type="text"  class="edit-title edit-project-name" placeholder="论文名称">		
		<span class="title-span">出版处</span>
		<input type="text"  class="edit-title edit-project-publication_division" placeholder="出版处">
        <span class="title-span">期、卷、页码</span>
		<input type="text"  class="edit-title edit-project-page_number" placeholder="期、卷、页码">
        
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-thesis-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-thesis-btn" onClick="ChangeState();">发布内容</a>
        </div>
	</div>
	<!--E 编辑区域-->
	
	<!--S 附件选择区-->
	<div class="check-zone">
		<div class="check-btn">
			<ul>
				<li ><a href="javascript:void(0);" onclick="check('s',this)" id='sb'>选项</a></li>
				<li ><a href="javascript:void(0);" onclick="check('f',this)" id="fb">附件</a></li>
			</ul>
		</div>
		<!--clear-->
		<div class="clear"></div>
		<!--clear-->
		<div class="options-checked-div" id="s">
			<span class="publish-dept-span">发布部门</span>
			<input type="text" name="publish_dept" class="publish-dept" value="${WEB_FOOTER_COPY}">
		    <span class="publish-dept-span">分类(${WEB_RESULT_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    	<option value="" >${WEB_RESULT_LUNWEN}</option>
		    	
		    </select>
		   
		</div>
		<div class="draft-cheched-div" id="f">
		    <span class="draft-cheched-tag">*此类型不支持附件</span>
		   
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

$(function(){
    var CTPPATH="${pageContext.request.contextPath}";
	
	/**********发布************/
	$(".publish-thesis-btn").bind("click",function(){
		//获取值
		var style=$(".edit-project-style").val();
		var author=$(".edit-project-author").val();
		var name=$(".edit-project-name").val();
		var publication_division=$(".edit-project-publication_division").val();
		var page_number=$(".edit-project-page_number").val();
		var is_publish=1;
		if(name=="" || style == "" || author==""  || publication_division=="" || page_number==""){
			layer.msg("请将信息填写完整再提交！");
		}else{
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/addthesis.ado',
				data:{"style":style,"author":author,"name":name,"publication_division":publication_division,"page_number":page_number,"is_publish":is_publish},
			
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
						layer.msg('发布成功，您可以在列表中查看', {icon: 1,time:2000});

							//跳转界面
							window.location.href=CTPPATH+"/showthesis.ado?p=1";
					

					}else{
						layer.msg("发布出错了", {icon: 2,time:2000});
					}
				},
				error:function(){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg("发布出错了", {icon: 2,time:2000});
				}
			});
		}
		
	});
	
	
	/************保存草稿**********/
	$(".draft-thesis-btn").bind("click",function(){
		//获取值
		var style=$(".edit-project-style").val();
		var author=$(".edit-project-author").val();
		var name=$(".edit-project-name").val();
		var publication_division=$(".edit-project-publication_division").val();
		var page_number=$(".edit-project-page_number").val();
		var is_publish=0;
		if(name=="" || style == "" || author==""  || publication_division=="" || page_number==""){
			layer.msg("请将信息填写完整再提交！");
		}else{
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/addthesis.ado',
				data:{"style":style,"author":author,"name":name,"publication_division":publication_division,"page_number":page_number,"is_publish":is_publish},
			
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
						layer.msg('保存草稿成功，您可以在列表中查看', {icon: 1,time:2000});

							//跳转界面
							window.location.href=CTPPATH+"/showthesis.ado?p=1";
					

					}else{
						layer.msg("保存草稿出错了", {icon: 2,time:2000});
					}
				},
				error:function(){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg("保存草稿出错了", {icon: 2,time:2000});
				}
			});
		}
		
	});
});
</script>