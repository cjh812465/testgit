<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String webroot = request.getContextPath();
%>
<script type="text/javascript" src="<%=webroot%>/jslib/handan/js/chat.js"></script>
<div class="easyui-layout" style="height:100%;">
	<div data-options="region:'north'"
		style="height:20px;border-left:none;border-right:none;border-top:none;">工具栏预留</div>
	<div data-options="region:'center',border:false">
		<div contentEditable=true id="handan_chat_area"
			style="overflow-y: auto; font-weight: normal; font-size: 12px; overflow-x: hidden; color: #000066; word-break: break-all;font-style: normal; font-family: simsun; height: 100%;"></div>
	</div>
	<div data-options="region:'south'"
		style="height:30px;border-left:none;border-right:none;border-bottom:none;">
		<a href="javascript:void(0)" id="submit_message_button" style="float:right;margin:2px 10px 0 0;"
			class="easyui-linkbutton" iconCls="icon-ok" plain="true"
			onclick="sendMyMessage()">提交</a>
	</div>
</div>