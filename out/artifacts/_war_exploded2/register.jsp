<%--
  Created by IntelliJ IDEA.
  User: wzy
  Date: 2021/10/8
  Time: 7:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>�������԰�</title>
</head>
<body bgcolor="#E3E3E3">
<form action="RegisterServlet" method="post">
    <table>
        <caption>�û�ע��</caption>
        <tr><td>��¼����</td>
            <td><input type="text" name="username"/></td>
        </tr><tr><td>����:</td>
        <td><input type="password" name="pwd"/></td></tr>
    </table>
    <input type="submit" value="ע��"/>
    <input type="reset" value="����"/>
</form>

</body>
</html>
