/**
 * 编辑用户js
 */
		layui.use(['form'],function() {
		    var form = layui.form,
		    layer = layui.layer;
		    //自定义验证规则
		    form.verify({
		    });
		    //监听提交
		    form.on('submit(submitBtn)', function(data){
		    	submit();
		    });
		})
		
		/*提交表单*/
		function submit(){
			$.ajax({
				url : "/ggblog/sys/menu/update",
				data : $('#submitForm').serialize(),
				type : "POST",
				success : function(data) {
					if(data.code=='200'){
						layer.msg('修改成功', {
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
					layer.msg('服务器相应失败',{time:1000});
				}

			});
		};
