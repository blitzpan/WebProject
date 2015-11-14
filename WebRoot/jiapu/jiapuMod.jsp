<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>信息修改</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/jiapu/css/jiapu.css"/>
	<script src="/js/jquery-2.1.4.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/jquery.bootstrap.min.js"></script>
    <script language="javascript" type="text/javascript" src="/jiapu/js/jiapuMod.js"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=path %>/junxun/ueditor1_2_6_1/themes/default/css/ueditor.css"/>
	<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/ueditor1_2_6_1/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/ueditor1_2_6_1/ueditor.all.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="<%=path %>/junxun/ueditor1_2_6_1/lang/zh-cn/zh-cn.js"></script>
	<!-- my97DatePicker -->
    <script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
	<style>
	</style>
	<script>
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">基本信息</div>
				<div class="panel-body">
				<form id="basicForm" class="form-inline">
					<input id="id" name="id" type="hidden" value="${res.res.id }"/>
					<div class="form-group">
						<label for="name" class="control-label">姓名</label>
						<input id="name" name="name" type="text" class="form-control" value="${res.res.name}"/>
					</div>
					<div class="form-group">
						<label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;性别</label>
						<c:if test="${res.res.sex=='0' }">
							<label for="sex_m" class="checkbox-inline"><input type="radio" id="sex_m" name="sex" value="0" checked>男</input></label>
							<label for="sex_f" class="checkbox-inline"><input type="radio" id="sex_f" name="sex" value="1">女</input></label>
						</c:if>
						<c:if test="${res.res.sex=='1' }">
							<label for="sex_m" class="checkbox-inline"><input type="radio" id="sex_m" name="sex" value="0">男</input></label>
							<label for="sex_f" class="checkbox-inline"><input type="radio" id="sex_f" name="sex" value="1" checked>女</input></label>
						</c:if>
					</div>
					<div class="form-group">
						<label for="birth" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;生日</label>
						<input id="birth" name="birth" class="Wdate form-control" value="${res.res.birth}" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeHolder="出生日期（公历）"/>
					</div>
				</form>
				<br />
				<textarea id="summary" name="summary" class="form-control" rows="4" placeHolder="简介">${res.res.summary}</textarea>
				<br />
				<button id="basicSaveBtn" name="basicSaveBtn" type="button" class="btn btn-primary">保存基本信息</button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">详细介绍</div>
				<div class="panel-body_">
					<script id="editor" type="text/plain" style="height:500px">${res.res.des }</script>
					<br />
					<button style="margin-left:15px;margin-bottom:15px" id="descSaveBtn" name="descSaveBtn" type="button" class="btn btn-primary">保存详细信息</button>
				</div>
			</div>
		</div>
	</div>
</body>