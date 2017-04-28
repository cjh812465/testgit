function logout(){
	$ajax({
		url : "handan?logout",
		method : "POST",
		success : function(){
			$('#handan_north_panel').panel('refresh');
			$('#handan_vedio_panel').panel('refresh');
		}
	})
}
function openLoginWindow(){
	loginWindow({
		id : "common_login_window_panel",
		closable : false
	});
}
$(function(){
	$("#submit_button").click(function(){
		login_submit({
			formid : "login_form",
			windowid : "common_login_window_panel",
			success : function(){
				$('#handan_north_panel').panel('refresh');
				$('#handan_vedio_panel').panel('refresh');
			}
		})
	})
})