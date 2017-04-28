function submit(){
	var editor,text;
	editor = $("#handan_chat_area")
	text = editor.html().trim();
	if(text=="")return;
	$ajax({
		url : "chat?submit",
		method : "POST",
		data : {
			text : text
		},
		success : function(){
			editor.html("");
		},
		error : function(res){
			$.messager.alert("很抱歉","发送失败，可能是网络原因造成。")
		}
	})
}

$("#handan_chat_area").keydown(function(e){
	var ev = document.all ? window.event : e;
	if(e.keyCode==13){
		$("#submit_message_button").click();
	}
})