/**
 * 用户模块js
 */
		var tableIns;
		layui.use(['table','form'], function(){
		  var form = layui.form;	
		  var table = layui.table;
		  tableIns = table.render({
 		     elem: '#table'
	    	,toolbar: '#toolbarDemo'
		    ,url:'/ggblog/sys/user/list'
		    ,title: '用户数据表'
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,cols: 
		    [
		    	[
	    		   {type:'checkbox'}
			     // ,{field:'id', title: '编号', sort: true}
			      ,{field:'username', title: '用户名'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
			      ,{field:'sex', title: '性别', sort: true,templet: function(data){
			         	if(data.sex=='0'){
			         		return "男";
			         	}else{
			         		return "女";
			         	}
			        }}
			      ,{field:'email', title: '邮箱'}
			      ,{field:'mobile', title: '手机'}
			      ,{field:'loginIp', title: '上次登录ip', align: 'center'} //单元格内容水平居中
			      ,{field:'loginDate', title: '上次登录时间', sort: true, align: 'center',width: 170} //单元格内容水平居中
			      ,{field:'stats', title: '状态',templet: function(data){
			         	if(data.stats=='0'){
			         		return '<input id="'+data.id+'" type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="开启|禁用" value="'+data.id+'">';
			         	}else{
			         		return '<input id="'+data.id+'" type="checkbox" name="close" lay-skin="switch" lay-filter="switchTest" lay-text="开启|禁用" value="'+data.id+'">';
			         	}
			        }}
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		   		]
	    	]
		    ,page: true
		    ,response: {
		      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
		    }
		    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
		      return {
		        "code": res.code, //解析接口状态
		        "msg": res.msg, //解析提示文本
		        "count": res.data.totalCount, //解析数据长度
		        "data": res.data.list //解析数据列表
		      };
		    }
		    ,text: {
		        none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
		     }
		  });
		  
		  /*监听工具条*/
		  table.on('tool(table)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'detail'){
		      layer.msg('ID：'+ data.id + ' 的查看操作');
		    } else if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		    	  del(obj,index,'/ggblog/sys/user/delete/'+data.id);
		      });
		    } else if(obj.event === 'edit'){
		    	layer_show('用户编辑','/ggblog/sys/user/edit/'+data.id,'800','500')
		    }
		  });
		  
		//监听指定开关
		  form.on('switch(switchTest)', function(obj){
			 if(this.checked){
			 		start(obj.value);
			  	}else{
			  		stop(obj.value);
			  	}
			  });
		  
		});
		
		/*搜索*/
	 	function search(){
	 		 tableIns.reload({
	 		    where: { //设定异步数据接口的额外参数，任意设
	 		    	username:$.trim($('#username').val()),
	 		    	sex:$('#sex').next().find('.layui-this').attr("lay-value"),
	 		    	stats:$('#stats').next().find('.layui-this').attr("lay-value"),
	 		    }
	 		    ,page: {
	 		      curr: 1 //重新从第 1 页开始
	 		    }
	 		    ,response: {
	 		      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
	 		    }
	 		    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
	 		      return {
	 		        "code": res.code, //解析接口状态
	 		        "msg": res.msg, //解析提示文本
	 		        "count": res.data.totalCount, //解析数据长度
	 		        "data": res.data.list //解析数据列表
	 		      };
	 		    }
	 		  });
		}
	
		
		/*用户-禁用*/
		function stop(id) {
		        $.ajax({
		            type: 'POST',
		            url: '/ggblog/sys/user/stop/' + id,
		            dataType: 'json',
		            success: function(data) {
		                if (data.code == '200') {
		                    layer.msg('已禁用', {time: 1000});
		                } else {
		                	$('#'+id).next().addClass("layui-form-onswitch");
		                	$('#'+id).next().find('em').text("开启");
		                	layer.msg(data.data,{time:1000});
		                }
		            },
		            error: function(data) {
		            	layer.msg('服务器相应失败',{time:1000});
		            },
		        });
		}

		/*用户-启用*/
		function start(id) {
	        $.ajax({
	            type: 'POST',
	            url: '/ggblog/sys/user/start/' + id,
	            dataType: 'json',
	            success: function(data) {
	                if (data.code == '200') {
	                    layer.msg('已开启', {time: 1000});
	                } else {
	                	$('#'+id).next().removeClass("layui-form-onswitch");
	                	$('#'+id).next().find('em').text("禁用");
	                	layer.msg(data.data,{time:1000});
	                }
	            },
	            error: function(data) {
	            	layer.msg('服务器相应失败',{time:1000});
	            },
	        });
		}
		
