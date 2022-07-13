<html>
<head>
    <title>用户注册</title>
    <meta charset="UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<form name="register" action="/user/register" class="text-info" style="text-align: center">
    <h4 class="text-primary">注册页面</h4>
    姓名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="注册" formmethod="post">
    <input type="submit" value="登录" formaction="/user/login"><br>
    ${msg}
</form>
</body>
</html>