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
		console.log("send");
		$("#activation").html("发送激活邮件("+count+")");
	}else if(count==0){
		count=180;
		window.clearTimeout(timeInt);
		$("#activation").removeAttr("disabled");
		$("#activation").html("发送激活邮件");
	}else{
		$("#activation").html("发送激活邮件("+count+")");
	}
	count--;
}