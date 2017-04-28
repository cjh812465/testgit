function $ajax(params){
	var errorFunction = params.error;
	var sucessFunction = params.success;
	var errorSit = false;
	params.error = function(result){
		var win = $("#lmt_error_window_panel");
		var inner = (result.responseText)?result.responseText:"系统紧急维护，给您带来的不便请您谅解，谢谢。";
		win.html(inner);
		win.window({
			title : "ErrorWindow",
			width : 400,
			minimizable : false,
			maximizable	: false,
			modal : true,
			height : 350,
			onBeforeOpen : function(){
				win.show();
			},
			onBeforeClose : function(){
				win.hide();
				win.html("");
			}
		}).window("center");
		if(errorFunction){
//			errorFunction(result);
		}
		errorSit = true;
	}
	if(errorSit)return;
	params.success = function(result){
		if(sucessFunction){
			sucessFunction(result);
		}
	}
	$.ajax(params);
}

var loginSuccess;

function loginWindow(params){
	var params = {
		id : params.id,
		title : "用户登录",
		collapsible : false,
		minimizable : false,
		maximizable : false,
		closable : params.closable,
		draggable : false,
		shadow : false,
		resizable : false,
		modal : true
	}
	$("#"+params.id).show();
	var win = $("#"+params.id).window(params).window("center");
}
function regWindow(){
	//TODO:公用的注册窗口
}
function login_submit(params){
	$("#"+params.formid).form("submit",{
		url:"handan?login",
		method : "POST",
		onSubmit : function(user){},
		success : function(data){
			var result = eval("("+data+")");
			if(result.success){
				if(params.success){
					params.success();
				}
				$("#"+params.windowid).window("close");
			}else{
				alert(result.msg);
			}
		},
		error : function(){
			
		}
	})
}
function close_login(id){
	$("#"+id).window("close");
}