<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/17/2026
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Create Category</title>
</head>
<body>

<h2>Thêm Category</h2>

<form action="${pageContext.request.contextPath}/categories?action=create" method="post">

    Tên category:
    <input type="text" name="name"/>

    <br><br>

    <button type="submit">Create</button>

</form>

<br>
<a href="${pageContext.request.contextPath}/categories">⬅ Quay lại</a>

</body>
</html>
