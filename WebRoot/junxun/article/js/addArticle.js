var intTer;
$(function(){
	//show and reset UEdit
	UE.getEditor('editor');
	intTer=setInterval("resetEditor()",50);
	//reset
	$("#reset").click(function(){
		UE.getEditor('editor').setContent('', false);
	});
	//save
	$("#save").click(function(){
		$("#content").val(UE.getEditor('editor').getContent());
		$("#addForm").submit();
	});
});
function resetEditor(){
	console.info(1);
	if($("#edui1").width()>10){
		$("#edui1").css("width","");
		clearInterval(intTer);
	}
}