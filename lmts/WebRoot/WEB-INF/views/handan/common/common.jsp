<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String webroot = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+webroot+"/";
%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" type="text/css" href="<%=webroot%>/jslib/easyui1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=webroot%>/jslib/easyui1.4/themes/icon.css">
	<script type="text/javascript" src="<%=webroot%>/jslib/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=webroot%>/jslib/easyui1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=webroot%>/jslib/handan/js/common.js"></script>
	<script type="text/javascript" src="<%=webroot%>/jslib/handan/js/websocket.js"></script>

