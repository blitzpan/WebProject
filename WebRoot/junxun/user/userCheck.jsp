<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> 
<!DOCTYPE html>
<html>
<head>
  <title>帐号激活</title>
  <meta charset="utf-8">
  <meta property="qc:admins" content="146012410162560566716" />
  <!-- 下面一段是微博的，不能删除 -->
	<meta property="wb:webmaster" content="56b79ea319c9f46b" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
  <link rel="stylesheet" href="/junxun/css/mainStyle.css">  
  <script src="/junxun/js/jquery-2.1.4.js"></script>
  <script src="/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <script src="/junxun/user/js/userCheck.js"></script>
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
		<div class="col-lg-6">
			<div class="panel panel-default">
			<div class="panel-body">
				<mark>${res.res.nickName }</mark>&nbsp;&nbsp;您好：<br />
				接下来将向您的邮箱<mark>${res.res.name }</mark>发送激活邮件，请注意查收。<br/>
				<button id="activation" type="button" class="btn btn-primary">发送激活邮件</button>
				<span id="timeC"></span>
			</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
		<div class="col-lg-4">
			<div class="panel_ panel-default">
			<div class="panel-body_">
			</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
	<div class="row" id="footDiv">
		<jsp:include page="/junxun/public/footPage.jsp"/>
	</div>
</div>
<jsp:include page="/junxun/public/toolPage.jsp"></jsp:include>
</body>
</html>