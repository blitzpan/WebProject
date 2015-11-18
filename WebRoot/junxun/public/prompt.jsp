<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%@ page import="java.util.*,com.junxun.entity.Res" %>
<head>
<title>提示</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path %>/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
<link rel="stylesheet" href="<%=path %>/junxun/css/mainStyle.css">  
<script src="<%=path %>/junxun/js/jquery-2.1.4.js"></script>
<script src="<%=path %>/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
</script>
</head>
<body>
<div class="container">
	<div class="row" id="logoDiv">
		<jsp:include page="../public/logoPage.jsp"></jsp:include>
	</div>
	<div id="navDiv">
		<jsp:include page="../public/navPage.jsp"></jsp:include>
	</div>
	<div class="row">
		<div class="col-lg-8">
			<c:if test="${res.state=='1' }">
				<div class="alert alert-success" role="alert">${res.info }</div>
			</c:if>
			<c:if test="${res.state!='1' }">
				<div class="alert alert-danger" role="alert">${res.info }</div>
			</c:if>
			<c:if test="${nextPage!='' }">
				<p><a href="${nextPage }" class="btn btn-primary" role="button">${nextPageBtn }</a></p>
			</c:if>
		</div>
	</div>
	<div class="row" id="footDiv">
		<jsp:include page="../public/footPage.jsp"></jsp:include>
	</div>
</div>
</body>
</html>