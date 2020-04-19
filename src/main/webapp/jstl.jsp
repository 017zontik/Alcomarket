<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>

<%--<p>With Expression</p>--%>
<%--<p><%= request.getAttribute("message2") %></p>--%>

    <p>With JSTL</p>
    <p><c:out value="${message2}" default="Hello world" /></p>

    <c:if test="${namesVisible == true}">
        <p>Names are Visible</p>
        <ul>
            <c:forEach var="name" items="${names}">
                <li><c:out value="${name}" /></li>
            </c:forEach>
        </ul>
    </c:if>

    <c:choose>
        <c:when test="${names[0] == 'Name 1'}">
            <p>name is: "Name 1"</p>
        </c:when>
        <c:when test="${names[1] == 'Name 1'}">
            <p>second name is: "Name 2"</p>
        </c:when>
        <c:otherwise>
            <p>name is: Undefined</p>
        </c:otherwise>
    </c:choose>


</body>
</html>
