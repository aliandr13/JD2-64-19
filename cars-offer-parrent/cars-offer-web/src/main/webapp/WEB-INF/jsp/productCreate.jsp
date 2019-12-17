<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/productCreate">

    <label> CarModel: <input type="text" name="carModel"/> </label>
    <br>
    <label> Price: <input type="number" name="price"/> </label>
    <br>
    <label> Color: <input type="text" name="color"/> </label>
    <br>
    <label> Engine: <input type="text" name="engine"/> </label>
    <br>
    <label> Year: <input type="number" name="year"/> </label>
    <br>
    <input type="submit">
</form>
</body>
</html>