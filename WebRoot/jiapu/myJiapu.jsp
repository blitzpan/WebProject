<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<head>
	<title>我的家谱</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/jiapu/css/jiapu.css"/>
	<script src="/js/jquery-2.1.4.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/jquery.bootstrap.min.js"></script>
	<script src="/jiapu/js/myJiapu.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style>
	</style>
</head>
<body>
	<div class="container">
		<div id="logoDiv" class="row">
			<jsp:include page="/jiapu/public/logoPage.jsp"></jsp:include>
		</div>
		<div id="navDiv" class="row">
			<jsp:include page="/jiapu/public/navPage.jsp"></jsp:include>		
		</div>
		<div class="row">
			<div class="col-lg-8" id="centerDiv">
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" action="">
							<input type="hidden" name="id" id="id" value="${res.res.id }"/>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name">名称</label>
								<div class="col-sm-10"><input name="name" id="name" value="${res.res.name }" class="form-control" type="text" placeHolder="家谱名称（小于50字）"></div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="summary">简介</label>
								<div class="col-sm-10">
									<textarea name="summary" id="summary" rows="5" cols="" class="form-control" placeHolder="简介（小于1000字）">${res.res.summary }</textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">具体成员</label>
								<div class="col-sm-10">
									<button id="modBtn" type="button" class="btn btn-default">编辑</button>
								</div>
							</div>
							<div style="text-align:center">
								<button id="subBtn" type="button" class="btn btn-primary">确定</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-4" id="centerDiv">
			4
			</div>
		</div>
	</div>
	<div id="footPage">
		foot
	</div>
</body>
