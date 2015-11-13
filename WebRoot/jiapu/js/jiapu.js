$(function(){
	$("#addShow").click(function(){
		$("#addArea").show(500);
	});
	$("#addCancel").click(function(){
		$("#addForm")[0].reset();
		$("#addArea").hide(500);
	});
	$("#refresh").click(function(){
		console.log('refresh');
		$.ajax({
			url:"/people/queryPeoplesForTree.action",
			type:"POST",
			data:{},
			dataType: 'json',
			success:function(data){
				console.log(data);
				option.series[0].data=eval("[{name:'手机改变了',value:6,symbolSize:[90,70],itemStyle:{normal:{label:{show:true}}},children:[{name:'小米',value:4,itemStyle:{normal:{label:{show:true}}},symbolSize:[60,60],children:[{name:'小米1',symbol:'circle',symbolSize:20,value:14,itemStyle:{normal:{color:'#fa6900',label:{show:true,position:'right'},},emphasis:{label:{show:true},borderWidth:0}}},{name:'小米2',value:4,symbol:'circle',symbolSize:20,itemStyle:{normal:{label:{show:true,position:'right',formatter:\"{b}\"},color:'#fa6900',borderWidth:2,borderColor:'#cc66ff'},emphasis:{borderWidth:0}}},{name:'小米3',value:2,symbol:'circle',symbolSize:20,itemStyle:{normal:{label:{position:'right'},color:'#fa6900',brushType:'stroke',borderWidth:1,borderColor:'#999966',},emphasis:{borderWidth:0}}}]},{name:'苹果',symbolSize:[60,60],itemStyle:{normal:{label:{show:true}}},value:4},{name:'华为',symbolSize:[60,60],itemStyle:{normal:{label:{show:true}}},value:2},{name:'联想',symbolSize:[60,60],itemStyle:{normal:{label:{show:true}}},value:2}]}]");
				option.series[0].data=data.res;
				console.log(data.res);
				myChart.setOption(option, true); 
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('提示','查询所有人员发生异常！');
			}
		});
		console.log('refresh over');
	});
});