<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int square(int n){
        return n * n;
    }
%>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>
<p><%= square(6) %></p>
        <%
            for(int i = 1; i <= 5; i++){
                out.println("<li>" + square(i) + "</li>");
            }
        %>
    </br>
    <a href="jsp_directive.jsp">DIRECTIVES</a>

</body>
</html>
