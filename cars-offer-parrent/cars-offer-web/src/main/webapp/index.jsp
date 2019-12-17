<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>

<html>
<body>
<jsp:include page="WEB-INF/include/header.jsp" />
<%@ include file="WEB-INF/include/menu.jsp" %>

<h2>Main Page!</h2>
<p> Page bode </p>

<ul>
    <li><a href="./model-list">Product List</a></li>
    <li><a href="./productCreate">Create new Product</a></li>
</ul>

<jsp:include page="WEB-INF/include/footer.jsp" />

</body>
</html>

