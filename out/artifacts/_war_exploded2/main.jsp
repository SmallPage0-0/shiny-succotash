<%--
  Created by IntelliJ IDEA.
  User: wzy
  Date: 2021/10/6
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="gb2312"%>
<%@page import="model.LyTable" %>
<%@page import="db.DB" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    <title>���԰���Ϣ</title>
</head>
<body>
<form action="liuyan.jsp" method="post">
    <table border="1">
        <caption> ����������Ϣ</caption>
        <tr>
            <th>����������</th><th>����ʱ��</th>
            <th>���Ա���</th><th>��������</th>
        </tr>
        <%
            ArrayList al=(ArrayList)session.getAttribute("al");
            Iterator iter =al.iterator();
            while(iter.hasNext()){
                LyTable ly=(LyTable)iter.next();
        %>
        <tr><td> <%= new DB().getUserName(ly.getUserId())  %> </td>
            <td> <%=ly.getDate().toString()%> </td>
            <td> <%=ly.getTitle()%> </td>
            <td> <%=ly.getContent()%> </td>
        </tr>
        <%
            }
        %>
    </table>
    <input type="submit" value="����"/>
</form>
</body>
</html>
