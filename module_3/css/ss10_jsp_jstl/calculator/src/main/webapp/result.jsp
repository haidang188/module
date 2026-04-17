<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/17/2026
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Result</title>
</head>
<body>

<h2>Result:</h2>

<%
  String error = (String) request.getAttribute("error");

  if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
} else {
  double first = (double) request.getAttribute("firstOperand");
  double second = (double) request.getAttribute("secondOperand");
  double result = (double) request.getAttribute("result");
  String operator = (String) request.getAttribute("operator");

  String opSymbol = "";
  switch (operator) {
    case "addition": opSymbol = "+"; break;
    case "subtraction": opSymbol = "-"; break;
    case "multiplication": opSymbol = "*"; break;
    case "division": opSymbol = "/"; break;
  }
%>
<p><%= first %> <%= opSymbol %> <%= second %> = <%= result %></p>
<%
  }
%>

</body>
</html>
