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
        Last name: <form:input label="Last name:" path="lastName"/><br>
        <p>Gender: </p>
        <form:radiobutton path="gender" value="F" label="Female"/>
        <form:radiobutton path="gender" value="M" label="Male"/><br>
        Country: <form:select label="country" path="country" items="${countries}"/><br>
        Notes:  <form:textarea label="notes"  path="notes"/><br>
        <form:checkbox label="mailing list" path="mailingList"/><br>
        ProgrammingSkills: <form:select label="programmingSkills" path="programmingSkills" items="${programmingSkills}" multiple="true"/><br>
        Hobbies: <form:checkboxes  label="hobbies" path="hobbies" items="${hobbies}"/><br>

        <input type="submit" value="Save">
    </form:form>
</body>
</html>
