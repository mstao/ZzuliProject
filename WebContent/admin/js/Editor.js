 // 阻止输出log
        // wangEditor.config.printLog = false;

        var editor = new wangEditor('editor-trigger');
        
        editor.config.pasteFilter=true;
        editor.config.pasteText = true;
        //移除菜单项   video 和location
       /* editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
          if (item === 'video') {
              return null;
         }
          if (item === 'location') {
              return null;
          }
          if(item==='alignright'){
          	  return null;
          }
          if(item==='table'){
          	  return null;
          }
          return item;
      });*/
        
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

        // 隐藏网络图片
        // editor.config.hideLinkImg = true;

      

        // 插入代码时的默认语言
        // editor.config.codeDefaultLang = 'html'

        // 只粘贴纯文本
        // editor.config.pasteText = true;

        // 跨域上传
        // editor.config.uploadImgUrl = 'http://localhost:8012/upload';

        // 第三方上传
        // editor.config.customUpload = true;

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
          
        // 普通菜单配置
        // editor.config.menus = [
        //     'img',
        //     'insertcode',
        //     'eraser',
        //     'fullscreen'
        // ];
        // 只排除某几个菜单（兼容IE低版本，不支持ES5的浏览器），支持ES5的浏览器可直接用 [].map 方法
        // editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
        //     if (item === 'insertcode') {
        //         return null;
        //     }
        //     if (item === 'fullscreen') {
        //         return null;
        //     }
        //     return item;
        // });

        // onchange 事件
        // editor.onchange = function () {
        //     console.log(this.$txt.html());
        // };


        // 取消过滤js
        // editor.config.jsFilter = false;

        // 取消粘贴过来
        // editor.config.pasteFilter = false;

        // 设置 z-index
        // editor.config.zindex = 20000;

        // 语言
        // editor.config.lang = wangEditor.langs['en'];

        // 自定义菜单UI
        // editor.UI.menus.bold = {
        //     normal: '<button style="font-size:20px; margin-top:5px;">B</button>',
        //     selected: '.selected'
        // };
        // editor.UI.menus.italic = {
        //     normal: '<button style="font-size:20px; margin-top:5px;">I</button>',
        //     selected: '<button style="font-size:20px; margin-top:5px;"><i>I</i></button>'
        // };
        
        
        //创建编辑器
        editor.create();
        
        
        /*
         * editor.$text
         * 
         * editor.$txt是一个 jquery 封装的div元素，这个div元素就是编辑器的可编辑区域。
         *因此，想要设置、获取、处理编辑器区域的内容，操作这个 editor.$txt 即可。
         * 由于它本身就是 jquery 封装的，因此支持 jquery 所有API
         */
        
        
        //初始化内容
        editor.$txt.html('');
        
        
       /* $(function(){
        	//获取编辑器中的内容
        	$('#bt1').click(function(){
        		// 获取编辑器区域完整html代码
		        var html = editor.$txt.html();
		        alert(html);
		        // 获取编辑器纯文本内容
		        var text = editor.$txt.text();
		        alert(text);
		        // 获取格式化后的纯文本
		        var formatText = editor.$txt.formatText();
		        alert(formatText);
        	});
        	
        	//追加内容
	        $('#btn2').click(function(){
	        	editor.$txt.append('<p>追加的内容</p>');
	        });
	        
	        //清空内容
	        $('#btn3').click(function(){
	        	editor.$txt.html('<p><br></P>');
	        });
        });*/
        
        
       
        $(function(){
        	
        	 /**************发表新闻公告 AJAX 发布***************/
        	$('.publish-news-btn').bind('click',function(){
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
            			s_json={"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"image_path":img_path,"add_time":date_picker};
            		}else{
            			is_image=0;
            			img_path="0";
            			s_json={"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"image_path":img_path,"add_time":date_picker};
            		}
            		
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addnews.ado',
        				data:s_json,
        				/*data:"type="+type+"&title="+title+"&content="+content+"&author="+publish_dept+"&is_image="+is_image+"&is_publish="+is_publish,*/
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/newslist.ado?type="+TYPE+"&p=1";
        						}
        						
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
        	});
        	
        	/**************发表新闻公告 AJAX 保存为草稿***************/
        	$('.draft-news-btn').bind('click',function(){
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
        			
        			var is_publish=0; //意味着要发表1，不是存为草稿0
        			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
            		var is_image;
            		var img_path="";
            		var s_json;
            		if(editor.$txt.find("img[src!='']").length>0){
            			is_image=1;
            			img_path=editor.$txt.find("img[src!='']:first").attr("src");
            			s_json={"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"image_path":img_path,"add_time":date_picker};
            		}else{
            			is_image=0;
            			s_json={"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish,"add_time":date_picker};
            		}
            		
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addnews.ado',
        				data:s_json,
        				/*data:"type="+type+"&title="+title+"&content="+content+"&author="+publish_dept+"&is_image="+is_image+"&is_publish="+is_publish,*/
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/newslist.ado?type="+TYPE+"&p=1";
        						}
        						
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
        	});
        	
        	/*****************发布规章制度 AJAX******************/
        	$('.publish-rule-btn').bind('click',function(){
        	
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=1; //意味着要发表1，不是存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addrule.ado',
        				data:{"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
        				
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/ruleslist.ado?p=1";
        						}
        						
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
        	});
        	
        	/*****************发布规章制度 AJAX 存为草稿******************/
        	$('.draft-rule-btn').bind('click',function(){
            	
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=0; //存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addrule.ado',
        				data:{"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
        				
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
        						layer.msg('保存为草稿成功，您可以在列表中查看编辑', {icon: 1,time:2000});
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/ruleslist.ado?p=1";
        						}
        						
        					}else{
        						layer.msg("保存为草稿出错了", {icon: 2,time:2000});
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
        	
        	
        	
        	/*****************发布科学研究 AJAX******************/
        	$('.publish-research-btn').bind('click',function(){
        		//获取发表类型
        		var type=$('#publish-style').val();
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
            		var is_image;
            		if(editor.$txt.find("img[src!='']").length>0){
            			is_image=1;
            		}else{
            			is_image=0;
            		}
            		var is_publish=1; //意味着要发表1，不是存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addresearch.ado',
        				data:{"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish},
        				
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/researchlist.ado?type="+TYPE+"&p=1";
        						}
        						
        						
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
        	});
        	
        	/*****************发布科学研究 AJAX 存为草稿******************/
        	$('.draft-research-btn').bind('click',function(){
        		//获取发表类型
        		var type=$('#publish-style').val();
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
            		var is_image;
            		if(editor.$txt.find("img[src!='']").length>0){
            			is_image=1;
            		}else{
            			is_image=0;
            		}
            		var is_publish=0; //存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addresearch.ado',
        				data:{"type":type,"title":title,"content":content,"author":publish_dept,"is_image":is_image,"is_publish":is_publish},
        				
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
        						layer.msg('保存为草稿成功，您可以在列表中查看编辑', {icon: 1,time:2000});
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/researchlist.ado?type="+TYPE+"&p=1";
        						}
        						

        					}else{
        						layer.msg("保存为草稿出错了", {icon: 2,time:2000});
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
        	
        	
        	
        	/*****************发布成果转化 AJAX******************/
        	$('.publish-achievement-btn').bind('click',function(){
        		//获取发表类型
        		var type=$('#publish-style').val();
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=1; //意味着要发表1，不是存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addachievement.ado',
        				data:{"type":type,"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/showachievement.ado?type="+type+"&p=1";
        						}
        						
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
        	});
        	
        	/*****************发布成果转化 AJAX 存为草稿******************/
        	$('.draft-achievement-btn').bind('click',function(){
        		//获取发表类型
        		var type=$('#publish-style').val();
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=0; //存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addachievement.ado',
        				data:{"type":type,"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
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
        						layer.msg('保存为草稿成功，您可以在列表中查看编辑', {icon: 1,time:2000});
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/showachievement.ado?type="+type+"&p=1";
        						}
        					}else{
        						layer.msg("保存为草稿出错了", {icon: 2,time:2000});
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
        	
        	
        	/**************发表  大型仪器-规章制度信息 发布*****************/
        	$('.publish-i-rule-btn').bind('click',function(){
            	
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=1; //意味着要发表1，不是存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addinstrumentrule.ado',
        				data:{"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
        				
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
        						$('.hidden-item-id').val(data);
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/showinstrumentrule.ado?p=1";
        						}
        						
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
        	});
        	
        	
        	
        	/***************草稿 大型仪器-规章制度 存为草稿********************/
           $('.draft-i-rule-btn').bind('click',function(){
            	
        		//获取标题
        		var title=$('.edit-title').val();
        		//获取内容
        		var content=editor.$txt.html();
        		//获取发布部门
        		var publish_dept=$('.publish-dept').val();
        		//获取内容的纯文本  
        		var text_content=editor.$txt.text();
        		//判断标题和内容是否为空
        		if(title=="" || text_content=="" ||publish_dept==""){
        			layer.msg("标题,内容和发布部门不能为空");
        		}else{
        			
            		var is_publish=0; //存为草稿0
        			$.ajax({
        				type:'post',
        				dataType:'text',
        				url:CTPPATH+'/addinstrumentrule.ado',
        				data:{"title":title,"content":content,"author":publish_dept,"is_publish":is_publish},
        				
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
        						//判断有无上传文件列队
        						if(getQueueSize("uploadify")>0){
        							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
        							upload("uploadify");
        						}else{
        							//跳转界面
        							window.location.href=CTPPATH+"/showinstrumentrule.ado?p=1";
        						}
        						
        					
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
        	});
 });
        