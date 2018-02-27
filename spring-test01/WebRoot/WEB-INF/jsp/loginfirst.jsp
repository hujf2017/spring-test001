<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% 
   String sessionValues=(String)request.getSession().getAttribute("id");  
   String pk = request.getParameter("PK");
%>

<jsp:useBean id="command" class="com.ktao.controller.Material" scope="request" ></jsp:useBean>


<html>

<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>登录成功</h2>

    <table>
		 <tr>
            <td>
               	<a href="http://localhost:8080/spring-test01/in">进</a>
            </td>       
        </tr>
    </table>

  
    <table>
		 <tr>
            <td> 
            	<a href="http://localhost:8080/spring-test01/out">销</a>
            </td>               
        </tr>
    </table>


    <table>
		 <tr>
            <td> 
            	<a href="http://localhost:8080/spring-test01/has">存</a>
            </td>               
        </tr>
    </table>
    
    <table>
		 <tr>
            <td> 
            	<a href="http://localhost:8080/spring-test01/addmaterial">物料维护</a>
            </td>               
        </tr>
    </table>

		</body>
</html>