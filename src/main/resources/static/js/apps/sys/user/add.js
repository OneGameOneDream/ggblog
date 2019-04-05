/**
 * 添加用户js
 */
		layui.use(['form'],function() {
		    var form = layui.form,
		    layer = layui.layer;
		    //自定义验证规则
		    form.verify({
		        username: function(value) {
		            if (value.length < 4) {
		                return '用户名至少4个字符';
		            }
		        },
		        password: [/^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'],
		        password2: function(value) {
		            if (value != $('#password').val()) {
		                return '确认密码必须和密码一致!';
		            }
		        },
		        content: function(value) {
		            layedit.sync(editIndex);
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
				url : "/ggblog/sys/user/insert",
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
					layer.msg('服务器相应失败',{time:1000});
				}

			});
        }
