/**
 * 字典模块js
 */
	var tableIns;
	layui.use(['table','form'], function(){
	  var form = layui.form;	
	  var table = layui.table;
	  tableIns = table.render({
	     elem: '#table'
    	,toolbar: '#toolbarDemo'
	    ,url:'/ggblog/sys/dict/list'
	    ,title: '字典数据表'
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,cols: 
	    [
	    	[
    		   {type:'checkbox'}
		     // ,{field:'id', title: '编号', sort: true}
		      ,{field:'label', title: '标签名'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'value', title: '数据值'}
		      ,{field:'type', title: '类型'}
		      ,{field:'remarks', title: '描述'}
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
	    	  del(obj,index,'/ggblog/sys/dict/delete/'+data.id);
	      });
	    } else if(obj.event === 'edit'){
	    	layer_show('字典编辑','/ggblog/sys/dict/edit/'+data.id,'800','600');
	    } else if(obj.event === 'add'){
	    	layer_show('字典添加','/ggblog/sys/dict/add/'+data.id,'800','600');
	    } 
	  });
	  
	});
	
	/*搜索*/
 	function search(){
 		 tableIns.reload({
 		    where: { //设定异步数据接口的额外参数，任意设
 		    	dictName:$.trim($('#label').val())
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

	
