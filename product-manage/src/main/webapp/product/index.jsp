<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product management</title>
</head>
<body>
<h1>------- PRODUCT MANAGE -------</h1>
<a href="products?action=create">Create Student</a>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>PRICE</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>

    <c:forEach var="pd" items='${requestScope["productList"]}'>
        <tr>
            <td>${pd.id}</td>
            <td>${pd.name}</td>
            <td>${pd.description}</td>
            <td>${pd.price}</td>
            <td>
                <a href="products?action=edit&id=${pd.id}">Edit</a>
            </td>
            <td>
                <a href="products?action=delete&id=${pd.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>