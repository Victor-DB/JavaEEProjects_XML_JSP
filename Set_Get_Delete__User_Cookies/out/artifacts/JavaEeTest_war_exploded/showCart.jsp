<%@ page import="somePackage.Cart" %><%--
  Created by IntelliJ IDEA.
  User: 17876577
  Date: 2019-12-24
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>

<%--В этом .jsp файле получим доступ к сессии для пользователя--%>
<%--В этой сессии уже будет лежать объект класса Cart (мы его получим в сервлете)--%>
<%--Обратившись к сессии для пользователя мы сможем получить этот объект и представить его для пользователя--%>
<%--Для запуска приложения прописываем URL:   http://localhost:8080/test-servlet?name=Car&quantity=3000--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>

    <%@ page import="somePackage.Cart" %>

    <% Cart cart = (Cart) session.getAttribute("cart"); %>
    <p> Наименование: <%= cart.getName() %> </p>
    <p> Количество: <%= cart.getQuantity() %> </p>

</body>
</html>
