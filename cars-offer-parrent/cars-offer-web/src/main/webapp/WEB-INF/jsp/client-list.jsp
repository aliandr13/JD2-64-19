<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="../include/header.jsp"/>
<%@include file="../include/menu.jsp" %>

<table class="table table-striped">
    <thead>
    <th>#</th>
    <th>Last Name</th>
    <th>First Name</th>
    <th>Phone</th>
    <th>Action</th>

    </thead>
    <tbody>
    <jsp:useBean id="clients" scope="request" type="java.util.List"/>
    <c:forEach var="client" items="${clients}">
        <tr>
            <th scope="row">${client.id}</th>
            <th>${client.lastName}</th>
            <th>${client.firstName}</th>
            <th>${client.phone}</th>
            <th>
                <a:auth path="/client-delete">
                    <a href="${delete_link}">Delete</a>
                </a:auth>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <c:url value="/client-add" var="add" scope="page"/>
    <a href="${add}">Add new Client</a>
</p>

<%@include file="../include/footer.jsp" %>