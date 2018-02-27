<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="command" class="com.ktao.controller.Material" scope="request" ></jsp:useBean>

<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>Student Information</h2>
需要查询的物料，如果不选就是全部
<form:form method="POST" action="HasAction">
    <table>
            <tr>
            <td><form:label path="code">物料编码：</form:label></td>
            <td><form:input path="code" /></td>
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