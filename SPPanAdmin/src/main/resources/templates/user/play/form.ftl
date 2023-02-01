<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>jQuery Validate 简介</h5>
                    </div>
                    <div class="ibox-content">
                        <p>jquery.validate.js 是一款优秀的jQuery表单验证插件。它具有如下特点：</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>完整验证表单</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/play/edit">
                        	<input type="hidden" id="id" name="id" value="${play.id}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">比赛名：</label>
                                <div class="col-sm-8">
                                    <input id="name" name="name" class="form-control" type="text" value="${play.name}" <#if play?exists> </#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-8">
                                    <input id="starttime" name="starttime" class="form-control" type="date" value="${play.starttime}" <#if play?exists> </#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-8">
                                    <input id="endtime" name="endtime" class="form-control" type="date" value="${play.endtime}" <#if play?exists> </#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">场地编号：</label>
                                <div class="col-sm-8">
                                    <input id="ground_id" name="ground_id" class="form-control" type="text" value="${play.ground_id}" <#if play?exists> </#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">参加人数：</label>
                                <div class="col-sm-8">
                                    <input id="joincount" name="joincount" class="form-control" type="text" value="${play.joincount}" <#if play?exists> </#if> >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	  	//外部js调用
	    laydate({
	        elem: '#birthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	    });
	  	
	    $("#frm").validate({
    	    rules: {
    	    	userName: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 10
    	      },
    	      	nickName: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 10
    	      },
    	      	sex: {
    	        required: true
    	      },
    	      	birthday: {
    	      	date:true,
    	        required: true
    	      },
    	      	telephone: {
    	        required: true
    	      },
    	      	email: {
    	      	email:true,
    	        required: true
    	      },
    	      	address: {
    	        required: true,
    	        maxlength: 40
    	      },
    	      	locked: {
    	        required: true
    	      },
    	      	description: {
    	        required: true,
    	        maxlength: 40
    	      }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/play/edit",
   	    		   data: $(form).serialize(),
   	    		   success: function(msg){
	   	    			layer.msg(msg.message, {time: 2000},function(){
	   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   						parent.layer.close(index); 
	   					});
   	    		   }
   	    		});
            } 
    	});
    });
    </script>

</body>

</html>
