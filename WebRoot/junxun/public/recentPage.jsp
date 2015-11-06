<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">近期文章</h3>
	</div>
	<div class="panel-body1">
		<ul class="list-group" style="margin-bottom:0px">
		<c:forEach var="item" items="${res.res }">
			<li class="list-group-item"><a target="_blank" href="/article/showArticle.action?id=${item.id }">${item.title }</a></li>
		</c:forEach>
		</ul>
	</div>
</div>