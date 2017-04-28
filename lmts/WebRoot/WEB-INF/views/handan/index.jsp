<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>聊天室</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<%@ include file="common/common.jsp"%>
<%-- <script type="text/javascript" src="<%=webroot%>/handan/common/js/index.js"></script>
<link rel="stylesheet" type="text/css" href="<%=webroot%>/handan/common/css/index.css"> --%>
<style type="text/css">
</style>
</head>

<body class="easyui-layout">

	<div id="handan_north_panel" data-options="region:'north'" style="height:50px" href="handan?top"></div>
	<div data-options="region:'west',border:false" style="width:210px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west'" style="width:50px;"></div>
			<div data-options="region:'center',border:false">
				<div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'north'" title="在线讲师" style="height:200px" href="handan?lecturer"></div>
					<div data-options="region:'center'" title="在线用户 " href="handan?users"></div>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',border:false" title="聊天记录" href="handan?room"></div>
			<div data-options="region:'south'" style="height:120px;border-left:none;border-right:none;" href="handan?chat"></div>
		</div>
	</div>
	<div data-options="region:'east'" style="width:504px;">
		<div class="easyui-layout" data-options="fit:true">
			<div id="handan_vedio_panel" data-options="region:'north',border:false" style="height:403px" title="在线视频 " href="handan?vedio"></div>
			<div data-options="region:'center'" title="本站信息" href="handan?message"></div>
		</div>
	</div>
	<div id="lmt_error_window_panel" style="display:none;"></div>
	<div id="common_login_window_panel" title="用户登录" style="width:400px;padding:30px 70px 20px 70px;display:none;">
   		<form id="login_form" method="POST">
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38" name="loginname"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38" name="password"/>
			</div>
		</form>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>记住密码</span>
		</div>
		
		<div>
			<a id="submit_button" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
				<span style="font-size:14px;">登录系统</span>
			</a>
		</div>
	</div>
</body>
</html>