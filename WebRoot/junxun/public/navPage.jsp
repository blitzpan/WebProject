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
	  <a class="navbar-brand" href="#" onclick="goPage('index');">首页</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  <ul class="nav navbar-nav">
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">训练<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="#" onclick="goPage('xunlian');">日常训练</a></li>
			<li><a href="#" onclick="goPage('neiwu');">内务</a></li>
			<li><a href="#">国防教育</a></li>
		  </ul>
		</li>
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">军训健康<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="#">饮食</a></li>
			<li><a href="#">服装</a></li>
			<li><a href="#">住宿</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">美容</a></li>
		  </ul>
		</li>
		<li class="dropdown">
		  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">军训感悟<span class="caret"></span></a>
		  <ul class="dropdown-menu">
			<li><a href="#">军训口号</a></li>
			<li><a href="#">军训作文</a></li>
		  </ul>
		</li>
		<li><a href="#" onclick="goPage('joke');">军中笑料</a></li>
		<li><a href="#">军歌嘹亮</a></li>
		<li><a href="#">青春年华</a></li>
		<li><a href="#">树洞</a></li>
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
