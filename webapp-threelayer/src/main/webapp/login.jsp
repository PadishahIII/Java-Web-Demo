<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
    <h1>登录页面</h1>
    <form action="/webapp-threelayer/login" method="post">
        <label for="username">用户名：</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">密码：</label>
        <input type="password" id="password" name="password"><br><br>
        <button type="submit">登录</button>
        <% Object status = request.getAttribute("status"); %>

        <% if (status != null && (boolean)status == false) { %>
        <p style="color:red;">用户名或密码错误</p>
        <% } %>

    </form>
</body>
</html>