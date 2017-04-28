$(function() {

	

})
var ws = null;
function startServer(obj) {
	var params = "";
	for(var index in obj){
		if(params!=""){
			params += "&";
		}
		params = params + index + "=" + obj[index];
	}
	// 设定WebSocket,注意协议是ws，请求是指向对应的WebSocketServlet的
	var url = "ws://127.0.0.1:8080/lmt/echo.ws?"+params;
//	var url = "ws://127.0.0.1:8080/lmt/chat?username="+user";
	// 创建WebSocket实例，下面那个MozWebSocket是Firefox的实现
	if ('WebSocket' in window) {
		ws = new WebSocket(url);
	} else if ('MozWebSocket' in window) {
		ws = new MozWebSocket(url);
	} else {
		alert('Unsupported.');
		return;
	}

	// WebSocket握手完成，连接成功的回调
	// 有个疑问，按理说new WebSocket的时候就会开始连接了，如果在设置onopen以前连接成功，是否还会触发这个回调
	ws.onopen = function() {
		
	};

	// 收到服务器发送的文本消息, event.data表示文本内容
	ws.onmessage = function(event) {
		var result = eval("("+event.data+")");
		if(result.type=="chat"){
			var li = $("<li></li>");
			var user = $("<div>"+result.user+"</div>");
			var text = $("<div>"+result.text+"</div>");
			li.append(user).append(text);
			$("#handan_room_chat_list").append(li);
		}
		if(result.type=="user_join"){
			$("#handan_room_chat_list").append("<li>-----热烈欢迎-----"+result.user+"-----加入聊天室-----</li>");
		}
		if(result.type=="user_leave"){
			$("#user_list").find("#"+result.user).remove();
		}
		if(result.type="get_online_user"){
			if(result.list)
			$("#user_list").html("");
			for(var index in result.list){
				var li = $("<li id='"+result.list[index]+"'>"+result.list[index]+"</li>");
				$("#user_list").append(li);
			}
		}
	};

	// 关闭WebSocket的回调
	ws.onclose = function() {
		$("#handan_room_chat_list").append("<li>由于长时间没有操作，聊天系统自动关闭，请刷新后重试。</li>");
	};
}

function sendMyMessage() {
	var textMessage = $("#handan_chat_area").html();
	if (ws != null && textMessage != '') {
		// 通过WebSocket想向服务器发送一个文本信息
		ws.send(textMessage);
	}
	$("#handan_chat_area").html("");
}