/**
 * 更改密码js
 */
	layui.use(['form'],function() {
	    var form = layui.form,
	    layer = layui.layer;
	    //自定义验证规则
	    form.verify({
	        password: [/^[\S]{5,12}$/, '密码必须5到12位，且不能出现空格'],
	        password2: function(value) {
	            if (value != $('#password').val()) {
	                return '确认密码必须和密码一致!';
	            }
	        }
	    });
	    //监听提交
	    form.on('submit(submitBtn)', function(data){
	    	submit();
	    });
	});
	
	
	/*提交表单*/
	function submit(){
		$.ajax({
			url : "/ggblog/sys/user/updatePassword",
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
				layer.msg('error', {
					time : 1000,
				});
			}

		});
    }
	
