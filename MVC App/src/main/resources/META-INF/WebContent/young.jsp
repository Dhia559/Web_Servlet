<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="person"
             type="lab.mvc.model.PersonBean"
             scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Young Person</title>
</head>
<body>

    <h2>Young Person Information</h2>

    First Name:
    <jsp:getProperty name="person" property="firstName"/><br>

    Last Name:
    <jsp:getProperty name="person" property="lastName"/><br>

    Birthday:
    <jsp:getProperty name="person" property="birthDay"/><br>

    Sex:
    <jsp:getProperty name="person" property="sex"/><br>

</body>
</html>