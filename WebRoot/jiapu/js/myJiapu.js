$(function(){
	$("#subBtn").click(function(){
		var id = $.trim($("#id").val());
		var name = $.trim($("#name").val());
		var summary = $.trim($("#summary").val());
		if(name==''){
			$.messager.alert("提示","名称不能为空！");
			return;
		}
		$(this).attr("disabled","disabled");
		$.ajax({
			url:"/clan/addClan.action",
			type:"POST",
			dataType:"json",
			async:true,
			data:{
				"id":id,
				"name":name,
				"summary":summary
			},
			success:function(data){
				alert(data.info);
			},
			error:function(request, state,e){
				$.messager.alert("提示","网络出现问题！");
			}
		});
		$(this).removeAttr("disabled");
	});
});