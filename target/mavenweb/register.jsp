<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/12
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP starting page</title>
</head>
<body>
<form action="RegisterServlet" method="post" style="padding-top:-700px;">
    输入姓名:<input name="name" type="text"><br><br>
    输入密码:<input name="pwd" type="password"><br><br>
    输入id:<input name="id" type="text"><br><br>

    <input type="reset" value="重置"><input type="submit" value="注册">
</form>
</body>
</html>
