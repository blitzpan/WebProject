$(function(){
	//show and reset UEdit
	UE.getEditor('editor');
	//reset
	$("#reset").click(function(){
		UE.getEditor('editor').setContent('', false);
	});
	//save
	$("#save").click(function(){
		//判断用户是否已经登陆
		var isLogin = false;
		$.ajax({
			url:"/user/isLogin.action",
			type:"POST",
			dataType: 'json',
			data:{},
			async:false,
			success:function(data){
				console.log(data);
				if(data.state=='0'){
					$.messager.alert('提示',data.info);
				}else if(data.state=='1'){
					isLogin = true;
				}
			},error: function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('提示','发生异常！');
			}
		});
		if(!isLogin){
			return;
		}
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