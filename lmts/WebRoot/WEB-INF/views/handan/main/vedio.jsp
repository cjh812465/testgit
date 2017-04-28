<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String webroot = request.getContextPath();
%>
<% if(session.getAttribute("sessionInfo")!=null) { %>

<object width='500' height='375' id='SampleMediaPlayback'
	name='SampleMediaPlayback' type='application/x-shockwave-flash'
	classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000'>
	<param name='movie' value='<%=webroot%>/jslib/handan/swfs/SampleMediaPlayback.swf' />
	<param name='quality' value='high' />
	<param name='bgcolor' value='#000000' />
	<param name='allowfullscreen' value='true' />
	<param name='flashvars'
		value='&src=rtmp://192.168.1.132/live/test&autoHideControlBar=true&streamType=vod&autoPlay=true&verbose=true' />
	<embed src='<%=webroot%>/jslib/handan/swfs/SampleMediaPlayback.swf' width='500'
		height='375' id='SampleMediaPlayback' quality='high'
		bgcolor='#000000' name='SampleMediaPlayback'
		allowfullscreen='true'
		pluginspage='http://www.adobe.com/go/getflashplayer'
		flashvars='&src=rtmp://192.168.1.132/live/test&autoHideControlBar=true&streamType=vod&autoPlay=true&verbose=true'
		type='application/x-shockwave-flash'>
	</embed>
</object>

<% } else {%>
	您必须登录之后才能进行视频观看及聊天
<% } %>
