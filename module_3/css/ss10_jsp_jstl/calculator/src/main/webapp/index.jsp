<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>

<form action="${pageContext.request.contextPath}/calculate" method="post">
    <label>First operand:</label>
    <input type="text" name="firstOperand" required><br><br>

    <label>Operator:</label>
    <select name="operator">
        <option value="addition">Addition (+)</option>
        <option value="subtraction">Subtraction (-)</option>
        <option value="multiplication">Multiplication (*)</option>
        <option value="division">Division (/)</option>
    </select><br><br>

    <label>Second operand:</label>
    <input type="text" name="secondOperand" required><br><br>

    <button type="submit">Calculate</button>
</form>

</body>
</html>