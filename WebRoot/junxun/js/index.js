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
}
//跳转
function goPage(page){
	$("#centerDiv").empty();
	alert(page);
	$('#centerDiv').load('./listContent.html');
}
