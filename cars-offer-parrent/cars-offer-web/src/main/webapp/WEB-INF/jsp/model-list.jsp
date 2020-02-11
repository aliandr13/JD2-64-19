<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Model List</title>
    <style>
        table {
            margin: auto;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>

<h3 align="center">Offers</h3>
<table border="1">
    <tr>
        <th>price $</th>
        <th>date</th>
        <th>VIN</th>
    </tr>
    <c:forEach items="${modelList}" var="model">
        <tr>
            <td><c:out value="${model.price}"/></td>
            <td><c:out value="${model.date}"/></td>
            <td><c:out value="${model.VIN}"/></td>
            <td><input type="button" name="userName" value="заказать"/></td>
        </tr>
    </c:forEach>
</table>

<form method="POST" action="${pageContext.request.contextPath}/Car-list">

</form>


</body>
</html>