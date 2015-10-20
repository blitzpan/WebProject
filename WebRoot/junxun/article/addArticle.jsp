<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%String path = request.getContextPath();%>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path %>/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
<link rel="stylesheet" href="<%=path %>/junxun/css/mainStyle.css">  
<script src="<%=path %>/junxun/js/jquery-2.1.4.js"></script>
<script src="<%=path %>/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#logoDiv").load("../junxun/public/logoPage.html");
	$("#navDiv").load("../junxun/public/navPage.html");
	$("#footDiv").load("../junxun/public/footPage.html");
});
</script>
</head>
<body>
<div class="container">
	<div class="row" id="logoDiv"></div>
	<div id="navDiv"></div>
	<div class="row">
		
	</div>
	<div class="row" id="footDiv"></div>
</div>
</body>
</html>
