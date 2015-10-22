<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%String path = request.getContextPath();%>
<head>
<title>新增文章</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path %>/junxun/bootstrap-3.3.5-dist/css/bootstrap.min.css">  
<link rel="stylesheet" href="<%=path %>/junxun/css/mainStyle.css">  
<script src="<%=path %>/junxun/js/jquery-2.1.4.js"></script>
<script src="<%=path %>/junxun/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/uedit/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/uedit/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/uedit/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/article/js/addArticle.js"></script>
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
		<div class="col-lg-8" id="formDiv">
			<form id="addForm" class="form-horizontal" action="./addArticle.action" method="post">
				<input id="content" name="content" type="hidden" />
				<input id="uid" name="uid" type="hidden" value="12356"/>
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">标题：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" name="title" placeholder="标题">
					</div>
				</div>
				<div class="form-group">
					<label for="type" class="col-sm-2 control-label">分类：</label>
					<div class="col-sm-10">
						<select class="form-control" id="type" name="type">
							<option value="xunlian">训练</option>
							<option value="neiwu">内务</option>
							<option value="jiaoyu">教育</option>
							<option value="yinshi">饮食</option>
							<option value="fushi">服饰</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<script id="editor" type="text/plain" class="col-sm-12" style="height:500px"></script>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-1">
						<button id="save" type="button" class="btn btn-default">保存</button>
					</div>
					<div class="col-sm-offset-1 col-sm-8">
						<button id="reset" type="button" class="btn btn-danger">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row" id="footDiv">
		<jsp:include page="../public/footPage.jsp"></jsp:include>
	</div>
</div>
</body>
</html>