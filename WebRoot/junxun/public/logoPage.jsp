<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.junxun.entity.Res,com.common.entity.User" %>
<style>
</style> 
<div class="col-lg-8">
	<div class="header-logo">
		<img class="img-responsive" src="../junxun/image/logo.PNG" alt="logo"/>
	</div>
	<div class="header-text">
		<h3><!--潘哥的博客--></h3>
		<h5><!--等我练出6块腹肌就去找--></h5>
	</div>
</div>
<div class="col-lg-4">

	<div class="thirdPart">
		<c:if test="${USERNAME!=null && USERNAME!='' }">
			您好，${USERNAME }
		</c:if>
		<c:if test="${USERNAME==null }">
			<a href="/junxun/login.jsp" target="_blank">你好，请登录！</a>
		</c:if>
		
<!-- 
		<a href="https://graph.qq.com/oauth2.0/authorize?response_type=token&client_id=101263686&redirect_uri=http://www.junxun.win/qq/qqLogin.action&scope=get_user_info" class="qq" title="使用微博帐号登录" rel="nofollow" data-no-instant=""></a>
		<a href="https://api.weibo.com/oauth2/authorize?client_id=4038195090&response_type=code&redirect_uri=http://www.junxun.win/weibo/weiboLogin.action" class="weibo" title="使用微博帐号登录" rel="nofollow" data-no-instant=""></a>
-->
	</div>
</div>