$(function(){
	$("#addShow").click(function(){
		$("#editArea").show(500);
	});
	$("#addCancel").click(function(){
		$("#addForm")[0].reset();
	});
});