
//后台一些通用js
$(function(){
	//日期截取 [yyyy-MM-dd HH:mm:ss]
	/*$('.sub-time').each(function(){
		var  time_c=$(this).text();
		var time_s=time_c.substr(0,11);
		time_ss=time_s+"]";
		$(this).text(time_ss);
	});*/
	
	//全选和取消全选
	$('.new_div2_input').click(function(){
	  var is_check=$('.new_div2_input').is(':checked');
	  var info_check=document.getElementsByName('info_id');
	  if(is_check==true){

		for(var i=0;i<info_check.length;i++){
			info_check[i].checked=true;
		}
			  	   
	  }else{
	  	for(var i=0;i<info_check.length;i++){
		    info_check[i].checked=false;
		}
	  }
	});
   //限制标题的显示字数长度
   $('.item_title').each(function(){
   		var item_length= $(this).text().length;
   		var  maxwidth=17;
   		if(item_length>maxwidth){
    		$(this).text($(this).text().substring(0,maxwidth)+'...');
     	}
   	});
    //详细信息 发布日期 截取
	$('.sub-time').each(function(){
		var time_c=$(this).text();
		var time_s=time_c.substr(0,11);
		time_ss=time_s;
		$(this).text(time_ss);
	});
	
	
});

//判断用户是否保存信息  ，提示
var hasSaved = false;//是否有输入的内容未保存标志，初始值为false
function CheckUnsave(){
if(hasSaved==false){
//alert("您上传的东西尚未保存，请保存后再离开页面");
return "您上传的东西尚未保存，请保存后再离开页面";}
}

//保存了则改变状态
function ChangeState()
{
hasSaved = true;
} 