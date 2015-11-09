<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<style>
#floatButton {
	position:fixed;
	top:50%;
	right:0;
	z-index:9999999;}
#floatButton .btn:focus{
	outline:0
}
#pageQrcode img.qrcode{
	position:absolute;
	right:50px;
	bottom:-34px;
	padding:10px;
	background:#fff;
	border:1px solid #ccc;
	border-radius:4px;
	display:none}
#pageQrcode:hover img.qrcode{
	display:block
}
</style> 
<div class="btn-group-vertical" id="floatButton">
	<button type="button" class="btn btn-default" id="goTop" title="去顶部"><span class="glyphicon glyphicon-arrow-up"></span></button>
	<button type="button" class="btn btn-default" id="refresh" title="刷新"><span class="glyphicon glyphicon-repeat"></span></button>
	<button type="button" class="btn btn-default" id="pageQrcode" title="本页二维码"><span class="glyphicon glyphicon-qrcode"></span>
		<img class="qrcode" width="130" height="130" src="http://7xnzc3.com1.z0.glb.clouddn.com/junxun430_430.jpg" />
	</button>
	<button type="button" class="btn btn-default" id="goBottom" title="去底部"><span class="glyphicon glyphicon-arrow-down"></span></button>
</div>
<script>
//右侧浮动按钮事件
$(document).on("click","#goTop",function(){
	$('html,body').animate({scrollTop: '0px'}, 800);
}).on("click","#goBottom",function(){
	$('html,body').animate({scrollTop:$('#footDiv').offset().top}, 800);
}).on("click","#goComments",function(){
	$('html,body').animate({scrollTop:$('#comments').offset().top}, 800);
}).on("click","#refresh",function(){
	location.reload();
});
</script>