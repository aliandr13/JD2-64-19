<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: romankiturko
  Date: 2/25/20
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текущие заказы</title>
</head>
<body>
<form>
<table border="8">
    <tr>
        <th>mark</th>
        <th>model</th>
        <th>year</th>
        <th>price $</th>
        <th>name</th>
<%--        <th>telephone</th>--%>
<%--        <th>e-mail</th>--%>
<%--        <th>number of days</th>--%>
<%--        <th>wishes</th>--%>
    </tr>

    <c:forEach items="${AllOrders}" var="orders">
        <tr>
            <td><c:out value="${orders.name}"/></td>
            <td><c:out value="${orders.email}"/></td>
            <td><c:out value="${orders.phone}"/></td>
            <td><c:out value="${orders.numberOfDays}"/></td>
            <td><c:out value="${orders.wishes}"/></td>


        </tr>
    </c:forEach>
</table>
</form>

</body>
</html>
