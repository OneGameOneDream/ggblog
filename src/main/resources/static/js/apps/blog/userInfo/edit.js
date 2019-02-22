/**
 * 编辑博主信息js
 */
var layedit;
	var index;
	layui.use(['form','layedit','upload'],function() {
	    var form = layui.form,layer = layui.layer,upload = layui.upload;
	  //logo图片上传
	    var uploadInst = upload.render({
	      elem: '#uploadBtn'
	      ,url: '/ggblog/blog/userInfo/uploadImage'
	      ,before: function(obj){
	        //预读本地文件示例，不支持ie8
	        obj.preview(function(index, file, result){
	          $('#demo1').attr('src', result); //图片链接（base64）
	        });
	      }
	      ,done: function(res){
	        //如果上传失败
	        if(res.code > 0){
	          return layer.msg('上传失败');
	        }
	        //上传成功
	        console.log(res.data.src);
	        $('#qrcode').val(res.data.src);
	      }
	      ,error: function(){
	        //演示失败状态，并实现重传
	        var demoText = $('#demoText');
	        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	        demoText.find('.demo-reload').on('click', function(){
	          uploadInst.upload();
	        });
	      }
	    });
	    
	    
	    
	  //头像上传
	    var uploadInst2 = upload.render({
	      elem: '#uploadBtn2'
	      ,url: '/ggblog/blog/version/uploadImage'
	      ,before: function(obj){
	        //预读本地文件示例，不支持ie8
	        obj.preview(function(index, file, result){
	          $('#demo2').attr('src', result); //图片链接（base64）
	        });
	      }
	      ,done: function(res){
	        //如果上传失败
	        if(res.code > 0){
	          return layer.msg('上传失败');
	        }
	        //上传成功
	        console.log(res.data.src);
	        $('#head').val(res.data.src);   
	      }
	      ,error: function(){
	        //演示失败状态，并实现重传
	        var demoText = $('#demoText2');
	        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	        demoText.find('.demo-reload').on('click', function(){
	          uploadInst.upload();
	        });
	      }
	    });
	    
  //监听提交
    form.on('submit(submitBtn)', function(data){
    	submit();
    });
})

/*提交表单*/
function submit(){
	$.ajax({
		url : "/ggblog/blog/userInfo/update",
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
};

