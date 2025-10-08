<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>问题二</h3>
<hr>
<form action="three.jsp" method="post" name="one">
    你最喜欢的一本书：<input type="text" name="book">
    <input type="submit" value="提交">
</form>
<%
    request.setCharacterEncoding("utf-8");
    session.setAttribute("trap",request.getParameter("trap"));
%>

</body>
</html>
