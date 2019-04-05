/*弹出层*/
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
function layer_show(title,url,w,h,max){
	if (title == null || title == '') {
		title=false;
    }
    if (url == null || url == '') {
		url="404.html";
    }
    if (w == null || w == '') {
		w=800;
    }
    if (h == null || h == '') {
		h=($(window).height() - 50);
    }
    //验证权限
	  $.ajax({
	        type: "Get",
	        url: url,                  //ajax请求地址
           success: function (data) {
	        	if(data.code=='500'){
	        		layer.msg(data.data,{time:1000});
	        	}else{
	        		var index =layer.open({
	        			type: 2,
	        			area: [w+'px', h +'px'],
	        			fix: false, //不固定
	        			maxmin: true,
	        			shade:0.4,
	        			title: title,
	        			content: url,
	        		});
	        		if(max!=null || max){
	        			layer.full(index);
	        		}
	        	}
	        },
	    });
}
/*关闭弹出框口*/
function layer_close(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

/*删除*/
function del(obj,index,url) {
	$.ajax({
		type : 'POST',
		url : url,
		dataType : 'json',
		success : function(data) {
			if(data.code=='200'){
				obj.del();
				layer.close(index);
				//表格重载
				search();
			}else{
				layer.msg(data.data,{time : 1000});
			}
		},
		error : function(data) {
			layer.msg('服务器出现问题',{time : 1000});
		},
	});
}

/*批量删除*/
function batchDelete(url) {
	var table = layui.table;
      var checkStatus = table.checkStatus('table')
      ,data = checkStatus.data;
      var arr = [];
      for(var i in data){
		  arr.push(data[i].id);		    	  
      }
      var ids = arr.join(",");
      if (ids == "") {
			layer.msg('请选择至少一条数据!', {time : 1000});
	  } else {
			layer.confirm('确认要批量删除吗？', function(index) {
				$.ajax({
					type: 'POST',
					url: url+ids,
					dataType: 'json',
					success: function(data){
						if(data.code=='200'){
							$('input[type="checkbox"][name="delId"]:checked').each(function(){
								$(this).parents("tr").remove();
							});
							layer.msg('批量删除成功!',{time:1000});
							//表格重载
							search();
						}else{
							layer.msg(data.data, {time : 1000});
						}
					},
					error:function(data) {
						layer.msg('服务器出现问题!', {time : 1000});
					},
				});
			})
		}
}



