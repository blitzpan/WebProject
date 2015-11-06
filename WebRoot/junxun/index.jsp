<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> 
<!DOCTYPE html>
<html>
<head>
  <title>军训</title>
  <meta charset="utf-8">
  <!-- 下面一段是微博的，不能删除 -->
  <meta property="wb:webmaster" content="56b79ea319c9f46b" />
  <!-- qq登录 -->
  <meta property="qc:admins" content="1460124101625605667167256056" />
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
	<div class="row" id="logoDiv">
		<jsp:include page="/junxun/public/logoPage.jsp"/>
	</div>
	<div id="navDiv">
		<jsp:include page="/junxun/public/navPage.jsp"/>
	</div>
	<div class="row">
		<div class="col-lg-8" id="centerDiv">
			<jsp:include page="/article/getAllArticle.action">
				<jsp:param value="index" name="menu"/>
			</jsp:include>
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
<jsp:include page="./public/toolPage.jsp"></jsp:include>
</body>
</html>
