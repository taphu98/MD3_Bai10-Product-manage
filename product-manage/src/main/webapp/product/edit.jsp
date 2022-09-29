<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/27/2022
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form Edit</h1>
<a href="/">Back to menu</a>
<c:if test='${requestScope["message"]!= null}'>
    <span style="color: blue">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Name</label>
    <input type="text" name="name" value='${requestScope["productList"].getName}'>
    <label>Description</label>
    <input type="text" name="description" value='${requestScope["productList"].getDescription}'>
    <label>Price</label>
    <input type="text" name="price" value='${requestScope["productList"].getPrice}'>
    <button>Edit</button>
</form>
</body>
</html>
