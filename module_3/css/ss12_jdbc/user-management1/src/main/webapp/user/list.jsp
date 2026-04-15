<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/15/2026
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="${pageContext.request.contextPath}/users?action=create">Add New User</a>
  </h2>
</center>

<div align="center">
  <form method="get" action="${pageContext.request.contextPath}/users">
    <input type="hidden" name="action" value="search"/>
    <input type="text" name="country" placeholder="Search by country"/>
    <select name="order">
      <option value="">Sort by name</option>
      <option value="asc">A - Z</option>
      <option value="desc">Z - A</option>
    </select>
    <button type="submit">Apply</button>
  </form>
  <table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td>
          <a href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}">Edit</a>
          <a href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
