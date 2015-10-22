<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
<nav class="navbar navbar-default nav-justified">
  <div class="container-fluid">
	<div class="navbar-header">
	  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	  </button>
	  <a class="navbar-brand" href="/junxun/index.jsp">首页</a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  <ul class="nav navbar-nav">
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">训练<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="/junxun/xunlian.jsp">日常训练</a></li>
			<li><a href="/junxun/neiwu.jsp">内务</a></li>
			<li><a href="/junxun/jiaoyu.jsp">国防教育</a></li>
		  </ul>
		</li>
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">军训健康<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="/junxun/yinshi.jsp">饮食</a></li>
			<li><a href="/junxun/fuzhuang.jsp">服装</a></li>
			<li><a href="/junxun/zhusu.jsp">住宿</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="/junxun/fangshai.jsp">防晒</a></li>
		  </ul>
		</li>
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">军训感悟<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="/junxun/kouhao.jsp">军训口号</a></li>
			<li><a href="/junxun/zuowen.jsp">军训作文</a></li>
		  </ul>
		</li>
		<li><a href="/junxun/joke.jsp">军中笑料</a></li>
		<li><a href="/junxun/song.jsp">军歌嘹亮</a></li>
		<li><a href="/junxun/pic.jsp">青春年华</a></li>
		<li><a href="/junxun/secret.jsp">树洞</a></li>
		<li><a href="/article/beforeAddArticle.action" target="_blank">投稿</a></li>
	  </ul>
	  <form class="navbar-form navbar-right" role="search">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="搜索">
			<span class="input-group-btn">
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
		</div>
	  </form>
	</div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
