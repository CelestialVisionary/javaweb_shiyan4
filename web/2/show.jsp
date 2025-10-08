<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<a href="login.jsp">登录</a>
<a href="show.jsp">看图</a>
<a href="exit.jsp">退出</a>
<%
    request.setCharacterEncoding("UTF-8");
    String username=(String)session.getAttribute("username");
    if(username==null||username.length()== 0) {
        response.sendRedirect("login.jsp");
    }else{
%>
<br><img src="hua.jpg"/>
<%
    }
%>
</body>
</html>
