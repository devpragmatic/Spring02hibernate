<%--
  Created by IntelliJ IDEA.
  User: NB42RP
  Date: 2019-06-22
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<%--<form method="POST">--%>
<%--    Login: <input type="text" name="login"><br>--%>
<%--    Password: <input type="password" name="password"><br>--%>
<%--    Email: <input type="text" name="email"><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>
    <form:form method="POST" modelAttribute="student">
        First name: <form:input path="firstName"/><br>
        Last name: <form:input path="lastName"/><br>
        <p>Gender: </p>
        <form:radiobuttons path="gender" items="${gender}"/><br>
        Country: <form:select path="country" items="${countries}"/><br>
        Notes:  <form:textarea  path="notes"/><br>
        <form:checkbox label="mailing list" path="mailingList"/><br>
        ProgrammingSkills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/><br>
        Hobbies: <form:checkboxes  path="hobbies" items="${hobbies}"/><br>

        <input type="submit" value="Save">
    </form:form>
</body>
</html>
