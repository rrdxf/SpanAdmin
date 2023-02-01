<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> 用户登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${ctx!}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/userlogin.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-12">
            	<#if message?exists >
	            	<div class="alert alert-danger">
	                    ${message!}
	                </div>
                </#if>
                <form method="post" action="${ctx!}/user/login" id="frm">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到管理系统</p>
                    <input type="text" class="form-control uname" name="username" id="username" placeholder="账号" />
                    <input type="password" class="form-control pword m-b" name="password" id="password"  placeholder="密码" />
                    <a href="/user/add" class="forget">注册账号</a>
                    <button class="btn btn-success btn-block">登录</button>
                </form>

            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">

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
	<script type="text/javascript">
    $().ready(function() {
    	// 在键盘按下并释放及提交后验证提交表单
    	  $("#frm").validate({
    	    rules: {
    	      username: {
    	        required: true,
    	        minlength: 2
    	      },
    	      password: {
    	        required: true,
    	        minlength: 5
    	      }
    	    },
    	    messages: {
    	      username: {
    	        required: "请输入用户名",
    	        minlength: "用户名必需由两个字母组成"
    	      },
    	      password: {
    	        required: "请输入密码",
    	        minlength: "密码长度不能小于 6 个字母"
    	      }
    	    },
    	    submitHandler:function(form){
                form.submit();
            } 
    	});
    });
    function add(){
        layer.open({
            type: 2,
            title: '用户注册',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/user/add',
            end: function(index){
                $('#table_list').bootstrapTable("refresh");
            }
        });
    }
    </script>
</body>

</html>
