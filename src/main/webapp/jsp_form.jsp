<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2 example</title>
</head>
<body>
<jsp:include page="header.jsp" />

<form action="jsp_form_result.jsp" method="POST">
    Name:
    <input name="username" />
    <br><br>
    Gender:
    <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country:
    <select name="country">
        <option>Belarus</option>
        <option>Turkey</option>
        <option>China</option>
        <option>Germany</option>
    </select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked />Java SE
    <input type="checkbox" name="courses" value="JavaFX" checked />Java FX
    <input type="checkbox" name="courses" value="JavaEE" checked />Java EE
    <br><br>
    <input type="submit" value="Submit" />
</form>

<jsp:include page="footer.jsp" />
</body>
</html>
