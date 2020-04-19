<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <p>Above and below are included fragments</p>
    </br>
    <p>(From request params) Hello, <%= request.getParameter("name")%></p>
    <p>(From request params) Here will be null: <%= request.getParameter("nullName")%></p>

    <jsp:include page="footer.jsp" />
</body>
</html>
