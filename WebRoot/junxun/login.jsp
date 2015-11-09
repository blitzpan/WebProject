<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> 
<!DOCTYPE html>
<html>
<head>
  <title>军训登录</title>
  <meta charset="utf-8">
  <!-- 下面一段是微博的，不能删除 -->
  <meta property="wb:webmaster" content="56b79ea319c9f46b" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
  <link rel="stylesheet" href="/junxun/css/mainStyle.css">  
  <script src="/junxun/js/jquery-2.1.4.js"></script>
  <script src="/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <script src="./js/login.js"></script>
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
		</div>
		<div class="col-lg-1"></div>
		<div class="col-lg-4">
			<div class="panel panel-default">
			<div class="panel-body">
				<ul class="nav nav-tabs" id="loginTab">
					<li role="presentation"><a href="javascript:void(0);">注册</a></li>
					<li role="presentation" class="active"><a href="javascript:void(0);">登陆</a></li>
				</ul>
				<br/>
				<div id="registerDiv" class="hideDiv">
					<form id="registerForm">
						<div class="form-group">
						<input id="name" name="registerName" type="text" class="form-control" placeholder="请输入邮箱"/>
						</div>
						<div class="form-group">
						<input id="nickname" name="registerNickname" type="text" class="form-control" placeholder="请输入昵称"/>
						</div>
						<div class="form-group">
						<input id="pw1" name="registerPw1" type="password" class="form-control" placeholder="请输入密码">
						</div>
						<div class="form-group">
						<input id="pw2" name="registerPw2" type="password" class="form-control" placeholder="请再次输入密码">
						</div>
						<button class="btn btn-primary btn-block" type="button">注册</button>
					</form>
				</div>
				<div id="loginDiv" class="showDiv">
					<form id="loginForm">
						<div class="form-group">
						<input id="loginName" name="name" type="text" class="form-control" placeholder="请输入邮箱"/>
						</div>
						<div class="form-group">
						<input id="loginPw1" name="pw1" type="password" class="form-control" placeholder="请输入密码">
						</div>
						<div id="tipDiv" class="alert alert-danger hideDiv alertDivThin" role="alert">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							<span id="tipSpan">用户名不能为空</span>
						</div>
						<div class="form-group">
							<a class="miniFont" href="http://www.baidu.com" target="_blank">忘记密码</a>
						</div>
						<button id="loginBtn" class="btn btn-primary btn-block" type="button">登录</button>
					</form>
					<div class="thirdPart">
						<span class="floatToBlock">第三方帐号登录</span>
						<a href="https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=101263686&redirect_uri=http://www.junxun.win/qq/qqLogin.action&scope=get_user_info" class="qq" title="使用微博帐号登录" rel="nofollow" data-no-instant=""></a>
						<a href="https://api.weibo.com/oauth2/authorize?client_id=4038195090&response_type=code&redirect_uri=http://www.junxun.win/weibo/weiboLogin.action" class="weibo" title="使用微博帐号登录" rel="nofollow" data-no-instant=""></a>
					</div>
				</div>
			</div>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>
	<div class="row" id="footDiv">
		<jsp:include page="./public/footPage.jsp"/>
	</div>
</div>
<jsp:include page="./public/toolPage.jsp"></jsp:include>
</body>
</html>
