<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%String path = request.getContextPath();%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>${res.res.title}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path %>/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
<link rel="stylesheet" href="<%=path %>/junxun/css/mainStyle.css">  
<script src="<%=path %>/junxun/js/jquery-2.1.4.js"></script>
<script src="<%=path %>/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="<%=path %>/junxun/bootstrap-3.3.5-dist/js/jquery.bootstrap.min.js"></script>

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
			<div class="panel panel-default">
			<div class="panel-body">
				<h4 class="articleTitle">
					${res.res.title}
				</h4>
				<div class="articleOther">
				 other
				</div>
				<div class="content">
					${res.res.content }
				</div>
				
			</div>
			</div>
		</div>
	</div>
	<div class="row" id="footDiv">
		<jsp:include page="../public/footPage.jsp"></jsp:include>
	</div>
</div>
</body>
</html>