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
				"password":pw
			},
			type:"POST",
			dataType:"json",
			success:function(data){
				console.log(data);
				if(data.state=='0'){
					showAlert($("#loginName"), data.info);
				}else if(data.state=='1'){
					window.location.href=data.res;
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('提示','登录发生异常！');
			}
		});
	});
	//注册
	$("#registerBtn").click(function(){
		clearAlertTip();
		var name = $("#registerName").val().trim();
		if(name==''){
			showAlert($("#registerName"), "用户名不能为空！");
			return;
		}
		if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(name)){
			console.log(1);
			showAlert($("#registerName"), "邮箱地址非法！");
			return;
		}
		var nickName = $("#registerNickname").val().trim();
		if(nickName==''){
			showAlert($("#registerNickname"), "昵称不能为空！");
			return;
		}
		var pw1 = $("#registerPw1").val().trim();
		if(pw1==''){
			showAlert($("#registerPw1"), "密码不能为空！");
			return;
		}
		var pw2 = $("#registerPw2").val().trim();
		if(pw2==''){
			showAlert($("#registerPw2"), "密码不能为空！");
			return;
		}
		if(pw1!=pw2){
			showAlert($("#registerPw2"), "两次密码不一致！");
			return;
		}
		var checkOk = false;
		//校验邮箱是否已经存在
		$.ajax({
			url:"/user/isExist.action",
			type:"POST",
			dataType:"json",
			async:false,
			data:{
				"name":name
			},
			success:function(data){
				console.log(data);
				if(data.state=='1'){
					checkOk = true;
				}else{
					showAlert($("#registerName"), data.info);
				}
			},
			error:function(request,state,e){
				$.messager.alert("提示","注册发生异常，请稍后再试！");
			}
		});
		if(!checkOk){
			return;
		}
		//注册
		$.ajax({
			url:"/user/register.action",
			type:"POST",
			dataType:"json",
			data:{
				"name":name,
				"nickName":nickName,
				"password":pw1,
				"third":"3"
			},
			success:function(data){
				console.log(data);
				if(data.state=='1'){
					console.log(data.res);
					window.location.href=data.res;
				}else{
					showAlert($("#registerName"), res.info);
				}
			},
			error:function(request,state,e){
				$.messager.alert("提示","注册发生异常，请稍后再试！");
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