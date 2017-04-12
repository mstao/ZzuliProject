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
<link href="${pageContext.request.contextPath}/admin/static/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/admin/static/uploadify/css/uploadify.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<%-- <%
String type_flag=request.getParameter("type");
request.setAttribute("type_flag",type_flag);
%> --%>
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
	
	
	
	
	$(function() {
		
		
		//start uplaoding
		$("#uploadify").uploadify({
			debug			: false, 

			swf 			:  CTPPATH+'/admin/static/uploadify/js/uploadify.swf',	//swf文件路径
			method			: 'get',	// 提交方式
			uploader		:  CTPPATH+'/insuploadimage.ado;jsessionid=${pageContext.session.id}', // 服务器端处理该上传请求的程序(servlet, struts2-Action)

			preventCaching	: true,		// 加随机数到URL后,防止缓存

			buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
		//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
			buttonText		: '选择图片'	, //按钮上显示的文字，默认”SELECTFILES”
			height			: 30	, // 30 px
			width			: 120	, // 120 px
			
			fileObjName		: 'filedata',	//文件对象名称, 即属性名
			fileSizeLimit	: 5120000	,		// 文件大小限制, 5M
			fileTypeDesc	: '图片类型(.JPG,.GIF,.PNG)'	,	//文件类型说明 any(*.*)
			fileTypeExts	: '*.jpg;*.png;.gif',		// 允许的文件类型,分号分隔
			//formData		: {'id':'1', 'type':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
		
			auto            : true,    //选择完文件是否自动上传
			multi			: false,	// 多文件上传
			progressData	: 'speed,percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 99	,	// 队列长度
			removeCompleted : true	,	// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 5	,	//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: true,	// 上传失败后重新加入队列
			uploadLimit		: 1,	// 最多上传文件数量

			successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
			// 在文件被移除出队列时触发	
			//onCancel : function(file) { alert( 'The file ' + file.name + ' was cancelled!' ); },
			
			// 在调用cancel方法且传入参数’*’时触发
			onClearQueue : function (queueItemCount) {
					if(queueItemCount>0){
					layer.msg(queueItemCount + ' 文件将从上传列队中移除'); 
					}
				},

			// 打开文件对话框 关闭时触发
			onDialogClose : function (queueData) {
							/*	alert(
									"文件对话窗口中选了几个文件:" + queueData.filesSelected + "---" +
									"队列中加了几个文件:" + queueData.filesQueued + "---" +
									"队列中被替换掉的文件数:" + queueData.filesReplaced + "---" +
									"取消掉的文件数:" + queueData.filesCancelled + "---" + 
									"上传出错的文件数:" + queueData.filesErrored
								); */
							},
			
			// 选择文件对话框打开时触发
			onDialogOpen : function () { /*alert( 'please select files' ) */ },
		
			// 没有兼容的FLASH时触发
			onFallback : function(){ alert( '您未安装FLASH控件,无法上传文件!请安装FLASH控件后再试。' ) },
			
			// 每次初始化一个队列时触发, 即浏览文件后, 加入一个队列
			//onInit : function (instance) { alert( 'The queue ID is ' + instance.settings.queueID ) },
		
			// 上传文件处理完成后触发（每一个文件都触发一次）, 无论成功失败
			//onUploadComplete : function(file){ alert( 'The file ' + file.name + ' uploaded finished!' ) },

			// 上传文件失败触发
			onUploadError : function(file, errorCode, errorMsg, errorString){ 
                              
				 layer.msg(file.name + ' 上传失败！ ' + 
                        'errorCode: ' + errorCode +
                        'errorMsg:' + errorMsg +
                        'errorString:' + errorString,{icon: 2,time:2000}); 
                                /*  alert(
                                    file.name + ' upload failed! ' + 
                                    'errorCode: ' + errorCode +
                                    'errorMsg:' + errorMsg +
                                    'errorString:' + errorString
                                ); */
							}, 
            
            // 在每一个文件上传成功后触发
            onUploadSuccess : function(file, data, response) {
                              
            	layer.msg(  file.name + ' 上传成功！  ' +
                        '  --server-side returned data:' + data +
                        '  --response: ' + response,{icon: 1,time:5000});
            	//将 图片信息写到图片展示 
                $('.instrument-image').attr("src",data);
            	//将图片路径写入隐藏域，后面还用
            	$('.hidden-item-image').val(data);
            }

		});
		
		
	});
	
	//上传文件
	function upload(id){
		$("#" + id).uploadify("settings", "formData",{});
	    $("#" + id).uploadify("upload", "*");
	}
	//清空列队
    function clean(id){
    	$("#" + id).uploadify('cancel', '*');
    }
	
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
		<span class="edit-span">修改${WEB_INSTRUMENT_DETAILS}信息
		<c:forEach items="${ins_details}" var="ins_details">
		   <c:if test="${ins_details.is_publish eq 0}"><b>草稿</b></c:if>
		</c:forEach>
		</span>
		<span class="title-span">仪器设备名称</span>
		<input type="text" name="eidt_title" class="edit-title edit-ins-name" placeholder="仪器设备名称">
		<span class="title-span">仪器设备平台链接(需要带http:// 或者 https://)</span>
		<input type="text" name="eidt_url" class="edit-title edit-ins-url" placeholder="仪器设备平台链接(需要带http:// 或者 https://)">
		<span class="content-span">${WEB_INSTRUMENT_DETAILS}图片(图片只允许上传一张)</span><br>
		<!--图片上传和展示信息  -->
		<div class="instrument-image-div">
		<span id="uploadify"></span>
		<div id="fileQueue"></div> 
		 <img alt="" src="" class="instrument-image"> 
		</div>
		<span class="instrument-edit-span">${WEB_INSTRUMENT_DETAILS}详细信息</span>
		<!--S 编辑器 -->              
        <div id="editor-container" class="container">
        <div id="editor-trigger"><c:forEach items="${ins_details}" var="ins_details">${ins_details.instrument_info}</c:forEach></div>
        
        </div>
        
        <%--隐藏图片名称  供发布仪器设备信息使用 --%>
        <input type="hidden" name="hidden-item-image" class="hidden-item-image" value="">
        <%--隐藏 id 供修改时使用 --%>
        <input type="hidden" name="hidden-item-id" class="hidden-item-id" value="${id}"/>
        <!--E 编辑器  -->
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-instrument-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-instrument-btn" onClick="ChangeState();">发布内容</a>
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
		    <span class="publish-dept-span">分类(${WEB_INSTRUMENT_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    	<option value="" >${WEB_INSTRUMENT_DETAILS}</option>
		    	
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
    //初始化标题
   
    //editor.$txt.html();
     
    /****************初始化信息*****************/
    
    //初始化仪器名称
    $('.edit-ins-name').val('<c:forEach items="${ins_details}" var="ins_details">${ins_details.instrument_name}</c:forEach>');
    //初始化平台外链
    $('.edit-ins-url').val('<c:forEach items="${ins_details}" var="ins_details">${ins_details.instrument_url}</c:forEach>');
    //初始化仪器图片信息
    $('.instrument-image').attr('src','<c:forEach items="${ins_details}" var="ins_details">${ins_details.instrument_image}</c:forEach>');
    $('.hidden-item-image').val('<c:forEach items="${ins_details}" var="ins_details">${ins_details.instrument_image}</c:forEach>');
    //初始化详细信息
    
    
    /**************修改 仪器设备 信息  AJAX 发布***************/
	$('.publish-instrument-btn').bind('click',function(){
	    
		//获取隐藏的id
		var ins_id=$('.hidden-item-id').val();
		//获取选择完后图片信息
		var img_url=$('.hidden-item-image').val();

		//获取仪器名称
		var name=$('.edit-ins-name').val();
		//获取仪器设备外链
		var ins_url=$('.edit-ins-url').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断是否上传了图片
		if(img_url == ""){
			layer.msg("请先点击上传图片按钮上传仪器图片！");
		}else{
			//判断标题和内容是否为空
    		if(name=="" || text_content=="" ||publish_dept==""){
    			layer.msg("标题,内容和发布部门不能为空");
    		}else{
    			
        		var is_publish=1; //意味着要发表1，不是存为草稿0
    			$.ajax({
    				type:'post',
    				dataType:'text',
    				url:CTPPATH+'/dealupdateinstrument.ado',
    				data:{"id":ins_id,"name":name,"content":content,"ins_url":ins_url,"img_url":img_url,"author":publish_dept,"is_publish":is_publish},
    				
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
    						layer.msg('修改成功，您可以在列表中查看', {icon: 1,time:2000});
							window.location.href=CTPPATH+"/showinstrument.ado?p=1";
    					}else{
    						layer.msg("发布出错了", {icon: 2,time:2000});
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
			
	    }
 });
    
	 /**************修改仪器设备  AJAX 保存为草稿***************/
	
   $('.draft-instrument-btn').bind('click',function(){
	    
		//获取隐藏的id
		var ins_id=$('.hidden-item-id').val();
		//获取选择完后图片信息
		var img_url=$('.hidden-item-image').val();

		//获取仪器名称
		var name=$('.edit-ins-name').val();
		//获取仪器设备外链
		var ins_url=$('.edit-ins-url').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断是否上传了图片
		if(img_url == ""){
			layer.msg("请先点击上传图片按钮上传仪器图片！");
		}else{
			//判断标题和内容是否为空
    		if(name=="" || text_content=="" ||publish_dept==""){
    			layer.msg("标题,内容和发布部门不能为空");
    		}else{
    			
        		var is_publish=0; //存为草稿0
    			$.ajax({
    				type:'post',
    				dataType:'text',
    				url:CTPPATH+'/dealupdateinstrument.ado',
    				data:{"id":ins_id,"name":name,"content":content,"ins_url":ins_url,"img_url":img_url,"author":publish_dept,"is_publish":is_publish},
    				
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
    						layer.msg('修改成功，您可以在列表中查看', {icon: 1,time:2000});
							window.location.href=CTPPATH+"/showinstrument.ado?p=1";
    					}else{
    						layer.msg("发布出错了", {icon: 2,time:2000});
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
			
	    }
   });
    
    
});

</script>