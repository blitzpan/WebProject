<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%@ page import="java.util.*,com.junxun.entity.Res,com.junxun.entity.Article" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel panel-default listContent">
	<ul class="list-group">
		<c:forEach var="item" items="${res.res}">
			<li class="list-group-item">
				<h3><a href="">${item.title }</a></h3>
				<p>
				${item.content }
				</p>
			</li>
		</c:forEach>
	</ul>
</div>
<nav>
  <ul class="pagination pagination-lg" style="margin:0px auto">
  	<c:if test="${page.hasPreviousPage() }">
		<li>
	  		<a href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
	</c:if>
	<c:forEach begin="${page.getStartPage() }" end="${page.getEndPage() }" var="i">
		<li><a href="#">${i }</a></li>
	</c:forEach>
	<c:if test="${page.hasNextPage() }">
		<li>
		  <a href="#" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
		  </a>
		</li>
	</c:if>
  </ul>
</nav>
