<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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

  </head>
  
  <body>
  	<h1>欢迎	${cookie['USERNAME'].value}</h1>
  	<s:a action="countryAction!preAdd">增加</s:a>
  	<form action="countryAction!queryByNameOrLanguage" method="post">
  		国家<input type="text" name="name"/>
  		语言<input type="text" name="language"/>
  		<input type="submit" value="查询"/>
  	</form>
    <table border="1">
    	<tr><td>国家</td><td>语言</td><td>操作</td></tr>
    	<s:iterator value="counList">
    		<tr>
    			<td><s:property value="name"/> </td>
  				<td><s:property value="language"/> </td>
  				<td><s:a href="countryAction!preUpdate?id=%{id}">修改</s:a>
  					<s:a href="countryAction!del?id=%{id}">删除</s:a>
				</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
