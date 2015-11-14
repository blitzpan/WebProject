$(function(){
	console.log('jiapuMod ready');
	//show and reset UEdit
	var ue = UE.getEditor('editor');
	ue.ready(function(){
		ue.setContent(desc);
	});

	$("#test").click(function(){
		console.log('test click');
		console.log(UE.getEditor('editor').getContent());
	});
});