<%@ page contentType="text/html;charset=UTF-8" language="java"    pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
</head>
<body>
<form action="EnrollServlet" method="post">
    <h2>用户注册</h2><br>
    用 户 名：
    <input type="text" name="username"><br>
    密 码：<input type="password" name="password"><br>
    确认密码：<input type="password" name="password2"><br>
    性别：
    <select name="sex">
        <option value="M">男</option>
        <option value="F">女</option>
    </select><br>
    生 日：<input type="text" name="birthday"><br>
    爱 好：
    <input type="checkbox" name="hobby" value="play">运动
    <input type="checkbox" name="hobby" value="music">音乐
    <input type="checkbox" name="hobby" value="travel">旅游<br><br>
    <input type="submit" value="注册">
</form>

</body>
</html>
