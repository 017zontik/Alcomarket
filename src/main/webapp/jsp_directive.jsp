<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.kashanok.ClassWithLogic" %>
<% String name = "Raman"; %> //

<%
    ClassWithLogic myClass = new ClassWithLogic();
%>

<html>
<head>
    <title>Page 2 example</title>
</head>
<body>
    <h2><%= myClass.makeAction(name) %></h2>
    </br>
    </br>
    <a href="jsp_include.jsp">JSP INCLUSION</a>
</body>
</html>
