<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="command" class="com.ktao.controller.Material" scope="request" ></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'out.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
							  
   <form:form method="POST" action="OutAction">
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

 <form:form method="POST" action="Out1Action">
    <table>

       
        <tr>
            <td colspan="2">

                <input type="submit" value="出库单查询"/>
            </td>
        </tr>
    </table>
</form:form>
  </body>
</html>
