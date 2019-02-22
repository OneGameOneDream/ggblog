/**
 * 菜单权限树
 * 
 * 菜单必须按照此结构
 *  <ul id="tree" class="ztree"></ul>
 */

/*加载ztree*/

/*
var setting = {
		 view: {
             selectedMulti: false,
				showLine: false,
				showIcon: true 
         },
         check: {
             enable: true
         },
		data: {
            simpleData: {
              enable: true,   //设置是否启用简单数据格式（zTree支持标准数据格式跟简单数据格式，上面例子中是标准数据格式）
                 idKey: "id",     //设置启用简单数据格式时id对应的属性名称
                 pidKey: "pId"    //设置启用简单数据格式时parentId对应的属性名称,ztree根据id及pid层级关系构建树结构
           }
       }
}
var zNodes =
	[
        {
            "id": "6",
            "pId": "3",
            "name": "用户删除",
            "open": false,
            "parent": false
        },
        {
            "id": "14",
            "pId": "11",
            "name": "角色删除",
            "open": false,
            "parent": false
        },
        {
            "id": "5",
            "pId": "3",
            "name": "用户编辑",
            "open": false,
            "parent": false,
            "checked":true
        },
        {
            "id": "8",
            "pId": "7",
            "name": "日志删除",
            "open": false,
            "parent": false
        },
        {
            "id": "11",
            "pId": "2",
            "name": "角色管理",
            "open": true,
            "parent": true
        },
        {
            "id": "13",
            "pId": "11",
            "name": "角色编辑",
            "open": false,
            "parent": false
        },
        {
            "id": "4",
            "pId": "3",
            "name": "用户新增",
            "open": false,
            "parent": false
        },
        {
            "id": "7",
            "pId": "2",
            "name": "日志管理",
            "open": true,
            "parent": true
        },
        {
            "id": "12",
            "pId": "11",
            "name": "角色新增",
            "open": false,
            "parent": false
        },
        {
            "id": "3",
            "pId": "2",
            "name": "用户管理",
            "open": true,
            "parent": true
        },
        {
            "id": "10",
            "pId": "1",
            "name": "其他",
            "open": true,
            "isParent": true
        },
        {
            "id": "2",
            "pId": "1",
            "name": "系統管理",
            "open": true,
            "parent": true
        },
        {
            "id": "1",
            "pId": "0",
            "name": "顶级菜单",
            "open": true,
            "parent": true
        }
    ];
$(document).ready(function () {
    zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes); //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
});

*/

var treeObj;
$(function () {
    var setting = {                 //此处根据自己需要进行配置
        view: {
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: true
        }
        /*,
        callback: {
            onClick: onDesignTreeClick,
            onRightClick: OnRightClick,
            beforeRename: beforeRename,
            onCheck:onCheck
        }*/
    };
    var id = $('#id').val();
    $.ajax({
        type: "Get",
        url: "/ggblog/sys/menu/tree/"+id,                  //ajax请求地址
           success: function (data) {
        	   //console.log(data.data);
        	   zTreeObj = $.fn.zTree.init($("#tree"), setting, data.data);  //加载数据
        	   treeObj = $.fn.zTree.getZTreeObj("tree");
        },
    });
    
    $('#submitBtn').click(function(){
    	debugger;
    	 var nodes = treeObj.getCheckedNodes(true);
    	 var nodeArr =  new Array();
 	       if(nodes!=null){
 	    	   for(var i in nodes){
 	    		   nodeArr.push(nodes[i].id);
 	    	   }
 	    	   var ids = nodeArr.join(",");
 	    	   $('#menuIds').val(ids);
 	       }
    })
    
    
});
