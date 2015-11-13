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
					<div class="col-sm-1">姓名：</div>
					<div class="col-sm-2">${res.res.name}</div>
					<div class="col-sm-1">性别：</div>
					<div class="col-sm-2">${res.res.sex eq '0'?"男":"女"}</div>
					<div class="col-sm-1">出生日期：</div>
					<div class="col-sm-2">${res.res.birth}</div>
					<div class="col-sm-3"></div>
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