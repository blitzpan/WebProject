var ue;
$(function(){
	//show and reset UEdit
	ue = UE.getEditor('editor');
	//基本信息保存
	$("#basicSaveBtn").click(function(){
		console.log("basicSaveBtn click");
		var id = $("#id").val();
		var name = $("#name").val();
		var sex = $("input[name=sex]:checked").val();
		var birth = $("#birth").val();
		var summary = $("#summary").val();
		if(name==''){
			$.messager.alert("提示","姓名不能为空！");
			return;
		}
		$.ajax({
			url:"/people/upPeople.action",
			data:{
				"id":id,
				"name":name,
				"sex":sex,
				"birth":birth,
				"summary":summary,
				"upType":"basic"
			},
			dataType:"json",
			type:"POST",
			success:function(data){
				console.log(data)
				$.messager.alert("提示",data.info);
			},
			error:function(request,status,e){
				$.messager.alert("提示","修改基本信息发生未知异常！");
			}
		});
	});
	//详细信息保存
	$("#descSaveBtn").click(function(){
		console.log("descSaveBtn click");
		var id = $("#id").val();
		var desc = ue.getContent();
		$.ajax({
			url:"/people/upPeople.action",
			data:{
				"id":id,
				"des":desc,
				"upType":"desc"
			},
			dataType:"json",
			type:"POST",
			success:function(data){
				console.log(data)
				$.messager.alert("提示",data.info);
			},
			error:function(request,status,e){
				$.messager.alert("提示","修改详细信息发生未知异常！");
			}
		});
	});
});