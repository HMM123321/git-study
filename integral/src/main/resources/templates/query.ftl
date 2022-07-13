<html>

<title>
    查询页面
</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<body>
<div style="text-align: center">
    <h4>用户${username}的积分为：${number}</h4>
    <form>
        积分修改<input type="text" name="number"><br><br>
        <input type="submit" value="提交" formaction="/change"><br><br>
        <input type="button" value="返回查询页面" id="back">
    </form>
</div>
<script>
    $("#back").click(function (){
        $(location).attr('href', '/index');
    });
</script>
</body>
</html>