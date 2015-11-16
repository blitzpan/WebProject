var ue;
$(function(){
	//show and reset UEdit
	ue = UE.getEditor('editor');
	//是否显示妻子文本框
	$("input[name=sex]").click(function(){
		if($(this).val()=='0'){
			$(".wifeDiv").removeClass("hidden");
		}else{
			$(".wifeDiv").addClass("hidden");
		}
	});
	
	//基本信息保存
	$("#basicSaveBtn").click(function(){
		console.log("basicSaveBtn click");
		var id = $("#id").val();
		var name = $("#name").val();
		var sex = $("input[name=sex]:checked").val();
		var birth = $("#birth").val();
		var summary = $("#summary").val();
		var wife = $("#wife").val();
		var live = $("input[name=live]:checked").val();
		var live2 = $("input[name=live2]:checked").val();
		if(sex=='1'){
			wife="";
			live2="0";
			$("#wife").val("");
		}
		if(name==''){
			$.messager.alert("提示","姓名不能为空！");
			return;
		}
		showLoading("处理中，请稍候...");
		$.ajax({
			url:"/people/upPeople.action",
			data:{
				"id":id,
				"name":name,
				"sex":sex,
				"birth":birth,
				"summary":summary,
				"upType":"basic",
				"wife":wife,
				"live":live,
				"live2":live2					
			},
			dataType:"json",
			type:"POST",
			success:function(data){
				console.log(data)
				hideLoading();
				$.messager.alert("提示",data.info);
			},
			error:function(request,status,e){
				hideLoading();
				$.messager.alert("提示","修改基本信息发生未知异常！");
			}
		});
	});
	//详细信息保存
	$("#descSaveBtn").click(function(){
		showLoading("处理中，请稍候...");
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
				hideLoading();
				console.log(data)
				$.messager.alert("提示",data.info);
			},
			error:function(request,status,e){
				hideLoading();
				$.messager.alert("提示","修改详细信息发生未知异常！");
			}
		});
	});
	$(".closeBtn").click(function(){
		window.close();
	});
});