<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>比赛列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">


</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>比赛人员管理与审核</h5>
                </div>
                <div class="ibox-content">
                    <hr>
                    <div class="row row-lg">
                        <div class="col-sm-12">
                            <!-- Example Card View -->
                            <div class="example-wrap">
                                <div class="example">
                                    <table id="table_list">
                                    </table>
                                </div>
                            </div>
                            <!-- End Example Card View -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

<!-- Bootstrap table -->
<script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${ctx!}/assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="${ctx!}/assets/js/plugins/peity/jquery.peity.min.js"></script>

<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        $("#table_list").bootstrapTable({
            //使用get请求到服务器获取数据
            method: "POST",
            //必须设置，不然request.getParameter获取不到请求参数
            contentType: "application/x-www-form-urlencoded",
            //获取数据的Servlet地址
            url: "${ctx!}/user/play/usercheck/list",
            //表格显示条纹
            striped: true,
            //启动分页
            pagination: true,
            //每页显示的记录数
            pageSize: 10,
            //当前第几页
            pageNumber: 1,
            //记录数可选列表
            pageList: [5, 10, 15, 20, 25],
            //是否启用查询
            search: true,
            //是否启用详细信息视图
            detailView:true,
            detailFormatter:detailFormatter,
            //表示服务端请求
            sidePagination: "server",
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "undefined",
            //json数据解析
            responseHandler: function(res) {
                var list = JSON.parse(res)
                console.log(list)
                return {
                    "rows": list,
                    "total": list.length
                };
            },
            //数据列
            columns: [{
                title: "ID",
                field: "id",
                sortable: true
            },{
                title: "比赛编号",
                field: "playid",
                sortable: true
            },{
                title: "参赛用户名",
                field: "username"
            },{
                title: "报名位置",
                field: "role"
            },{
                title: "用户生日",
                field: "birthday"
            },{
                title: "联系电话",
                field: "telephone"
            },{
                title: "邮箱",
                field: "email"
            },{
                title: "审核状态",
                field: "status"
            },{
                title: "操作",
                field: "empty",
                formatter: function (value, row, index) {
                    var operateHtml = '<@shiro.hasPermission name="user:play:check"><button class="btn btn-primary btn-xs" type="button" onclick="del(\''+row.id+'\',\''+row.playid+'\')"><i class="fa fa-edit"></i>&nbsp;此人审核不通过</button> &nbsp;</@shiro.hasPermission>';
                    operateHtml = operateHtml + '<@shiro.hasPermission name="user:play:check"><button class="btn btn-primary btn-xs" type="button" onclick="go(\''+row.id+'\')"><i class="fa fa-edit"></i>&nbsp;此人审核通过</button> &nbsp;</@shiro.hasPermission>';
                    return operateHtml;
                }
            }]
        });
    });
    function go(id){
        layer.confirm('确定此人通过?', {icon: 3, title:'提示'}, function(index){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "${ctx!}/user/play/go/" + id,
                success: function(msg){
                    layer.msg(msg.message, {time: 2000},function(){
                        $('#table_list').bootstrapTable("refresh",id);
                        //layer.close(index);
                        window.close()
                    });
                }
            });
        });
    }
    function edit(id){
        layer.open({
            type: 2,
            title: '用户修改',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/admin/play/edit/' + id,
            end: function(index){
                $('#table_list').bootstrapTable("refresh");
            }
        });
    }
    function add(){
        layer.open({
            type: 2,
            title: '场地添加',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/admin/play/add',
            end: function(index){
                $('#table_list').bootstrapTable("refresh");
            }
        });
    }
    function grant(id){
        layer.open({
            type: 2,
            title: '关联角色',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/admin/user/grant/'  + id,
            end: function(index){
                $('#table_list').bootstrapTable("refresh");
            }
        });
    }
    function del(id,playid){
        layer.confirm('确定此人不通过?', {icon: 3, title:'提示'}, function(index){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "${ctx!}/user/play/delete/" + id+"/"+playid,
                success: function(msg){
                    layer.msg(msg.message, {time: 2000},function(){
                        $('#table_list').bootstrapTable("refresh",id);
                        //layer.close(index);
                        window.close()
                    });
                }
            });
        });
    }
    function check(id){
        layer.open({
            type: 2,
            title: '审核人员',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/user/play/usercheck/'  + id,
            end: function(index){
                $('#table_list').bootstrapTable("refresh");
            }
        });
    }
    function detailFormatter(index, row) {
        var html = [];
        html.push('<p><b>描述:</b> ' + row.description + '</p>');
        return html.join('');
    }
</script>




</body>

</html>
