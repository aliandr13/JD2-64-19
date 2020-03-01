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

<form method="post" action="${pageContext.request.contextPath}/Car-order">
    <table border="1">
        <tr>
            <th>mark</th>
            <th>model</th>
            <th>year</th>
            <th>price $</th>
        </tr>
        <c:forEach items="${avaliableCars}" var="car">
            <tr>
                <td><c:out value="${car.model.mark.model}"/></td>
                <td><c:out value="${car.model.name}"/></td>
                <td><c:out value="${car.date}"/></td>
                <td><c:out value="${car.price}"/></td>

                <td><a href="${pageContext.request.contextPath}/Car-order?id=${car.id}">ЗАКАЗАТЬ</a></td>
            </tr>
        </c:forEach>
    </table>

</form>
</body>
</html>