<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/hello" method="Get">
    Name
    <input name="username"/>
    <br><br>
    Age: <input name="userage"/>
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked/>Female
    <input type="radio" name="gender" value="male"/>Male
    <br><br>
    Country: <select name="country">
    <option>Canada</option>
    <option>Spain</option>
    <option>France</option>
    <option>Germany</option>
</select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked/>Java SE
    <input type="checkbox" name="courses" value="JavaFX" checked/>Java FX
    <input type="checkbox" name="courses" value="JavaEE" checked/>Java EE
    <br><br>
    <input type="submit" value="Submit"/>

</form>

</body>
</html>
