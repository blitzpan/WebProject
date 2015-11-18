<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> 
<!DOCTYPE html>
<html>
<head>
  <title>帐号校验结果</title>
  <meta charset="utf-8">
  <meta property="qc:admins" content="1460124101625605667167256056" />
  <!-- 下面一段是微博的，不能删除 -->
  <meta property="wb:webmaster" content="56b79ea319c9f46b" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="refresh" content="3;url=/index.jsp"/>
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
	<h3>提示</h3>
	<p>${res.info }</p>
	<p>3s后自动跳转首页。<a class="btn btn-primary btn-lg" href="/index.jsp" role="button">立即跳转</a></p>
</div>
</div>
</body>
</html>