<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/27/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE</title>
</head>
<body>
<h1>Delete</h1>
<a href="/">Back to menu</a>
<form>
    <label>Name</label>
    <p value="${requestScope["product"].getName()}"></p>
    <label>Description</label>
    <p value="${requestScope["product"].getDescription()}"></p>
    <label>Price</label>
    <p value="${requestScope["product"].getPrice()}"></p>
    <p>Do you want to delete</p>
    <button>Yes</button>
</form>
<a href="/">No</a>
</body>
</html>
