<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="login.jsp">登录</a>
<a href="show.jsp">看图</a>
<a href="exit.jsp">退出</a>
<%
    session.invalidate();
    out.print("session会话失效，若想看图请重新登录！");
%>
</body>
</html>
