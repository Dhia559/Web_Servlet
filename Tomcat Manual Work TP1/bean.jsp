 
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="personBean"
             class="isep.lab1.bean.PersonBean"
             scope="request"/>

<jsp:setProperty property="*" name="personBean"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Person Information</title>
</head>
<body>
    <h2>Person Information</h2>

    First Name: <jsp:getProperty property="firstName" name="personBean"/><br>
    Last Name: <jsp:getProperty property="lastName" name="personBean"/><br>
    Birthday: <jsp:getProperty property="birthDay" name="personBean"/><br>
    Sex: <jsp:getProperty property="sex" name="personBean"/><br>
</body>
</html>
