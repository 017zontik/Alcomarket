<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] people = new String[]{"Tom", "Bob", "Sam"};
    String header = "Users list";
%>
<html>
<head>
    <title><%= header%></title>
</head>
<body>
    <%
        for(int i = 1; i < 5; i++){
            out.println("<br>Hello " + i);
        }
    %>
    </br>
    <ul>
        <%
            for(String person: people){
                out.println("<li>" + person + "</li>");
            }
        %>
    </ul>
    </br>
    <a href="jsp_declaration.jsp">NEXT EXAMPLE</a>

</body>
</html>
