<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Page title</title>
</head>
    <body>
        <br>
            <p>Name: ${name}</p>
            <p>Age: ${age}</p>

        </br>

    <form action="/user" method="post">
        Name: <input name="name" />
        <br><br>
        Age: <input name="age" type="number" min=1 />
        <br></br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
