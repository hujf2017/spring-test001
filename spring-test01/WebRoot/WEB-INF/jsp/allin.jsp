<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allin.jsp' starting page</title>
    
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
