<%@ page import="lmt.core.pageModel.base.SessionInfo"%>
<%@ page import="net.sf.json.JSONObject"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String webroot = request.getContextPath();
%>
<script type="text/javascript" src="<%=webroot%>/jslib/handan/js/top.js"></script>
<div>
	<div class="handan_logo"></div>
	<div class="user_panel">
		<%  
		    SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");  
			if(info != null) {
				String obj = JSONObject.fromObject(info).toString();
		%>
			欢迎您登录：${sessionInfo.name }
			<a href="javascript:void(0)" onclick="logout()">注销</a>
			<% if(info.getNicname()==null) {%>
				<script type="text/javascript">
					/* if(confirm("系统侦测到您还没有设置昵称，是否现在设置？")){
						alert("尚未开启该功能。");
						
					} */
					startServer(<%=obj%>);
				</script>
			<% } else { %>
				<script type="text/javascript">startServer("${sessionInfo.nicname }");</script>
			<% } %>
		<% } else {%>
			<a href="javascript:void(0)" onclick="openLoginWindow()">登录</a>
			<a href="javascript:void(0)" onclick="alert('注册')">注册</a>
		<% } %>
	</div>
	<div class="app_panel"></div>
</div>