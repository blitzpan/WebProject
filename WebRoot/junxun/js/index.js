$(function(){
	loadIndex();
});
//加载默认主页
function loadIndex(){
//	$('#centerDiv').load('/article/getAllArticle.action');
//	$('#navDiv').load('./public/navPage.jsp');
//	$("#logoDiv").load('./public/logoPage.jsp');
	$("#weiboDiv").load('./weiboPage.html');
	$("#articleFamilyDiv").load('./articleFamilyPage.html');
	$("#monthDiv").load('./monthPage.html');
	$("#linkDiv").load('./linkPage.html');
	$("#footDiv").load('./public/footPage.jsp');
}
//跳转
function goPage(page){
	$("#centerDiv").empty();
	alert(page);
	$('#centerDiv').load('./listContent.html');
}
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