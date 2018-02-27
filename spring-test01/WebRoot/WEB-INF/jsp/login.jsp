<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="command" class="com.ktao.controller.Student" scope="request" ></jsp:useBean>

<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>登录系统</h2>
<form:form method="POST" action="loginAction">
    <table>
            <tr>
            <td><form:label path="id">编码：</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><form:label path="password">密码：</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>