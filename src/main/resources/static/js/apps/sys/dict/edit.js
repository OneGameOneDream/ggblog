/**
 * 编辑字典js
 */
layui.use(['form'],function() {
    var form = layui.form,
    layer = layui.layer;
  //监听提交
    form.on('submit(submitBtn)', function(data){
    	submit();
    });
});

/*提交表单*/
function submit(){
	debugger;
	$.ajax({
		url : "/ggblog/sys/dict/update",
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
					return true;
				});
			}else{
				layer.msg(data.data, {
					time : 1000,
				});
				return false;
			}
		},
		error : function(XmlHttpRequest, errorThrown) {
			layer.msg('error', {
				time : 1000,
			});
				return false;
		}

	});
}

