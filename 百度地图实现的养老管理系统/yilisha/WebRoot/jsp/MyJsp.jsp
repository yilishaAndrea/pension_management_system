<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>test</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../themes/default/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="../themes/icon.css" type="text/css"></link>
	<link rel="stylesheet" href="../css/common.css" type="text/css"></link>
  	<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/locale/easyui-lang-zh_CN.js"></script>
    
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
		#r-result{height:100%;width:20%;float:left;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0RGxsx0dlBCgy1szZuETAPDUDaIuTFP5"></script>
    <script type="text/javascript">
		$(function(){
			var dataX = new Array();
			var dataY = new Array();	
			/**
			 *	初始化数据表格  
			 */
			$('#t_user').datagrid({
					idField:'id' ,		//只要创建数据表格 就必须要加 idField
					title:'用户' ,
					//width:1300 ,
					fit:true ,
					height:450 ,
					url:'../UserServlet?method=getList' ,
					fitColumns:true ,  
					striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					//singleSelect:true ,				//单选模式 
					//remoteSort: false ,
					//sortName: 'salary' ,
					//sortOrder: 'desc' ,
					rowStyler: function(index ,record){
						 if(record.age > 25){
							 return "background:red";
						 }
						 // console.info(index);
						 // console.info(record);
					} ,
					frozenColumns:[[				//冻结列特性 ,不要与fitColumns 特性一起使用 
						{
							field:'ck' ,
							width:50 ,
							checkbox: true
						}
					]],
					columns:[[
						{
							field:'userID' ,
							title:'userID' ,
							width:30 ,
							sortable : true 
						},
						{
							field:'userName' , 
							title:'userName' ,
							width:30
						},
						{
							field:'userGender' ,
							title:'userGender' ,
							width:30 ,
							sortable : true
						},
						{
							field:'userAge' ,
							title:'userAge' ,
							width:30 ,
							sortable : true
						},
						{
							field:'userTel' ,
							title:'userTel' ,
							width:30 ,
							sortable : true
						},
						{
							field:'userCoordinateX' ,
							title:'userCoordinateX' ,
							width:30 ,
							align:'center' ,
						},
						{
							field:'userCoordinateY' ,
							title:'userCoordinateY' ,
							width:30 ,
							sortable : true 
						},
						{
							field:'insuredTypeID' ,
							title:'insuredTypeID' ,
							width:30 ,
							align:'center' ,
						},
						{
							field:'userAddress' ,
							title:'userAddress' ,
							width:30 ,
							align:'center' ,
						}
					]] ,
					pagination: true , 
					pageSize: 10 ,
					pageList:[5,10,15,20,50] ,
			});
			var map = new BMap.Map("allmap");	
			var point = new BMap.Point(120.827862,31.966614);
			map.centerAndZoom(point,15);
			function addMarker(point){
				var marker = new BMap.Marker(point);
				map.addOverlay(marker);
			}	
						
		});
	</script>
  </head>
  <body>
	<div id="lay" class="easyui-layout" style="width: 100%;height:30%" >
		<div region="center">
			<table id="t_user"></table>
		</div>
	</div>
	<div id="allmap" class="easyui-layout" style="width: 100%;height:60%" ></div>
  </body>
</html>
