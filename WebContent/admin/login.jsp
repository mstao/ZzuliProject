<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录-后台管理</title>
<style type="text/css">
*{margin:0;padding:0;}
body{font:14px/1.5 '微软雅黑';background:#f9f9f9;}
a{color:#00007F;text-decoration:none;}
a:hover{color:#bd0a01;text-decoration:underline;}
.admin_login_wrap{margin:140px auto 0;width:312px;}
.admin_login_wrap h1{font-family:'微软雅黑';font-weight: normal;font-size:20px;margin-bottom:15px;}
.adming_login_border{box-shadow:1px 2px 3px #ccc;border:1px solid #eee;background:#fff;padding:0 5px 15px;overflow:hidden;}
.admin_input{margin:15px auto 0;width:280px;}
.admin_items li{line-height:28px;margin-bottom: 5px;list-style:none;clear: both;}
.admin_input label{display:block;margin-bottom:5px;}
.admin_input_style{width:272px;border:1px solid #e6e6e6;background:#fff;padding:3px;height:30px;line-height:30px;font-family:Arial;color:#666;border-radius:5px;transition-duration:0.3s;}
.admin_input_style:focus{border-color: rgba(82, 168, 236, 0.8);box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6);background:#f8f8f8;}
.btn{display:inline-block;*display:inline;padding:12px 12px;margin-bottom:0;*margin-left:.3em;font-size:14px;line-height:20px;color:#333;text-align:center;text-shadow:0 1px 1px rgba(255,255,255,0.75);vertical-align:middle;cursor:pointer;background-color:#f5f5f5;*background-color:#e6e6e6;background-image:-moz-linear-gradient(top,#ffffff,#e6e6e6);background-image:-webkit-gradient(linear,0 0,0 100%,from(#ffffff),to(#e6e6e6));background-image:-webkit-linear-gradient(top,#ffffff,#e6e6e6);background-image:-o-linear-gradient(top,#ffffff,#e6e6e6);background-image:linear-gradient(to bottom,#ffffff,#e6e6e6);background-repeat:repeat-x;border:1px solid #bbbbbb;*border:0;border-color:#e6e6e6 #e6e6e6 #bfbfbf;border-color:rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);border-bottom-color:#a2a2a2;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',endColorstr='#ffe6e6e6',GradientType=0);filter:progid:DXImageTransform.Microsoft.gradient(enabled=false);*zoom:1;-webkit-box-shadow:inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);-moz-box-shadow:inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);box-shadow:inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);}
.btn:hover,.btn:active,.btn.active,.btn.disabled,.btn[disabled]{color:#333;background-color:#e6e6e6;*background-color:#d9d9d9;}
.btn:active,.btn.active{background-color:#cccccc \9;}
.btn:first-child{*margin-left:0;}
.btn:hover{color:#333333;text-decoration:none;background-position:0 -15px;-webkit-transition:background-position 0.1s linear;-moz-transition:background-position 0.1s linear;-o-transition:background-position 0.1s linear;transition:background-position 0.1s linear;}
.btn:focus{outline:thin dotted #333;outline:5px auto -webkit-focus-ring-color;outline-offset:-2px;}
.btn.active,.btn:active{background-image:none;outline:0;-webkit-box-shadow:inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);-moz-box-shadow:inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);box-shadow:inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);}
.btn-primary{width: 100%;color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,0.25);background-color:#006dcc;*background-color:#0044cc;background-image:-moz-linear-gradient(top,#0088cc,#0044cc);background-image:-webkit-gradient(linear,0 0,0 100%,from(#0088cc),to(#0044cc));background-image:-webkit-linear-gradient(top,#0088cc,#0044cc);background-image:-o-linear-gradient(top,#0088cc,#0044cc);background-image:linear-gradient(to bottom,#0088cc,#0044cc);background-repeat:repeat-x;border-color:#0044cc #0044cc #002a80;border-color:rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc',endColorstr='#ff0044cc',GradientType=0);filter:progid:DXImageTransform.Microsoft.gradient(enabled=false);}
.btn-primary:hover,.btn-primary:active,.btn-primary.active,.btn-primary.disabled,.btn-primary[disabled]{color:#ffffff;background-color:#0044cc;*background-color:#003bb3;}
.btn-primary:active,.btn-primary.active{background-color:#003399 \9;}
.admin_copyright{color:#585858;margin-top:10px;font-family:Arial;text-align:center;}
.admin_copyright a:link,.admin_copyright a:visited{color:#f90;}
.admin_copyright a:hover{color:#f90;}

</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/layer-2.4/layer.js"></script>
</head>
<body>
<%
String status=request.getParameter("status");
request.setAttribute("status",status);
%>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${pageContext.request.contextPath}/login.ado" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" placeholder="用户名" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" placeholder="密码" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" onclick="return check();"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="${pageContext.request.contextPath}/index.do" target="_blank">返回首页</a>
  
</div>
<br>
 <!--S footer-->
<jsp:include page="common/footer.jsp" flush="true"/>	
<!--E footer-->
</body>
</html>
<script type="text/javascript">
 
$(function(){
	var status="${status}";
	if(status=="error"){
		layer.msg("用户名或密码不正确",{offset: 0,time:2000});
	}
	
});

</script>