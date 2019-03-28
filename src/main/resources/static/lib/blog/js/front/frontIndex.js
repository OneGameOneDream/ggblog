/**
 * 首页js
 */
$(function(){
  	$('.tag').each(function(index){
  		if(index==0){
	    		$(this).addClass("active");
  		}
  	})
  	
  	$('.tag').click(function(){
  		$('.tag').each(function(){
  			$(this).removeClass('active');
  		})
  		$(this).addClass("active");
  		page();
  	})
  	//分页
  	page();
})
  
    layui.config({
      base: '/ggblog/lib/blog/js/util/'
    }).use(['element','jquery','menu'],function(){
      element = layui.element,$ = layui.$,menu = layui.menu;
      menu.init();
    })
    
    //分页
    function page(){
	  layui.use(['laypage'], function () {
          laypage = layui.laypage
          var tags = $('.layui-breadcrumb').find('.active').text();
          if(tags=='少数派'){
        	//开始分页
				laypage.render({
		 	   	     elem: 'demo'
		 		    ,count: 1000
		 		    ,jump: function(obj){
		 		    	loadShaoshupai(obj.curr,obj.limit);
		 		    }
		 	      });
          }else if(tags=='bilibili科技视频'){
        	//开始分页
				laypage.render({
		 	   	     elem: 'demo'
		 		    ,count: 1000
		 		    ,jump: function(obj){
		 		    	loadBilibili(obj.curr,obj.limit);
		 		    }
		 	      });
          }else if(tags=='必应每日壁纸'){
        	//开始分页
				laypage.render({
		 	   	     elem: 'demo'
		 		    ,count: 8
		 		    ,jump: function(obj){
		 		    	loadBing();
		 		    }
		 	      });
          }else{
        	//请求总数,请求最新文章
            	 $.ajax({
     			url : "/ggblog/blog/article/count",
     			type : "GET",
     			success : function(data) {
     				if(data.code=='200'){
     					//开始分页
     					laypage.render({
     			 	   	     elem: 'demo'
     			 		    ,count: data.count
     			 		    ,jump: function(obj){
     			 		    	loadData(obj.curr,obj.limit);
     			 		    }
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
          }
      });
  	}
    
    //加载信息
     function loadData(page,limit){
    	//loadding弹框
    	var index = layer.load(2, {
   		  shade: [0.1,'#fff'] //0.1透明度的白色背景
  		});
    	var tags = $('.layui-breadcrumb').find('.active').text();
    	$.ajax({
			url : "/ggblog/blog/article/list?page="+page+"&limit="+limit,
			type : "GET",
			success : function(data) {
				if(data.code=='200'){
					$(".list-item").empty();
					list = data.data.list;
					for(var i = 0;i<list.length;i++){
						pushHtml(list[i]);
						//不是第一页的话就跳到锚点
						if(page!=1){
							document.querySelector("#title").scrollIntoView(true);
						}
					}
					layer.close(index); 
				}else{
					layer.msg(data.data, {
						time : 1000,
					});
					layer.close(index); 
				}
			},
			error : function(XmlHttpRequest, errorThrown) {
				layer.msg('error!', {
					time : 1000,
				});
				layer.close(index); 
			}

		});
    }
    //填充html
    function pushHtml(data){
    	var html = '<div class="item">'
    		+'           <div class="layui-fluid">'
    		+'             <div class="layui-row">'
    		+'               <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">'
    		+'                 <div class="img"><img src="'+data.image+'" alt=""></div>'
    		+'               </div>'
    		+'               <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">'
    		+'                 <div class="item-cont">'
    		+'                   <a href="f/article/'+data.id+'"><h3>'+data.title+'<button class="layui-btn layui-btn-danger new-icon">new</button></h3></a>'
    		+'                   <h5><span class="layui-badge  layui-bg-blue">'+data.tags+'</span></h5>'
    		+'                   <p>更新时间：'+data.updateDate+'</p>'
    		+'                   <a href="f/article/'+data.id+'" class="go-icon"></a>'
    		+'                 </div>'
    		+'             </div>'
    		+'             </div>'
    		+'            </div>'
    		+'         </div>';
    	$(".list-item").append(html);
    }
    
    //加载少数派文章
    function loadShaoshupai(page,limit){
    	//loadding弹框
    	var index = layer.load(2, {
   		  shade: [0.1,'#fff'] //0.1透明度的白色背景
  		});
    	$.ajax({
			url : "https://sspai.com/api/v1/articles?offset="+(page-1)*10+"&limit="+limit+"&type=recommend_to_home&sort=recommend_to_home_at&include_total=false",
			type : "GET",
			success : function(data) {
					$(".list-item").empty();
					list = data.list;
					for(var i = 0;i<list.length;i++){
						pushShaoshupaiHtml(list[i]);
						//不是第一页的话就跳到锚点
						if(page!=1){
							document.querySelector("#title").scrollIntoView(true);
						}
					}
					layer.close(index); 
			},
			error : function(XmlHttpRequest, errorThrown) {
				layer.msg('error!', {
					time : 1000,
				});
				layer.close(index); 
			}

		});
    }
    
  //填充少数派文章
    function pushShaoshupaiHtml(data){
    	var html = '<div class="item">'
    		+'           <div class="layui-fluid">'
    		+'             <div class="layui-row">'
    		+'               <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">'
    		+'                 <div class="img"><img src="https://cdn.sspai.com/'+data.banner+'" alt=""></div>'
    		+'               </div>'
    		+'               <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">'
    		+'                 <div class="item-cont">'
    		+'                   <a target="_blank" href="https://sspai.com/post/'+data.id+'"><h3>'+data.title+'<button class="layui-btn layui-btn-danger new-icon">new</button></h3></a>'
    		+'                   <h5><span class="layui-badge  layui-bg-blue">少数派</span></h5>'
    		+'                   <p>'+data.promote_intro+'</p>'
    		+'                   <a target="_blank" href="https://sspai.com/post/'+data.id+'" class="go-icon"></a>'
    		+'                 </div>'
    		+'             </div>'
    		+'             </div>'
    		+'            </div>'
    		+'         </div>';
    	$(".list-item").append(html);
    }
    
    
    
    
  //加载哔哩哔哩文章
    function loadBilibili(page,limit){
    	//loadding弹框
    	var index = layer.load(2, {
   		  shade: [0.1,'#fff'] //0.1透明度的白色背景
  		});
    	$.ajax({
			url : "/ggblog/blog/article/bilibili?page="+page,
			type : "GET",
			dataType:"json", 
			success : function(data) {
					$(".list-item").empty();
					list = data.data.archives;
					for(var i = 0;i<10;i++){
						pushBilibiliHtml(list[i]);
						//不是第一页的话就跳到锚点
//						if(page!=1){
//							document.querySelector("#title").scrollIntoView(true);
//						}
					}
					layer.close(index); 
			},
			error : function(XmlHttpRequest, errorThrown) {
				layer.msg('error!', {
					time : 1000,
				});
				layer.close(index); 
			}

		});
    }
    
  //填充哔哩哔哩文章
    function pushBilibiliHtml(data){
    	var html = '<div class="item">'
    		+'           <div class="layui-fluid">'
    		+'             <div class="layui-row">'
    		+'               <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">'
    		+'                 <div class="img"><img src="/ggblog/blog/article/crosImg?path='+data.pic+'" alt=""></div>'
    		+'               </div>'
    		+'               <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">'
    		+'                 <div class="item-cont">'
    		+'                   <a target="_blank" href="https://www.bilibili.com/video/av'+data.aid+'"><h3>'+data.title+'<button class="layui-btn layui-btn-danger new-icon">new</button></h3></a>'
    		+'                   <h5><span class="layui-badge  layui-bg-blue">哔哩哔哩</span></h5>'
    		+'                   <p>'+data.description+'</p>'
    		+'                   <a target="_blank" href="https://www.bilibili.com/video/av'+data.aid+'" class="go-icon"></a>'
    		+'                 </div>'
    		+'             </div>'
    		+'             </div>'
    		+'            </div>'
    		+'         </div>';
    	$(".list-item").append(html);
    }
    //必应壁纸
    function loadBing(){
    	//loadding弹框
    	var index = layer.load(2, {
   		  shade: [0.1,'#fff'] //0.1透明度的白色背景
  		});
    	$.ajax({
			url : "/ggblog/blog/article/bing",
			type : "GET",
			dataType:"json", 
			success : function(data) {
					console.log(data.images);
					$(".list-item").empty();
					list = data.images;
					for(var i = 0;i<list.length;i++){
						pushBingHtml(list[i]);
					}
					layer.close(index); 
			},
			error : function(XmlHttpRequest, errorThrown) {
				layer.msg('error!', {
					time : 1000,
				});
				layer.close(index); 
			}

		});
    }
    
  //填充哔哩哔哩文章
    function pushBingHtml(data){
    	var html = '<div class="item">'
    		+'           <div class="layui-fluid">'
    		+'             <div class="layui-row">'
    		+'               <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">'
    		+'                 <div class="img"><img src="/ggblog/blog/article/crosImg?path=http://s.cn.bing.net'+data.url+'" alt=""></div>'
    		+'               </div>'
    		+'               <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">'
    		+'                 <div class="item-cont">'
    		+'                   <a target="_blank" href="http://s.cn.bing.net'+data.url+'"><h3>'+data.copyright+'</h3></a>'
    		+'                   <h5><span class="layui-badge  layui-bg-blue">Bing壁纸</span></h5>'
    		+'                   <p>'+data.copyright+'</p>'
    		+'                   <a target="_blank" href="http://s.cn.bing.net'+data.url+'" class="go-icon"></a>'
    		+'                 </div>'
    		+'             </div>'
    		+'             </div>'
    		+'            </div>'
    		+'         </div>';
    	$(".list-item").append(html);
    }
    