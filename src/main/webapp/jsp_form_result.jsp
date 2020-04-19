<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>
<jsp:include page="header.jsp" />

<p>Name: <%= request.getParameter("username") %></p>
<p>Country: <%= request.getParameter("country") %></p>
<p>Gender: <%= request.getParameter("gender") %></p>
<h4>Selected courses</h4>
<ul>
    <%
        String[] courses = request.getParameterValues("courses");
        for(String course: courses){
            out.println("<li>" + course + "</li>");
        }
    %>
</ul>
<jsp:include page="footer.jsp" />
</body>
</html>