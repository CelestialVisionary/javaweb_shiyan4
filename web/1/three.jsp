<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>感谢您的参与！你提交的信息如下：</h3>
<hr>
<%
    request.setCharacterEncoding("utf-8");
    out.print("你最想去的旅游胜地："+session.getAttribute("trap")+"<br>");
    out.print("你最喜欢的一本书："+request.getParameter("book"));
%>

</body>
</html>

