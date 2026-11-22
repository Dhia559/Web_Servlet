<%--
  Created by IntelliJ IDEA.
  User: bouaz
  Date: 23/10/2026
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>
    <h1>JSP Scriptlet</h1>

    <%
        Date currentDate = new Date();
        String remoteHost = request.getRemoteHost();
    %>

    <p>Current time: <%= currentDate %></p>
    <p>Server's remote host: <%= remoteHost %></p>
</body>
</html>
