$(function(){
	//登录tab页切换
	$("#loginTab li").click(function(){
		$(this).addClass("active").siblings("li").removeClass("active");
		if($(this).children().html()=='注册'){
			$("#registerDiv").show();
			$("#loginDiv").hide();
		}else{
			$("#registerDiv").hide();
			$("#loginDiv").show();
		}
	});
	//点击登录按钮
	$("#loginBtn").click(function(){
		clearAlertTip();
		var name = $("#loginName").val().trim();
		if(name==''){
			showAlert($("#loginName"), "用户名不能为空！");
			return;
		}
		var pw = $("#loginPw1").val().trim();
		if(pw==''){
			showAlert($("#loginPw1"), "密码不能为空！");
			return;
		}
		//登录
		$.ajax({
			url:"/user/login.action",
			data:{
				"name":name,
				"pw":pw
			},
			type:"POST",
			dataType:"json",
			success:function(data){
				alert(data);
				if(data.state=='0'){
					$.messager.alert('提示',data.info);
				}else if(data.state=='1'){
					isLogin = true;
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('提示','发生异常！');
			}
		});
	});
});
function clearAlertTip(){
	$("#tipDiv").hide();
	$("input").parent().removeClass("has-error");
}
function showAlert(obj, text){
	obj.after($("#tipDiv"));
	$("#tipSpan").html(text);
	$("#tipDiv").show();
	obj.parent().addClass("has-error");
}