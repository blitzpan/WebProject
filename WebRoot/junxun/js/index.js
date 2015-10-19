$(function(){
	loadIndex();
});
//加载默认主页
function loadIndex(){
	$('#centerDiv').load('./listContent.html');
	$('#navDiv').load('./navPage.html');
	$("#logoDiv").load('./logoPage.html');
	$("#weiboDiv").load('./weiboPage.html');
	$("#recentDiv").load('./recentPage.html');
	$("#articleFamilyDiv").load('./articleFamilyPage.html');
	$("#monthDiv").load('./monthPage.html');
	$("#linkDiv").load('./linkPage.html');
	$("#footDiv").load('./footPage.html');
}
