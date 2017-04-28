(function(){
	var roomTask = window.setInterval(function(){
		var date = newDate();
		if($("#handan_room_chat_list li").length>0)date = $("#handan_room_chat_list li").last().find(".chat_title").attr("date")
		$ajax({
			url : "chat?last",
			method : "POST",
			data : {
				date : date
			},
			success : function(res){
				if(res.length&&res.length>0){
					for(var index in res){
						var chat = res[index];
						var date = newDate(chat.date.time);
						var li = $("<li></li>");
						var title = $("<div class='chat_title' date='"+ date +"'>"+chat.user.username+"</div>");
						var text = $("<div>"+chat.text+"</div>");
						li.append(title);
						li.append(text);
						$("#handan_room_chat_list").append(li);
					}
				}
			}
		})
	}, 1000)
	setTimeout(function(){
		
	}, 500)
})()

function formatDate(newdate) { 
	var year=newdate.getFullYear(); 
	var month=newdate.getMonth()+1; 
	var date=newdate.getDate(); 
	var hour=newdate.getHours(); 
	var minute=newdate.getMinutes(); 
	var second=newdate.getSeconds(); 
	return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second+".0"; 
}
function newDate(timer){
	var date;
	if(timer)
		{date = new Date(timer);}
	else
		{date = new Date(new Date().getTime()-9999);}
	return formatDate(date);
	
}