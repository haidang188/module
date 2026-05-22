<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 5/22/2026
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
  <input type="number" name="firstNumber">
  <input type="number" name="secondNumber">

  <button type="submit" name="operator" value="+">Addition(+)</button>
  <button type="submit" name="operator" value="-">Subtraction(-)</button>
  <button type="submit" name="operator" value="*">Multiplication(*)</button>
  <button type="submit" name="operator" value="/">Division(/)</button>

  <h2>
    Result ${operator} : ${result}
  </h2>
</form>
</body>
</html>
