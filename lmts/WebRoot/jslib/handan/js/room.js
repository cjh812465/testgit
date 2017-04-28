$(function() {

	startServer()

})
var ws = null;
function startServer() {
	// 设定WebSocket,注意协议是ws，请求是指向对应的WebSocketServlet的
	var url = "ws://127.0.0.1:8080/lmt/echo.ws";
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
		alert('Opened!');
	};

	// 收到服务器发送的文本消息, event.data表示文本内容
	ws.onmessage = function(event) {
		alert('Receive message: ' + event.data);
	};

	// 关闭WebSocket的回调
	ws.onclose = function() {
		alert('Closed!');
	};
}

function sendMyMessage() {
	var textMessage = document.getElementById('handan_chat_area').value;
	if (ws != null && textMessage != '') {
		// 通过WebSocket想向服务器发送一个文本信息
		ws.send(textMessage);
	}
}