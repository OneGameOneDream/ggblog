/**
 * 日志模块js
 */
	 	var tableIns;
		layui.use(['table','form'], function(){
		  var form = layui.form;	
		  var table = layui.table;
		  tableIns = table.render({
 		     elem: '#table'
	    	,toolbar: '#toolbarDemo'
		    ,url:'/ggblog/common/log/list'
		    ,title: '日志数据表'
		    ,cellMinWidth: 50 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,cols: 
		    [
		    	[
	    		   {type:'checkbox'}
			      //,{field:'id', title: '编号', sort: true}
			      ,{field:'method', title: '请求方式',width:80} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
			      ,{field:'type', title: '日志类型' ,templet: function(data){
			         	if(data.type=='success'){
			         		return "正常日志";
			         	}else{
			         		return "错误日志";
			         	}
			        }
			       }
			      ,{field:'url', title: '请求路径'}
			      ,{field:'remarks', title: '描述'}
			      ,{field:'httpStatusCode', title: '响应码',width:80}
			      ,{field:'clientIp', title: '客户端请求ip'}
			      ,{field:'createBy', title: '发起人',width:80}
			      ,{field:'createDate', title: '发起时间',sort: true, align: 'center',width: 170}
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
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
		    	  del(obj,index,'/ggblog/common/log/delete/'+data.id);
		      });
		    } else if(obj.event === 'edit'){
		    	debugger;
		    	layer_show('日志详情','/ggblog/common/log/edit/'+data.id,'800','550',true)
		    }
		  });
		  
		});
		
		/*搜索*/
	 	function search(){
	 		 tableIns.reload({
	 		    where: { //设定异步数据接口的额外参数，任意设
	 		    	remarks:$.trim($('#remarks').val()),
	 		    	type:$('#type').next().find('.layui-this').attr("lay-value"),
	 		    	method:$('#method').next().find('.layui-this').attr("lay-value"),
	 		    	createBy:$('#createBy').next().find('.layui-this').attr("lay-value")
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
		
		
		/*清空日志*/
		function emptyLog(){
			layer.confirm('确认要清空所有日志吗？', function(index) {
				$.ajax({
					type: 'POST',
					url: '/ggblog/common/log/empty',
					dataType: 'json',
					success: function(data){
						if(data.code=='200'){
							layer.close(index);
							//表格重载
							search();
						}else{
							layer.msg(data.data,{time:1000});
						}
					},
					error:function(data) {
						layer.msg('服务器相应失败',{time:1000});
					},
				});
			})
		}
		
