<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>详细信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/jiapu.css"/>
	<script src="/js/jquery-2.1.4.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/jquery.bootstrap.min.js"></script>
    <script language="javascript" type="text/javascript" src="./js/jiapuDetail.js"></script>
	<style>
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">基本信息</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<td align="right" width="100px">姓名：</td>
							<td width="250px">${res.res.name}</td>
							<td align="right" width="100px">性别：</td>
							<td width="250px">${res.res.sex eq '0'?"男":"女"}</td>
							<td align="right" width="100px">是否健在：</td>
							<td width="250px">${res.res.live eq '0'?"是":"否"}</td>
						</tr>
						<tr>
							<td align="right" width="100px">出生日期：</td>
							<td width="250px">${res.res.birth}</td>
							<c:if test="${res.res.sex eq '0' }">
								<td align="right" width="100px">妻子：</td>
								<td width="250px">${res.res.wife }</td>
								<td align="right" width="100px">是否健在：</td>
								<td width="250px">${res.res.live2 eq '0'?"是":"否"}</td>
							</c:if>
							<c:if test="${res.res.sex eq '1' }">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</c:if>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">简介</div>
				<div class="panel-body">${res.res.summary}</div>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">详细介绍</div>
				<div class="panel-body">${res.res.des}</div>
			</div>
		</div>
	</div>
</body>