<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>撰写内容-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/edit.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/static/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
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
<body  onbeforeunload="return CheckUnsave();">
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>		
<!--E header-->

<!--S main-->
<div class="main">
	<!--S 编辑区域-->
	<div class="edit-div"> 

		<span class="edit-span">撰写${WEB_PERSON_STATUS}
		<c:forEach items="${personintro}" var="personintro_details">
		   <c:if test="${personintro_details.is_publish eq 0}"><b>草稿</b></c:if>
		</c:forEach>
		</span>
		<!-- <input type="text" name="eidt_title" class="edit-title" placeholder="标题"> -->
		<span class="content-span">${WEB_PERSON_STATUS}内容</span>
		
		<!--S 编辑器 -->              
        <div id="editor-container" class="container">
        <div id="editor-trigger"><c:forEach items="${personintro}" var="personintro_info">${personintro_info.content}</c:forEach></div>
        
        </div>
        <c:forEach items="${personintro}" var="personintro_details">
        <input type="hidden" class="hidden-id-perintro" value="${personintro_details.id}">
        </c:forEach>
        <!--E 编辑器  -->
        <div class="edit-submit">
            <input type="hidden" id="hidden-isnull-content" value=""/>
        	<a href="javascript:void(0);" class="draft-btn draft-perintro-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-perintro-btn" onClick="ChangeState();">发布内容</a>
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
			<input type="text" name="publish_dept" class="publish-dept" value="${WEB_PERSON_NAVI}">
		    <span class="publish-dept-span">分类(${WEB_PERSON_STATUS})</span>
		    <select name="publish_style" id="publish-style">
		    
		    	<option value="" >${WEB_EMPLOY_NAVI}</option>
		    	
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
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/wangEditor/dist/js/wangEditor.js"></script>

<script type="text/javascript">

//获得信息
$(function(){
	
	// 阻止输出log
    // wangEditor.config.printLog = false;

    var editor = new wangEditor('editor-trigger');
    editor.config.pasteFilter=true;
    editor.config.pasteText = true;
    // 上传图片
    editor.config.uploadImgUrl = CTPPATH+'/EditorUpload.ado';
    editor.config.uploadParams = {
        // token1: 'abcde',
        // token2: '12345'	
    };
    editor.config.uploadHeaders = {
        // 'Accept' : 'text/x-json'
    }
     editor.config.uploadImgFileName = 'myEditorImgName';

    // 普通的自定义菜单
    editor.config.menus = [
        'source',
        '|',     // '|' 是菜单组的分割线
        'bold',
        'underline',
        'italic',
        'eraser',
        '|',
        'head',
        'quote',
        'unorderlist',
        'orderlist',
        'alignleft',
        'aligncenter',
        'alignright',
        '|',
        'table',
        'link',
        'unlink',
        'img',
        '|',
        'undo',
        'redo',
        'fullscreen'
     ];
      

    
    //创建编辑器
    editor.create();
    
   // editor.$txt.html('');
    //editor.$txt.html();
    //获取编辑的内容(纯文本)
    var c_text = editor.$txt.text();
    //判断内容是否为空，并设置标志位,用于判断 是发布内容 还是修改内容
    if(c_text.replace(/(^s*)|(s*$)/g, "").length !==0){
    	$(".publish-perintro-btn").text("修改内容");
    	$("#hidden-isnull-content").val(0);
    }else{
    	$(".publish-perintro-btn").text("发布内容");
    	$("#hidden-isnull-content").val(1);
    }
   /*  $(".publish-intro-btn").bind("click",function(){
    	alert($("#hidden-isnull-content").val());
    }); */
    
    
    
    /**************添加人才队伍现状 AJAX 发布***************/
	$('.publish-perintro-btn').bind('click',function(){
		
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		
		//获取是发布或者修改标志 1为发布内容  0 为修改内容
		var flag_u_i=$("#hidden-isnull-content").val();

		//获取实验室介绍的id 
		var per_id=$('.hidden-id-perintro').val();
		//alert(intro_id);
		//如果为空，说明其原没有值，置为0
		if(typeof(per_id) == "undefined"){
			per_id=0;
		}
	//	alert(intro_id);
		//判断内容和发布部门是否为空
		if(text_content=="" ||publish_dept==""){
			layer.msg("内容和发布部门不能为空");
		}else{
			
    		var is_publish=1; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatepersonintro.ado',
				data:{'id':per_id,"ui":flag_u_i,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('操作成功', {icon: 1,time:4000});
						window.location.href=CTPPATH+"/personintro.ado";
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
    
	/**************添加人才培养相关 AJAX 存为草稿***************/
	
    $('.draft-perintro-btn').bind('click',function(){
		
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		
		//获取是发布或者修改标志 1为发布内容  0 为修改内容
		var flag_u_i=$("#hidden-isnull-content").val();

		//获取实验室介绍的id 
		var per_id=$('.hidden-id-perintro').val();
		//alert(intro_id);
		//如果为空，说明其原没有值，置为0
		if(typeof(per_id) == "undefined"){
			per_id=0;
		}
	//	alert(intro_id);
		//判断内容和发布部门是否为空
		if(text_content=="" ||publish_dept==""){
			layer.msg("内容和发布部门不能为空");
		}else{
			
    		var is_publish=0; //存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatepersonintro.ado',
				data:{'id':per_id,"ui":flag_u_i,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('操作成功', {icon: 1,time:4000});
						window.location.href=CTPPATH+"/personintro.ado";
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
