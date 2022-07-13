<html>
<title>
    积分系统
</title>
<body>
<h1 style="text-align: center">欢迎登陆积分管理系统</h1>
<form name="index"  class="text-info" style="text-align: center">
    <h4 class="text-primary">查询页面</h4>
    姓名:<input type="text" name="username"><br/><br>

    <input type="submit" value="查询" formmethod="get" formaction="/query"><br><br>

    <#if msg??>
        <span class="c-red">${msg}</span>
    </#if>
</form>
</body>
</html>