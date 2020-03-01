<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: romankiturko
  Date: 2/14/20
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление заявки</title>
</head>
<body>
<h3 align="center">ЗАЯВКА НА АРЕНДУ</h3>


<p style="color: red;">${errorString}</p>
<form name="input" method="post" action="${pageContext.request.contextPath}/Car-order">
    Ваше имя: <input type="text" name="Name" placeholder="Имя"/><br/>
    Ваш телефон: <input type="tel" name="MobileTelephone" placeholder="+375(33)8761009"/> <br/>
    E-mail: <input type="text" name="Email" placeholder="example@mail.ru"/> <br/>
    Количество дней: <input type="number" min="1" max="31" name="NumberOfDays" value="1"/> <br/>
    Пожелания:<textarea name="Wishes" value="" placeholder="Введите текс"></textarea> <br/>
    <input type="submit" value="Отправить"/>
</form>


</body>
</html>
