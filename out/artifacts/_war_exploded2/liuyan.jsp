<%--
  Created by IntelliJ IDEA.
  User: wzy
  Date: 2021/10/6
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title>���԰�</title>
</head>
<body bgcolor="#E3E3E3">
<center>
    <form action="AddServlet" method="post">
        <table border="1">
            <caption>��д������Ϣ</caption>
            <tr><td>���Ա���</td>
                <td><input type="text" name="title"/></td>
            </tr><tr><td>��������</td>
            <td><textarea  name="content" rows="5" cols="35"></textarea></td></tr>
        </table>
        <input type="submit" value="����"/>
        <input type="reset" value="����"/>
    </form>
</center>

</body>
</html>
