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
	$(function(){
		//根据传过来的类型进行渲染页面
		   if("${type}"=='manage'){
			   	$('.edit-span').text('修改${WEB_INTRO_GUANLI}人员信息');			 
		   }else if("${type}"=='academia'){
		   		$('.edit-span').text('修改${WEB_INTRO_XUESHU}人员信息');		   		
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
		<span class="edit-span">修改${WEB_INTRO_SHIYAN}人员信息</span><br><br>
		<label>姓名：</label>
		<input type="text"  class="edit-committee-input edit-com-name" placeholder="姓名">
		<br>
		<%--隐藏id --%>
		<c:forEach items="${committee}" var="committee_list">
		<input type="hidden" class="hidden-id" value="${committee_list.id}"/>
		</c:forEach>
		<label>出生年月：</label>
		<input type="text" class="edit-committee-input edit-com-birthday" placeholder="出生年月(yyyy-mm)">
		<br>
		<div class="sex_div">性别：
		<c:forEach items="${committee}" var="committee_list">
		<c:choose>
		<c:when test="${committee_list.sex == '男'}">
		
		<input type="radio" name="sex" value="male" id="male" checked><label for="male">男</label>&nbsp;
		<input type="radio" name="sex" value="female" id="female"><label for="female">女</label>
		</c:when>
		<c:otherwise>
		<input type="radio" name="sex" value="male" id="male"><label for="male">男</label>&nbsp;
		<input type="radio" name="sex" value="female" id="female" checked><label for="female">女</label>
		</c:otherwise>
		</c:choose> 
		</c:forEach>
        </div>
		<br>
		<label>职务：</label>
		<select name="publish_style" id="post-check">
		<c:forEach items="${committee}" var="committee_list">
		    	<option value="director"  <c:if test="${committee_list.post eq '主任'}">selected="true"</c:if> >主 任</option>
		    	<option value="vice-director" <c:if test="${committee_list.post eq '副主任'}">selected="true"</c:if> >副主任</option>
		    	<option value="commission" <c:if test="${committee_list.post eq '委员'}">selected="true"</c:if> >委 员</option>
		    	<option value="mishu" <c:if test="${committee_list.post eq '秘书'}">selected="true"</c:if> >秘 书</option>   
		 </c:forEach>	
		 </select><br>
		<br>
		<label>职称：</label>
		<input type="text" class="edit-committee-input edit-com-title" placeholder="职称">
		<br>
		<label>研究方向：</label>
		<input type="text"  class="edit-committee-input edit-com-research" placeholder="研究方向">
		<br>
		<label>所在单位：</label>
		<input type="text" class="edit-committee-input edit-com-unit" placeholder="所在单位">
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-committee-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-committee-btn" onClick="ChangeState();">发布内容</a>
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
		    <span class="publish-dept-span">分类(${WEB_INTRO_NAVI})</span>
		    <select name="publish_style" id="publish-style">
		    <c:choose>
		       <c:when test="${type eq 'manage'}">
		       <option value="manage" selected="true" >${WEB_INTRO_GUANLI}</option>
		       </c:when>
		       <c:when test="${type eq 'academia'}">
		       <option value="academia" selected="true">${WEB_INTRO_XUESHU}</option>
		       </c:when>
		    </c:choose>
		    	
		    	
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

//获得信息
$(function(){
	
	//初始化信息
	//初始化姓名
	$('.edit-com-name').val('<c:forEach items="${committee}" var="committee_list">${committee_list.name}</c:forEach>');
	//初始化出生年月
	$('.edit-com-birthday').val('<c:forEach items="${committee}" var="committee_list">${committee_list.birthday}</c:forEach>');
	//初始化职称
	$('.edit-com-title').val('<c:forEach items="${committee}" var="committee_list">${committee_list.title}</c:forEach>');
	//初始化研究方向
	$('.edit-com-research').val('<c:forEach items="${committee}" var="committee_list">${committee_list.research}</c:forEach>');
	//初始化所在单位
	$('.edit-com-unit').val('<c:forEach items="${committee}" var="committee_list">${committee_list.unit}</c:forEach>');
      
    /**************修改 信息  AJAX 发布***************/
	$('.publish-committee-btn').bind('click',function(){
		//获取id
		var id=$('.hidden-id').val();
		//获取姓名
		var name=$('.edit-com-name').val();
		//获取出生年月
		var birthday=$('.edit-com-birthday').val();
		//获取性别
		var sex=$("input[name='sex']:checked").next("label").text();  
		//获取职务
		var post=$('#post-check').val();
		//获取职称
		var title=$('.edit-com-title').val();
		//获取研究方向
		var research=$('.edit-com-research').val();
		//获取所在单位
		var unit=$('.edit-com-unit').val();
		
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		
		if(name=="" || birthday=="" || post=="" || title=="" || research=="" || unit==""  || publish_dept==""){
			layer.msg("信息填写不完整,请将信息填写完整再提交！");			
		}else{
			var is_publish=1; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatecommittee.ado',
				data:{"id":id,"type":"${type}","name":name,"birthday":birthday,"sex":sex,"post":post,"title":title,"research":research,"unit":unit,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('修改成功', {icon: 1,time:2000});
                        window.location.href=CTPPATH+"/showcommittee.ado?type=${type}&p=1";
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
    /*********添加信息  存为草稿***********/
	$('.draft-committee-btn').bind('click',function(){
		//获取id
		var id=$('.hidden-id').val();
		//获取姓名
		var name=$('.edit-com-name').val();
		//获取出生年月
		var birthday=$('.edit-com-birthday').val();
		//获取性别
		var sex=$("input[name='sex']:checked").next("label").text();  
		//获取职务
		var post=$('#post-check').val();
		//获取职称
		var title=$('.edit-com-title').val();
		//获取研究方向
		var research=$('.edit-com-research').val();
		//获取所在单位
		var unit=$('.edit-com-unit').val();
		
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		
		if(name=="" || birthday=="" || post=="" || title=="" || research=="" || unit==""  || publish_dept==""){
			layer.msg("信息填写不完整,请将信息填写完整再提交！");			
		}else{
			var is_publish=0; //存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatecommittee.ado',
				data:{"id":id,"type":"${type}","name":name,"birthday":birthday,"sex":sex,"post":post,"title":title,"research":research,"unit":unit,"author":publish_dept,"is_publish":is_publish},
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
						layer.msg('保存草稿成功', {icon: 1,time:2000});
                        window.location.href=CTPPATH+"/showcommittee.ado?type=${type}&p=1";
					}else{
						layer.msg("保存草稿出错了", {icon: 2,time:2000});
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