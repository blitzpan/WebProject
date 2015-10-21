var intTer;
$(function(){
	$("#logoDiv").load("../junxun/public/logoPage.html");
	$("#navDiv").load("../junxun/public/navPage.html");
	$("#footDiv").load("../junxun/public/footPage.html");
	//show and reset UEdit
	UE.getEditor('editor');
	intTer=setInterval("resetEditor()",50);
	//reset
	$("#reset").click(function(){
		UE.getEditor('editor').setContent('', false);
	});
	//save
	$("#save").click(function(){
		alert(UE.getEditor('editor').getContent());
	});
});
function resetEditor(){
	console.info(1);
	if($("#edui1").width()>10){
		$("#edui1").css("width","");
		clearInterval(intTer);
	}
}