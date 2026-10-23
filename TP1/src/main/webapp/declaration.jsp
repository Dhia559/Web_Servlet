<%--
  Created by IntelliJ IDEA.
  User: bouaz
  Date: 23/10/2026
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Declaration</title>
</head>
<body>

    <%!
        private int numEntries = 10;

        private int randomInt(int range) {
            return 1 + ((int)(Math.random() * range));
        }
    %>

    <h1>A random list from 1 to 100:</h1>

    <ul>
        <%
            for (int i = 0; i < numEntries; i++) {
                out.println("<li>" + randomInt(100) + "</li>");
            }
        %>
    </ul>

</body>
</html>
