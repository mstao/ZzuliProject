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
<script src="${pageContext.request.contextPath}/admin/static/uploadify/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
<%
String type_flag=request.getParameter("type");
request.setAttribute("type_flag",type_flag);
%>
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

	$(function(){
		
		
		$('#publish-style').change(function(){
			   
			   var cv=$('#publish-style').val();
			   if(cv=='kfl'){
				   $(".edit-span").text("撰写${WEB_RESULT_LUNWEN}");
					$(".content-span").text("${WEB_RESULT_LUNWEN}内容");
				 
			   }else if(cv=='kfz'){
				   $(".edit-span").text("撰写${WEB_RESULT_ZHUANLI}");
					$(".content-span").text("${WEB_RESULT_ZHUANLI}内容");
			   		
			   }else if(cv=="")


			});
		
		//根据url传的类型渲染页面
		if("${type_flag}"=="kfl"){
			$(".edit-span").text("撰写${WEB_RESULT_LUNWEN}");
			$(".content-span").text("${WEB_RESULT_LUNWEN}内容");
		}else if("${type_flag}"=="kfz"){
			$(".edit-span").text("撰写${WEB_RESULT_ZHUANLI}");
			$(".content-span").text("${WEB_RESULT_ZHUANLI}内容");
		}
		
	});
	
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

		<span class="edit-span">撰写XX</span>
		<!-- <input type="text" name="eidt_title" class="edit-title" placeholder="标题"> -->
		<span class="content-span">XX内容</span>
		<!--S 编辑器 -->                
        <textarea rows="100" cols="50" class="edit-title-textarea" ></textarea>
        <!--E 编辑器  -->
        <div class="edit-submit">
            <input type="hidden" id="hidden-isnull-content" value=""/>
        	<a href="javascript:void(0);" class="draft-btn draft-actext-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-actext-btn" onClick="ChangeState();">发布内容</a>
        </div>
	</div>
	<!--E 编辑区域-->
	
	<!--S 附件选择区-->
	<div class="check-zone ">
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
		    
		    	<option value="kfl" <c:if test="${type_flag eq 'kfl'}">selected="true"</c:if> >${WEB_RESULT_LUNWEN}</option>
		    	<option value="kfz" <c:if test="${type_flag eq 'kfz'}">selected="true"</c:if> >${WEB_RESULT_ZHUANLI}</option>
		    	
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
	
  
    /**************发布  科研成果 --论文etc***************/
	$('.publish-actext-btn').bind('click',function(){
		
        //获取类型
        var ac_type=$("#publish-style").val();
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
				url:CTPPATH+'/addaclun.ado',
				data:{'type':ac_type,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('操作成功', {icon: 1,time:2000});
                        window.location.href=CTPPATH+"/showachievement.ado?type=${type_flag}&p=1";
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
    
	/**************发布 科研成果 -论文etc 存为草稿***************/
	
$('.draft-actext-btn').bind('click',function(){
		
        //获取类型
        var ac_type=$("#publish-style").val();
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
				url:CTPPATH+'/addaclun.ado',
				data:{'type':ac_type,"content":content,"author":publish_dept,"is_publish":is_publish},
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
						window.location.href=CTPPATH+"/showachievement.ado?type=${type_flag}&p=1";
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
