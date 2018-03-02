<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="command" class="com.ktao.controller.Material" scope="request" ></jsp:useBean>

<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="InAction">
    <table>
            <tr>
            <td><form:label path="code">物料编码：</form:label></td>
            <td><form:input path="code" /></td>
        </tr>
        <tr>
            <td><form:label path="name">物料名：</form:label></td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><form:label path="num">数量：</form:label></td>
            <td><form:input path="num" /></td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
 <form:form method="POST" action="In1Action">
    <table>
   
        <tr>
            <td colspan="2">

                <input type="submit" value="入库单查询"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>