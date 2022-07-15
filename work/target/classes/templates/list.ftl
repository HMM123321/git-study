<html>
<title>
    用户信息
</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<table class="table table-bordered">
    <caption>用户信息</caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>积分</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <#if userList?? && (userList?size > 0)>
        <#list userList as row>
            <tr>
                <th scope="row">${row.id}</th>
                <td>${row.username}</td>
                <td>${row.password}</td>
                <td>${(row.number)!" "}</td>


                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#infoModel"
                            data-id="alterCommit" data-param='{"id":"${row.id}",
                                "username":"${row.username}","password":"${row.password}"}'>修改
                    </button>
                    <#if username == "admin">
                        <button class="btn btn-danger" onclick="saveRow(${row.id})">新增</button>
                    </#if>
                    <#if username == "admin">
                        <button class="btn btn-danger" onclick="deleteRow(${row.id})">删除</button>
                    </#if>
                </td>
            </tr>
        </#list>

    <#else>
        <p>${message}</p>
    </#if>
    </tbody>
</table>
<button style="clear:both;right: auto" id="quit">退出</button>

<script>
    deleteRow = function (rowId) {
        if (rowId === 1) {
            alert("管理员用户不可删除")
        } else
            $.ajax({
                url: "/user/delete",
                data: {"id": rowId},
                type: 'get',
                success: function (data) {
                    window.location.reload();
                    console.log(data)
                    alert("删除成功");
                },
                error: function (data) {
                    window.location.reload();
                    alert("删除失败");
                }
            });
    }
    saveRow = function (rowId) {
        if (rowId === 1) {
            alert("管理员用户不可删除")
        } else
            $.ajax({
                url: "/user/save",
                data: {"id": rowId},
                type: 'post',
                success: function (data) {
                    window.location.reload();
                    console.log(data)
                    alert("新增成功");
                },
                error: function (data) {
                    window.location.reload();
                    alert("新增失败");
                }
            });
    }
    $("#quit").click(function () {
        $(location).attr('href', '/user/logout');
    });
</script>
</body>
</html>