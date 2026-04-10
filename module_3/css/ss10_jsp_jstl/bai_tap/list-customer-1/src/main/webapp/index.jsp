<%@ page import="com.example.listcustomer1.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <style>
        body {
            font-family: "Times New Roman";
            background: #f5f5f5;
        }

        h2 {
            text-align: center;
        }

        table {
            margin: auto;
            width: 80%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 0 10px #ccc;
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        img {
            width: 80px;
            height: 80px;
            object-fit: cover;
        }
    </style>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <%
        List<Customer> customersList = (List<Customer>) request.getAttribute("customersList");

        if (customersList != null) {
            for (Customer c : customersList) {
    %>
    <tr>
        <td><%= c.getName() %>
        </td>
        <td><%= c.getBirthday() %>
        </td>
        <td><%= c.getAddress() %>
        </td>
        <td>
            <img src="<%= c.getImage() %>" alt="avatar">
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>