<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table {
			width: 500px;
		}
		.t1 td{
			width: 50%;
		}
	</style>
	<script type="text/javascript" src="<c:url value='/js/common/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/user/user.js'/>"></script>
  </head>
  
  <body>
  	<h1 align="center">当前用户列表</h1>
    <table id="t1" align="center" border="1">
    	<tr>
    		<td>ID</td>
    		<td>姓名</td>
    		<td>密码</td>
    	</tr>
    	<c:forEach items="${list }" var="list">
    	<tr>
    		<td>${list.id }</td>
    		<td>${list.name }</td>
    		<td>${list.pwd }</td>
    	</tr>
    	</c:forEach>
    </table>
    <table align="center">
    	<tr>
    		<td>
    		<input type="hidden" value='${pageSize }'/>
    			当前显示条数<select>
    				<option value="2">2</option>
    				<option value="3">3</option>
    				<option value="4">4</option>
    				<option value="5">5</option>
    			</select>
    			<button id="first">首页</button>
    			<button id="previous">上一页</button>
    			<span id="current">1</span>/
    			<span id="pages">${pageInfo.pages }</span>
    			<button id="next">下一页</button>
    			<button id="last">末页</button>
    		</td>
    	</tr>
    </table>
  </body>
</html>
