/**
 * 添加字典js
 */
	layui.use(['form'],function() {
	    var form = layui.form,
	    layer = layui.layer;
	  //监听提交
	    form.on('submit(submitBtn)', function(data){
	    	submit();
	    });
	})
	
	/*提交表单*/
	function submit(){
		$.ajax({
			url : "/ggblog/sys/dict/insert",
			data : $('#submitForm').serialize(),
			type : "POST",
			success : function(data) {
				if(data.code=='200'){
					layer.msg('添加成功!', {
						time : 1000
					}, function() {
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
						parent.window.location.reload();
					});
				}else{
					layer.msg(data.data, {
						time : 1000,
					});
				}
			},
			error : function(XmlHttpRequest, errorThrown) {
				layer.msg('error!', {
					time : 1000,
				});
			}

		});
	};
