<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/jiapu.css"/>
	<script src="/js/jquery-2.1.4.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="/bootstrap-3.3.5-dist/js/jquery.bootstrap.min.js"></script>
	<!-- ECharts单文件引入 -->
    <script src="/echarts/dist/echarts.js"></script>
    <!-- my97DatePicker -->
    <script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="./js/jiapu.js"></script>
    <script language="javascript" type="text/javascript" src="/js/publicJs.js"></script>
	<style>
	</style>
</head>
<body>
	<div class="container-fluid">
		<div id="rowOne" class="row">
			<div id="leftDiv" class="col-lg-9">
				<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
				<div id="main"></div>
			</div>
			<div id="rightDiv" class="col-lg-3">
				<div class="panel panel-default">
				<div class="panel-body">
					<!-- 显示个人基本信息 -->
					<h3 id="basicInfo"></h3>
					<div>
						<button id="refresh" type="button" class="btn btn-primary">刷新</button>
						<button id="detailBtn" type="button" class="btn btn-info">详细</button>
						<button id="modBtn" type="button" class="btn btn-danger">修改</button>
						<button id="addShow" type="button" class="btn btn-primary">新增</button>
						<button id="delBut" type="button" class="btn btn-danger">删除</button>
					</div>
				</div>
				</div>
				<!-- 新增个人信息 -->
				<div id="addArea" class="panel panel-default">
				<div class="panel-body">
					<form id="addForm" class="form-horizontal">
						<input type="hidden" name="uid" id="uid"/>
						<div class="form-group">
							<label for="addType" class="col-sm-3 control-label"></label>
							<div class="col-sm-9">
							<select id="addType" name="addType" class="form-control">
								<option value="down" selected>晚辈</option>
								<option value="up">长辈</option>
							</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">姓名</label>
							<div class="col-sm-9">
							<input type="text" class="form-control" id="name" name="name">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">性别</label>
							<div class="col-sm-9">
							<label for="sex_m" class="checkbox-inline"><input type="radio" id="sex_m" name="sex" value="0" checked>男</input></label>
							<label for="sex_f" class="checkbox-inline"><input type="radio" id="sex_f" name="sex" value="1">女</input></label>
							</div>
						</div>
						<div id="wifeDiv" class="form-group">
							<label for="wife" class="col-sm-3 control-label">妻子</label>
							<div class="col-sm-9">
							<input type="text" class="form-control" id="wife" name="wife"/>
							</div>
						</div>
						<div class="form-group">
							<label for="csrq" class="col-sm-3 control-label">生日</label>
							<div class="col-sm-9">
							<input id="csrq" name="csrq" class="Wdate form-control" type="text" onClick="WdatePicker()" placeHolder="出生日期（公历）"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<textarea id="summary" name="summary" class="form-control" placeHolder="简介" rows=10></textarea>
							</div>
						</div>
						<button id="addOk" type="button" class="btn btn-primary">确定</button>
						<button id="addCancel" type="button" class="btn btn-danger">取消</button>
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
    <script type="text/javascript">
    	var myChart;
    	var option;
        // 路径配置
        require.config({
            paths: {
                echarts: '/echarts/dist'
            }
        });
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/tree' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                myChart = ec.init(document.getElementById('main')); 
				// 过渡---------------------
				myChart.showLoading({
					text: '正在努力的读取数据中...',    //loading话术
				});
				myChart.hideLoading();
				option = {
					title : {
						text: '俎豆千秋、本支百世、永言孝思',
						subtext: '敬祖先长命富贵，孝父母金玉满堂'
					},
					tooltip : {
						trigger: 'item',
						formatter: "{b}: {c}"
					},
					toolbox: {
						show : true,
						feature : {
							mark : {show: true},
							restore : {show: true},
							saveAsImage : {show: true},
							myTool : {
				                show : true,
				                title : '全屏',
				                icon : '/images/full-screen.png',
				                onclick : function (){
				                    $("#rightDiv").toggle(
				                    	function(){
				                    		//这个全屏代码根本就没有实现
				                    		$("#rightDiv").hide();
				                    		$("#leftDiv").removeClass("col-lg-9");
				                    		$("#leftDiv").addClass("col-lg-12");
				                    		$("#leftDiv").resize();
				                    	},
				                    	function(){
				                    		$("#leftDiv").removeClass("col-lg-12");
				                    		$("#leftDiv").addClass("col-lg-19");
				                    		$("#rightDiv").show();
				                    	}
				                    );
				                }
				            }
						}
					},
					calculable : true,
					series : [
					{
						name:'树图',
						type:'tree',
						orient: 'vertical',  // vertical horizontal
						rootLocation: {x: 'center', y: 80}, // 根节点位置  {x: 'center',y: 10}
						nodePadding: 20,
						symbol: 'series',
						symbolSize: 40,		
						roam: true,
						itemStyle: {
							normal: {
								label: {
									show: true,
									position: 'inside',
									textStyle: {
										color: '#000',
										fontSize: 15,
										fontWeight:  'bolder'
									}
								},
								lineStyle: {
									color: '#000',
									width: 1,
									type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
								}
							},
							emphasis: {
								color: '#4883b4',
								label: {
									show: true
								}
							}
						},
						/**/
						data: [{
								name: '家谱',
								value: 6,
								symbolSize: [90, 70],
								itemStyle: {
									normal: {
										color: '#ffff00',
										label: {
											show: true
										}
									}
								},
								children:[]
							}]
						
						/*
						data: [
							{
								name: '手机',
								value: 6,
								symbolSize: [90, 70],
								
								itemStyle: {
									normal: {
										label: {
											show: true
										}
									}
								},
								children: [
									{
										name: '小米',
										value: 4,
										itemStyle: {
											normal: {
												label: {
													show: true
												}
											}
										},
										symbolSize: [60, 60],
										children: [
											{
												name: '小米1',
												symbol: 'circle',
												symbolSize: 20,
												value: 14,
												itemStyle: {
													normal: {
														color: '#fa6900',
														label: {
															show: true,
															position: 'right'
														},
													},
													emphasis: {
														label: {
															show: true
														},
														borderWidth: 0
													}
												}
											},
											{
												name: '小米2',
												value: 4,
												symbol: 'circle',
												symbolSize: 20,
												itemStyle: {
													normal: {
														label: {
															show: true,
															position: 'right',
															formatter: "{b}"
														},
														color: '#fa6900',
														borderWidth: 2,
														borderColor: '#cc66ff'
													},
													emphasis: {
														borderWidth: 0
													}
												}
											},
											{
												name: '小米3',
												value: 2,
												symbol: 'circle',
												symbolSize: 20,
												itemStyle: {
													normal: {
														label: {
															position: 'right'
														},
														color: '#fa6900',
														brushType: 'stroke',
														borderWidth: 1,
														borderColor: '#999966',
													},
													emphasis: {
														borderWidth: 0
													}
												}
											}
										]
									},
									{
										name: '苹果',
										symbolSize: [60, 60],
										itemStyle: {
											normal: {
												label: {
													show: true
												}
											}
										},
										value: 4
									},
									{
										name: '华为',
										symbolSize: [60, 60],
										itemStyle: {
											normal: {
												label: {
													show: true
												}
											}
										},
										value: 2
									},
									{
										name: '联想',
										symbolSize: [60, 60],
										itemStyle: {
											normal: {
												label: {
													show: true
												}
											}
										},
										value: 2
									}
								]
							}
						]
							*/
							
							
							
							
					}]
				};
				var ecConfig = require('echarts/config');
				function eConsole(param) {
					var str = param.name + ":" + param.value;
					$("#basicInfo").html(param.name);
					$("#uid").val(param.value);
				}
				myChart.on(ecConfig.EVENT.CLICK, eConsole);
				// 为echarts对象加载数据 
				myChart.setOption(option); 
				}
			);
    </script>
</body>