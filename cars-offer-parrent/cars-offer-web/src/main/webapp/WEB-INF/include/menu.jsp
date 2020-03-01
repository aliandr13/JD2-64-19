<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>

<div style="padding: 5px;">

    <a href="${pageContext.request.contextPath}/">Home</a>
    |
    <a href="${pageContext.request.contextPath}/Orders">Orders</a>
    |
    <a href="${pageContext.request.contextPath}/info">My Account Info</a>
    |
    <a href="${pageContext.request.contextPath}/login">Login</a>
    |
    <AuthTag path>
    <a href="${pageContext.request.contextPath}/Car-list">Car-list</a>
    </AuthTag>

</div>