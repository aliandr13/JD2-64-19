%@include file="../include/header.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/student-add">
    <table>
        <tr>
            <td><label>First Name</label></td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td><label>Middle Name</label></td>
            <td><input type="text" name="middleName"/></td>
        </tr>
        <tr>
            <td><label>Last Name</label></td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td><label>Phone</label></td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td><label for="car">Course</label></td>
            <td>
                <select id="car" name="carId">
                    <c:forEach var="car" items="${cars}">
                        <option value="${car.id}"
                                <c:if test="${carSelected == car.id}">selected='selected'</c:if>  >${course.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
<%@include file="../include/footer.jsp" %>