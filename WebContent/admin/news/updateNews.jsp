<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>修改内容-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/edit.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/date.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/admin/static/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/admin/static/uploadify/css/uploadify.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/admin/js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.date_input.pack.js" type="text/javascript"></script>

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
                              
				 layer.msg(file.name + ' 上传失败！ ' );
                        
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
            	window.location.href=CTPPATH+"/newslist.ado?type=${type}&p=1";
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
		<span class="edit-span">修改${type_name} 
		<c:forEach items="${news_details}" var="news_details">
		   <c:if test="${news_details.is_publish eq 0}"><b>草稿</b></c:if>
		</c:forEach>
		</span>
		<span class="title-span">标题</span>
		<input type="text" name="eidt_title" class="edit-title" placeholder="标题">
		<span class="content-span">${type_name}内容</span>
		<!--S 编辑器 -->              
        <div id="editor-container" class="container">
        <div id="editor-trigger"><c:forEach items="${news_details}" var="news_details">${news_details.item_content}</c:forEach></div>
        </div>
        <%--隐藏新闻公告id  供上传文件用 --%>

        <input type="hidden" name="hidden-item-id" class="hidden-item-id" value="${nid}">

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
		    <span class="publish-dept-span">发布时间</span>
		    <div id="date-div">
		   
		    <input type="text"  class="date_picker" value="">
		    </div>
		    <span class="publish-dept-span">分类(${WEB_NEWS_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    	<option value="${type}"selected="true">${type_name}</option>
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

<script type="text/javascript">
$('.date_picker').date_input();
//时间     - 年月日
function showLocale(){
	var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    
    var hh = date.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = date.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = date.getSeconds();
	if(ss<10) ss = '0' + ss;
	
	
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    
    return currentdate;
}

//时间  -时分秒
function hms(){
	var date = new Date();
	var hh = date.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = date.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = date.getSeconds();
	if(ss<10) ss = '0' + ss;
	
	var hms=hh+":"+mm+":"+ss;
	return hms;
}

</script>

<script type="text/javascript">

//获得信息
$(function(){
	
	//截取一下时间
	var add_time = "<c:forEach items='${news_details}' var='news_details'>${news_details.add_time}</c:forEach>";
	add_time = add_time.substr(0,10);
	 $('.date_picker').val(add_time);
	 
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
    $('.edit-title').val('<c:forEach items="${news_details}" var="news_details">${news_details.item_title}</c:forEach>');
    //初始化内容
  
    //editor.$txt.html();
    //获取编辑的内容(纯文本)
    var c_text = editor.$txt.text();
  
    
    /**************修改新闻公告 AJAX 发布***************/
	$('.publish-news-btn').bind('click',function(){
		//获取id
		var nid=$('.hidden-item-id').val();
		//获取发表类型
		var type=$('#publish-style').val();
		//获取标题
		var title=$('.edit-title').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val();
		date_picker=date_picker+" "+hms();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断标题和内容是否为空
		if(title=="" || text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
			var is_publish=1; //意味着要发表1，不是存为草稿0
			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
    		var is_image;
    		var img_path="";
    		var s_json;
    		if(editor.$txt.find("img[src!='']").length>0){
    			is_image=1;
    			img_path=editor.$txt.find("img[src!='']:first").attr("src");
    			
    		}else{
    			is_image=0;
    			img_path="0";
    			
    		}
    		s_json={"id":nid,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"image_path":img_path,"add_time":date_picker};
    		
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatenews.ado',
				data:s_json,
			
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
						$('.hidden-item-id').val(data);
						//判断有无上传文件列队
						if(getQueueSize("uploadify")>0){
							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
							upload("uploadify");
						}else{
							//跳转界面
							window.location.href=CTPPATH+"/newslist.ado?type=${type}&p=1";
						}

					}else{
						layer.msg("修改出错了", {icon: 2,time:2000});
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
    
	 /**************修改新闻公告 AJAX 保存为草稿***************/
	$('.draft-news-btn').bind('click',function(){
		//获取id
		var nid=$('.hidden-item-id').val();

		//获取标题
		var title=$('.edit-title').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val();
		date_picker=date_picker+" "+hms();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断标题和内容是否为空
		if(title=="" || text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
			var is_publish=0; //意味着要发表1，不是存为草稿0
			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
    		var is_image;
    		var img_path="";
    		var s_json;
    		if(editor.$txt.find("img[src!='']").length>0){
    			is_image=1;
    			img_path=editor.$txt.find("img[src!='']:first").attr("src");
    			
    		}else{
    			is_image=0;
    			img_path="0";
    			
    		}
    		s_json={"id":nid,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"image_path":img_path,"add_time":date_picker};
    		
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatenews.ado',
				data:s_json,
			
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
						$('.hidden-item-id').val(data);
						if(getQueueSize("uploadify")>0){
							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
							upload("uploadify");
						}else{
							//跳转界面
							window.location.href=CTPPATH+"/newslist.ado?type=${type}&p=1";
						}
						
					}else{
						layer.msg("修改出错了", {icon: 2,time:2000});
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
