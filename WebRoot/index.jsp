<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> 
<!DOCTYPE html>
<html>
<head>
  <title>导航</title>
  <meta charset="utf-8">
  <meta property="qc:admins" content="1460124101625605667167256056" />
  <!-- 下面一段是微博的，不能删除 -->
  <meta property="wb:webmaster" content="56b79ea319c9f46b" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
  <link rel="stylesheet" href="/junxun/css/mainStyle.css">  
  <script src="/junxun/js/jquery-2.1.4.js"></script>
  <script src="/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <style>
  </style>
  <script>
  </script>
</head>
<body>
<div class="container">
<div class="jumbotron">
	<table class="table table-bordered table-hover">
		<tr>
			<td width="20%" align="center"><a href="/junxun/index.jsp" target="_self">军训</a></td>
			<td width="80%" align="left">军训网站功能简介</td>
		</tr>
		<tr>
			<td width="20%" align="center"><a href="/jiapu/index.jsp" target="_self">家谱</a></td>
			<td width="80%" align="left">家谱网站功能简介</td>
		</tr>
		<tr>
			<td width="20%" align="center"><a href="/jiapu/index2.jsp" target="_self">家谱2</a></td>
			<td width="80%" align="left">家谱网站功能简介</td>
		</tr>
	</table>
</div>
</div>
</body>
</html>