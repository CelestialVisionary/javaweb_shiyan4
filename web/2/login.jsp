<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="login.jsp">登录</a>
<a href="show.jsp">看图</a>
<a href="exit.jsp">退出</a>
<br>
<p>输入名字就算登录了:</p>
<form action="login.jsp" method="post" name="login">
    <input type="text" name="username">
    <input type="submit" value="提交">
</form>
<%
    String username = request.getParameter("username");
    if(username==null||username.length()==0) {
        username="";
    }else{
        session.setAttribute("username",username); //将名字存入用户的session中
    }
%>
</body>
</html>
