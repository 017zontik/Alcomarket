<%@ page contentType="text/html;charset=UTF-8" %>
<% String header = "TMS C_31 JSP"; %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>First JSP App</title>
    </head>
    <body>
        <h2><%= header %></h2>
        <p>Today <%= new java.util.Date() %> </p>
        </br>
        <a href="jsp_expression.jsp">NEXT EXAMPLE</a>
    </body>
</html>