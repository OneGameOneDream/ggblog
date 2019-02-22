/**
 * 文章模块js
 */
	var tableIns;
	layui.use(['table','form'], function(){
	  var form = layui.form;	
	  var table = layui.table;
	  tableIns = table.render({
	     elem: '#table'
    	,toolbar: '#toolbarDemo'
	    ,url:'/ggblog/blog/article/list'
	    ,title: '文章数据表'
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,cols: 
	    [
	    	[
    		   {type:'checkbox'}
		     // ,{field:'id', title: '编号', sort: true}
		      ,{field:'title', title: '标题'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'author', title: '作者'}
		      ,{field:'updateDate', title: '最近修改时间'}
		      ,{field:'hits', title: '浏览次数'}
		      ,{field:'delFlag', title: '状态',templet: function(data){
		         	if(data.delFlag=='0'){
		         		return '<span class="layui-badge layui-bg-gray">发布</span>';
		         	}else if(data.delFlag=='2'){
		         		return '<span class="layui-badge layui-bg-orange">草稿</span>';
		         	}
		        }}
		      ,{field:'tags', title: '标签',templet: function(data){
	         		return '<span class="layui-badge">'+data.tags+'</span>';
		        }
		      }
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
	    	  del(obj,index,'/ggblog/blog/article/delete/'+data.id);
	      });
	    } else if(obj.event === 'edit'){
	    	layer_show('文章编辑','/ggblog/blog/article/edit/'+data.id,'800','600',true);
	    } else if(obj.event === 'add'){
	    	layer_show('文章添加','/ggblog/blog/article/add/'+data.id,'800','600',true);
	    } else if(obj.event === 'goto'){
	    	 var a = $("<a href='http://127.0.0.1:8080/ggblog/f/article/"+data.id+"' target='_blank'></a>").get(0);
             var e = document.createEvent('MouseEvents');
             e.initEvent( 'click', true, true );
             a.dispatchEvent(e);
	    }
	  });
	  
	});
	
	/*搜索*/
 	function search(){
 		 tableIns.reload({
 		    where: { //设定异步数据接口的额外参数，任意设
 		    	title:$.trim($('#title').val())
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

	
