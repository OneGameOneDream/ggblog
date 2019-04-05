/**
 * 菜单模块js
 */

var treetable;
layui.config({
        base: '/ggblog/lib/layui/lay/treeTable/module/'
    }).extend({
    	treetable: 'treetable-lay/treetable'
    }).use(['layer', 'table', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        treetable = layui.treetable;

        // 渲染表格
        var renderTable = function () {
            layer.load(2);
            treetable.render({
                treeColIndex: 1,
                treeSpid: 0,
                treeIdName: 'id',
                treePidName: 'parentId',
                treeDefaultClose: false,
                treeLinkage: false,
                elem: '#table',
                toolbar: '#toolbarDemo',
                url: '/ggblog/sys/menu/tree',
                page: false,
                cols: [[
                    {type: 'numbers'},
                    {field: 'name', title: '菜单名称'},
                    {field: 'permission', title: '权限标识'},
                    {field: 'href', title: '菜单url'},
                    {field: 'sort', title: '权重排序'},
                    {field:'type', title: '类型',templet: function(data){
			         	if(data.type==0){
			         		return '目录';
			         	}else if(data.type==1){
			         		return '菜单';
			         	}else{
			         		return '按钮';
			         	}
			        }},
                    {fixed: 'right', title:'操作', templet:function(data){
                    	if(data.id=='1'){
                    		return '<a class="layui-btn layui-btn-xs layui-btn-normal " lay-event="addAfter">添加下级</a>';
                    	}
			         	if(data.type==2){
			         		return '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a><a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
			         	}else{
			         		return '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a><a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a><a class="layui-btn layui-btn-xs layui-btn-normal " lay-event="addAfter">添加下级</a>';
			         	}
			         }
			        }
                ]],
                done: function () {
                    layer.closeAll('loading');
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
  		      layer.confirm('真的删除该菜单与其所有子菜单么', function(index){
  		    	  del(obj,index,'/ggblog/sys/menu/delete/'+data.id);
  		      });
  		    } else if(obj.event === 'edit'){
  		    	layer_show('用户编辑','/ggblog/sys/menu/edit/'+data.id,'800','500');
  		    } else if(obj.event === 'addAfter'){
  		    	layer_show('添加下级','/ggblog/sys/menu/add/'+data.id,'800','500');
  		    }
  		  });
        };
        renderTable();
    });
	//全部展开
	function expand() {
	    treetable.expandAll('#table');
    }
//全部折叠
	function fold() {
	    treetable.foldAll('#table');
    }
