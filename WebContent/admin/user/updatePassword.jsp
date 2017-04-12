<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>修改管理员密码-后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/admin/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/common.js" type="text/javascript"></script>
</head>
<body onbeforeunload="return CheckUnsave();">
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>	
<!--E header-->
     
<!--S main-->
 <div class="new_div1"><span class="new_div1_span">修改管理员密码</span>

 </div>
 
	 <div class="new_div2  update-userpassword-div">

		<label>管理员用户名</label><br>
		<input type="text" name="username" class="username" value="${sessionScope.username}" disabled="true"/><br>
        <label>输入旧密码 </label><br>
        <input type="password" name="oldpassword" class="oldpassword" placeholder="请输入旧密码"/><br>
        <label>输入新密码 </label><br>
        <input type="password" name="newpassword" class="newpassword" placeholder="输入新密码"/><br>
        <label>重复新密码 </label><br>
        <input type="password" name="repeatpassword" class="repeatpassword" placeholder="重复新密码"/>
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="update-password-btn" onClick="ChangeState();">确认修改</a>
        </div>
       
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
	/************修改密码*****************/
	$('.update-password-btn').bind('click',function(){
		//获取用户名
		var username=$('.username').val();
		//获取原始密码
		var oldpassword=$('.oldpassword').val();
		//获取新密码
		var newpassword=$('.newpassword').val();
		//获取重复输入的密码
		var repeatpassword=$('.repeatpassword').val();
		
		if(oldpassword!="" ||newpassword!="" || repeatpassword!=""){
			if(newpassword!=repeatpassword){
				layer.msg("两次密码输入不一致，请确保两次输入密码一致！");
			}else{
			
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/dealupdatepassword.ado',
				data:{"um":username,"old":oldpassword,"new":newpassword,"repeat":repeatpassword},
				beforeSend:function(){
					//显示正在加载
					layer.load(2);
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					
					if(data==1){
						layer.msg('修改密码成功,下次请用新密码登录', {icon: 1,time:4000});
					}else if(data==2){
						layer.msg("输入的旧密码不正确", {icon: 2,time:2000});
					}else{
						layer.msg("修改密码出错了", {icon: 2,time:2000});
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
		}else{
			layer.msg("旧密码，新密码和重复新密码不能为空！");
		}
	});
	
});


</script>