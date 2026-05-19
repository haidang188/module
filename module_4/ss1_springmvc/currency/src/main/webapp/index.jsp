<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>

<br>
<form action="/convert" method="post">
    Rate:
    <input type="text" name="rate"><br><br>

    USD:
    <input type="text" name="usd"><br><br>

    <button type="submit">Convert</button>
</form>
</body>
</html>