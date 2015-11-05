<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<%@ page import="java.util.*,com.junxun.entity.Res,com.junxun.entity.Article,com.junxun.util.Page" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel panel-default listContent">
	<ul class="list-group">
		<c:forEach var="item" items="${res.res}">
			<li class="list-group-item">
				<h3><a href="/article/showArticle.action?id=${item.id }" target="_blank">${item.title }</a></h3>
				<p>
				${item.summary }
				</p>
			</li>
		</c:forEach>
	</ul>
</div>
<nav>
  <ul class="pagination pagination-lg" style="margin:0px auto">
  	<c:if test="${page.hasPrevious }">
		<li>
	  		<a href="?pageNo=${page.pageNo-1 }" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
	</c:if>
	<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
		<li
			<c:if test="${i==page.pageNo }">class="disabled"</c:if>
		><a href="?pageNo=${i }">${i }</a></li>
	</c:forEach>
	<c:if test="${page.hasNext }">
		<li>
		  <a href="?pageNo=${page.pageNo+1 }" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
		  </a>
		</li>
	</c:if>
  </ul>
</nav>
