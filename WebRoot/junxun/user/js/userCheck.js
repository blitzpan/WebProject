var timeInt;
var count = 180;
$(function(){
	$("#activation").click(function(){
		$("#activation").attr("disabled","disabled");
		timeInt = window.setInterval('sendEmail()',1000);
	});
});
function sendEmail(){
	console.log("sendEmail");
	if(count==180){//sendEamil
		$.ajax({
			url:"/user/sendEmail.action",
			type:"POST",
			dataType:"json",
			data:{},
			success:function(data){
				if(data.state=='1'){
					
				}
				$.messager.alert("提示",data.info);
			},
			error:function(request,state,e){
				$.messager.alert("提示","发送邮件发生异常！");
			}
		});
		count--;
		$("#activation").html("发送激活邮件("+count+")");
	}else if(count==0){
		count=180;
		window.clearTimeout(timeInt);
		$("#activation").removeAttr("disabled");
		$("#activation").html("发送激活邮件");
	}else{
		count--;
		$("#activation").html("发送激活邮件("+count+")");
	}
}