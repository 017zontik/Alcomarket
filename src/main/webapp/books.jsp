<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>

            <c:forEach var="book" items="${books}">
                <li><c:out value="${book.title}" /></li>
            </c:forEach>

            <form action="/books" method="POST">
                Title:
                <input name="title" />
                <br><br>
                Author:
                <input name="author" />
                <br><br>
                <input type="submit" value="Submit" />
            </form>

            <h1>You have selected: <%= request.getParameter("author")%></h1>

</body>
</html>
