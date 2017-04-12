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
<link href="${pageContext.request.contextPath}/admin/static/uploadify/css/uploadify.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<%
String type_flag=request.getParameter("type");
request.setAttribute("type_flag",type_flag);
%>
<script type="text/javascript">

    var CTPPATH="${pageContext.request.contextPath}";
    var TYPE="${type_flag}";
    
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
	
	//js 获取发表类型的选择值
	$(function(){
		$('#publish-style').change(function(){
		   
		   var cv=$('#publish-style').val();
		   if(cv=='xsx'){
			   	$('.edit-span').text('撰写${WEB_NEWS_NEWS}');
			   	$('.content-span').text('${WEB_NEWS_NEWS}内容');
			 
		   }else if(cv=='xgt'){
		   		$('.edit-span').text('撰写${WEB_NEWS_NOTICE}');
		   	    $('.content-span').text('${WEB_NEWS_NOTICE}内容');
		   		
		   }else if(cv=='xxb'){
		   	    $('.edit-span').text('撰写${WEB_NEWS_JIANG}');
		   	    $('.content-span').text('${WEB_NEWS_JIANG}内容');
		   	    
		   }else if(cv=='xzh'){
		   	    $('.edit-span').text('撰写${WEB_NEWS_YANTAO}');
		   	    $('.content-span').text('${WEB_NEWS_YANTAO}内容');
		   	   
		   }
           //改变类型时清空文件上传列队
		   clean("uploadify");

		});
			
	});
	
	
	$(function() {
		
		
		//根据传过来的类型进行渲染页面
	   if("${type_flag}"=='xsx'){
		   	$('.edit-span').text('撰写${WEB_NEWS_NEWS}');
		   	$('.content-span').text('${WEB_NEWS_NEWS}内容');
		 
	   }else if("${type_flag}"=='xgt'){
	   		$('.edit-span').text('撰写${WEB_NEWS_NOTICE}');
	   	    $('.content-span').text('${WEB_NEWS_NOTICE}内容');
	   		
	   }else if("${type_flag}"=='xxb'){
	   	    $('.edit-span').text('撰写${WEB_NEWS_JIANG}');
	   	    $('.content-span').text('${WEB_NEWS_JIANG}内容');
	   	    
	   }else if("${type_flag}"=='xzh'){
	   	    $('.edit-span').text('撰写${WEB_NEWS_YANTAO}');
	   	    $('.content-span').text('${WEB_NEWS_YANTAO}内容');
	   	   
	   }
		
		//start uplaoding
		$("#uploadify").uploadify({
			debug			: false, 

			swf 			:  CTPPATH+'/admin/static/uploadify/js/uploadify.swf',	//swf文件路径
			method			: 'get',	// 提交方式
			uploader		:  CTPPATH+'/processUpload.ado;jsessionid=${pageContext.session.id}', // 服务器端处理该上传请求的程序(servlet, struts2-Action)
  
			preventCaching	: true,		// 加随机数到URL后,防止缓存

			buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
		//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
			buttonText		: '选择文件'	, //按钮上显示的文字，默认”SELECTFILES”
			height			: 30	, // 30 px
			width			: 120	, // 120 px
			
			fileObjName		: 'filedata',	//文件对象名称, 即属性名
			fileSizeLimit	: 100000	,		// 文件大小限制, 10000 KB
			fileTypeDesc	: 'any'	,	//文件类型说明 any(*.*)
			fileTypeExts	: '*.*;*.txt',		// 允许的文件类型,分号分隔
			//formData		: {'id':'1', 'type':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
		
			auto            : false,    //选择完文件是否自动上传
			multi			: true ,	// 多文件上传
			progressData	: 'speed,percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 99	,	// 队列长度
			removeCompleted : false	,	// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 10	,	//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: true,	// 上传失败后重新加入队列
			uploadLimit		: 10,	// 最多上传文件数量

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
                              
				 layer.msg(file.name + ' 上传失败！ ' ,{icon: 2,time:2000}); 
                               /*  alert(
                                    file.name + ' upload failed! ' + 
                                    'errorCode: ' + errorCode +
                                    'errorMsg:' + errorMsg +
                                    'errorString:' + errorString
                                );*/
							}, 
            
            // 在每一个文件上传成功后触发
            onUploadSuccess : function(file, data, response) {
                              
            	layer.msg(  file.name + ' 上传成功！  ' +
                        '  server-side returned data:' + data +
                        '  response: ' + response,{icon: 1,time:3000});
            	          /* alert(
                                    file.name + ' is uploaded succeed!  ' +
                                    '  server-side returned data:' + data +
                                    '  response: ' + response
                                ); */
                 //文件上传成功后才要跳转页面，要不然会报上传文件中断异常
            	window.location.href=CTPPATH+"/newslist.ado?type="+TYPE+"&p=1";
               }

		});
		
		
	});
	
	//上传文件
	function upload(id){
		$("#" + id).uploadify("settings", "formData",{'item_id':$('.hidden-item-id').val(),'item_type':'fsg'});
	    $("#" + id).uploadify("upload", "*");
	}
	//清空列队
    function clean(id){
    	$("#" + id).uploadify('cancel', '*');
    }
    //获取上传文件总个数
 	function getQueueSize(id){
		return $("#"+id).data('uploadify').queueData.queueLength; 
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
		<span class="edit-span">撰写${WEB_NEWS_NEWS}</span>
		<span class="title-span">标题</span>
		<input type="text" name="eidt_title" class="edit-title" placeholder="标题">
		<span class="content-span">${WEB_NEWS_NEWS}内容</span>
		<!--S 编辑器 -->              
        <div id="editor-container" class="container">
        <div id="editor-trigger"></div>
        </div>
        <%--隐藏新闻公告id  供上传文件用 --%>
        <input type="hidden" name="hidden-item-id" class="hidden-item-id" value="">
        <!--E 编辑器  -->
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-news-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-news-btn" onClick="ChangeState();">发布内容</a>
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
		    <span class="publish-dept-span">分类(${WEB_NEWS_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    	<option value="xsx" <c:if test="${type_flag eq 'xsx'}">selected="true"</c:if> >${WEB_NEWS_NEWS}</option>
		    	<option value="xgt" <c:if test="${type_flag eq 'xgt'}">selected="true"</c:if> >${WEB_NEWS_NOTICE}</option>
		    	<option value="xxb" <c:if test="${type_flag eq 'xxb'}">selected="true"</c:if> >${WEB_NEWS_JIANG}</option>
		    	<option value="xzh" <c:if test="${type_flag eq 'xzh'}">selected="true"</c:if> >${WEB_NEWS_YANTAO}</option>
		    </select>
		   
		</div>
		<div class="draft-cheched-div" id="f">
		    <span class="draft-cheched-tag">*可以选择多个附件,选择完后随发布内容一起提交<br>*内容发布前附件可以撤销<br>*内容发布完后附件不可撤销</span>
		    <span id="uploadify"></span>
			<div id="fileQueue"></div>     
			 <br>
		   <!--  <a href="javascript:upload('uploadify')"  class="start-upload">开始上传</a>&nbsp; -->

	       	<a href="javascript:clean('uploadify')" class="clean-queue">清空列表</a>
	      
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
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/Editor.js"></script>