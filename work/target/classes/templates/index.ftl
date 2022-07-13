<html>
<title>
    登录成功
</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<body>
<div style="text-align: center;">
    <h1>welcome!</h1>
    <form>
        <input type="submit" formaction="/user/query" value="详情页面"><br>
    </form>
    ${msg!"请勿直接访问"}
</div>
<div style="clear:both;text-align:center;">
    当前用户名：${username}<br>
    <button id="logout">退出</button>
</div>
<script>
    $("#logout").click(function () {
        $(location).attr('href', '/user/logout');
    });
</script>
</body>
</html>