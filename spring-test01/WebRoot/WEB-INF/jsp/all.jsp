<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ktao.controller.Material" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>注册成功 </h2>
<table>
		
       <tr><td>编码</td><td>名称</td><td>数量</td></tr>
        <% 
		List<List> list=(List)request.getAttribute("list");
		int j=0;
		for(int i=0;i<list.size();i++){	
			  			
			out.println("<td>"+list.get(i)+"</td>");
			j++;
			if(j==3){
			j=0;
			out.println("<tr></tr>");
			}
			}				
			
		%>

    
	</table>
 </body>
</html>