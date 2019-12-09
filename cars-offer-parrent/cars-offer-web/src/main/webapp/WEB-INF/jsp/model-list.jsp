<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>

<table>
    <tr>
        <td>Id</td>
        <td>carModel</td>
        <td>priceForHour</td>
        <td>color</td>
        <td>engine</td>
        <td>year</td>
    </tr>
    <c:forEach items="${modelList}" var="product">
        <tr>
            <td><c:out value="${model.id}"/></td>
            <td><c:out value="${model.carModel}"/></td>
            <td><c:out value="${model.priceForHour}"/></td>
            <td><c:out value="${model.color}"/></td>
            <td><c:out value="${model.engine}"/></td>
            <td><c:out value="${model.year}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>