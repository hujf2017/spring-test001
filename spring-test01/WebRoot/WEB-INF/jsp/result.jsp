<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>注册成功 </h2>
<table>
<% request.setCharacterEncoding("UTF-8") ;%>
	
    <tr>
        <td>编号：</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>名称：</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
</table>
</body>
</html>