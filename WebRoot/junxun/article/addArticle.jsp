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
		<div class="col-lg-8" id="formDiv">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">标题：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" placeholder="标题">
					</div>
				</div>
				<div class="form-group">
					<label for="type" class="col-sm-2 control-label">分类：</label>
					<div class="col-sm-10">
						<select class="form-control" id="type">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
				</div>
				
				
				
				
				
				
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
		
		
			
		</div>
	</div>
	<div class="row" id="footDiv"></div>
</div>
</body>
</html>
