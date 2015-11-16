$(function(){
	initLoading();
	refresh();
	$("#addShow").click(function(){
		if($("#uid").val()==''){
			$.messager.alert("提示","请先选择一位再新增！");
		}else{
			$("#addArea").show(500);
		}
	});
	$("#addCancel").click(function(){
		$("#addForm")[0].reset();
		$("#addArea").hide(500);
	});
	$("#refresh").click(function(){
		refresh();
	});
	$("#addOk").click(function(){
		var addType = $("#addType").val();
		var fid = $("#uid").val();
		var name = $("#name").val();
		var sex = $("input[name=sex]:checked").val();
		var csrq = $("#csrq").val();
		var summary = $("#summary").val();
		if(name==''){
			$.messager.alert('提示','姓名不能为空！');
			return;
		}
		showLoading("处理中，请稍候...");
		$.ajax({
			url:"/people/addPeople.action",
			type:"POST",
			dataType:"json",
			data:{
				"addType":addType,
				"name":name,
				"sex":sex,
				"birth":csrq,
				"summary":summary,
				"fid":fid
			},
			async:true,
			success:function(data){
				hideLoading();
				console.log(data);
				if(data.state=='1'){
					$("#addForm")[0].reset();
					$("#addArea").hide(500);
					refresh();
				}else{
					$.messager.alert('提示',data.info);
				}
			},
			error:function(request,status,e){
				hideLoading();
				$.messager.alert('提示','新增出现异常！');
			}
		});
	});
	$("#delBut").click(function(){
		var id = $("#uid").val();
		if(id==''){
			$.messager.alert('提示','请先选择一个人后再删除！');
			return;
		}
		showLoading("处理中，请稍候...");
		$.ajax({
			url:"/people/delPeople.action",
			type:"POST",
			dataType:"json",
			data:{
				"id":id
			},
			success:function(data){
				hideLoading();
				if(data.state=='1'){
					refresh();
					$("#uid").val('');
					$("#basicInfo").html("");
				}else{
					$.messager.alert('提示',data.info);
				}
			},
			error:function(request,status,e){
				hideLoading();
				$.messager.alert('提示','删除出现异常！');
			}
			
		});
		hideLoading();
	});
	//显示详情
	$("#detailBtn").click(function(){
		if($("#uid").val()==''){
			$.messager.alert('提示','请先选择一个人后再进行操作！');
			return;
		}
		window.open("/people/queryDetail.action?id="+$("#uid").val());
	});
	//进入修改页面
	$("#modBtn").click(function(){
		if($("#uid").val()==''){
			$.messager.alert('提示','请先选择一个人后再进行操作！');
			return;
		}
		window.open("/people/queryDetail.action?mod=mod&id="+$("#uid").val());
	});
});
function refresh(){
	$.ajax({
		url:"/people/queryPeoplesForTree.action",
		type:"POST",
		data:{},
		dataType: 'json',
		success:function(data){
			console.log(data);
			option.series[0].data=data.res;
			myChart.setOption(option, true); 
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('提示','查询所有人员发生异常！');
		}
	});
}