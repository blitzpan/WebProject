<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html>
<head>
  <title>首页</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
  <link rel="stylesheet" href="/junxun/css/mainStyle.css">  
  <script src="/junxun/js/jquery-2.1.4.js"></script>
  <script src="/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <script src="/junxun/js/index.js"></script>
  <style>
  </style>
  <script>
  </script>
</head>
<body>
<div class="container">
	<div class="row" id="logoDiv"></div>
	<div id="navDiv">
		<jsp:include page="./public/navPage.jsp"></jsp:include>
	</div>
	<div class="row">
		<div class="col-lg-8" id="centerDiv">
			<jsp:include page="/article/getAllArticle/xunlian.action"></jsp:include>
		</div>
		<div class="col-lg-4">
			<div id="weiboDiv"></div>
			<div id="recentDiv"></div>
			<div id="articleFamilyDiv"></div>
			<div id="monthDiv"></div>
			<div id="linkDiv"></div>
		</div>
	</div>
	<div class="row" id="footDiv"></div>
</div>
</body>
</html>
