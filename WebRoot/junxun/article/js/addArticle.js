$(function(){
	//show and reset UEdit
	UE.getEditor('editor');
	//reset
	$("#reset").click(function(){
		UE.getEditor('editor').setContent('', false);
		//测试json代码
		$.ajax({
			url:"/user/isLogin.action",
			type:"POST",
			dataType: 'json',
			data:{},
			success:function(data){
				alert(data.state);
				alert(data["a"]);
				alert(data["b"]);
			},error: function (XMLHttpRequest, textStatus, errorThrown){
				alert('发生异常！');
			}
		});
	});
	//save
	$("#save").click(function(){
		if($("#title").val().trim()==''){
			$.messager.alert('提示',"标题不能为空！");
			return;
		}
		$("#content").val(UE.getEditor('editor').getContent());
		if($.trim($("#summary").val())==''){
			$("#summary").val(UE.getEditor('editor').getContentTxt().substr(0,200));
		}
		if($.trim($("#summary").val())==''){
			$.messager.alert("提示", "简介不能为空!");
			return;
		}
		$.messager.model = {
				ok:{ text: "确定", classed: 'btn-primary' },
				cancel: { text: "取消", classed: 'btn-danger' }
		};
		$.messager.confirm("提示", "确定保存？", function() { 
			$("#addForm").submit();
		});		
	});
});