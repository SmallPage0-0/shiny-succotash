<%--
  Created by IntelliJ IDEA.
  User: wzy
  Date: 2021/10/8
  Time: 7:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<form action="RegisterServlet" method="post">
    <table>
        <caption>用户注册</caption>
        <tr><td>登录名：</td>
            <td><input type="text" name="username"/></td>
        </tr><tr><td>密码:</td>
        <td><input type="password" name="pwd"/></td></tr>
    </table>
    <input type="submit" value="注册"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
