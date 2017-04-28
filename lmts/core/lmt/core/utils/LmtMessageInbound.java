package lmt.core.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

/**
 * 类名：LmtMessageInbound.java
 * 时间：2014 2014-11-28 下午2:23:58
 * 作者：关连营
 * 邮箱：guanlianying@yeah.net
 * 电话：18642261882
 * 简介：
 */
public class LmtMessageInbound extends MessageInbound {
    
    private String user;
    
    private String id;
    
    public LmtMessageInbound(String user){
	this.user = user;
    }
    
    public LmtMessageInbound(Map<String,String> map){
	if(map.get("loginname")!=null){
	    user = map.get("loginname");
	}
	if(map.get("name")!=null){
	    user = map.get("name");
	}
	if(map.get("nicname")!=null){
	    user = map.get("nicname");
	}
	this.id = map.get("loginname");
    }
    
    public String getUser(){
	return this.user;
    }
    
    @Override
    protected void onClose(int status) {
	// 触发关闭事件，在连接池中移除连接  
        WebSocketMessageInboundPool.removeMessageInbound(this);  
        JSONObject result = new JSONObject();  
        result.element("type", "user_leave");  
        result.element("user", this.user);  
        result.element("id", this.id);  
        //向在线用户发送当前用户退出的消息  
        WebSocketMessageInboundPool.sendMessage(result.toString());  
    }

    @Override
    protected void onOpen(WsOutbound outbound) {
	// 触发连接事件，在连接池中添加连接  
        JSONObject result = new JSONObject();  
        result.element("type", "user_join");  
        result.element("user", this.user);  
        result.element("id", this.id);  
        //向所有在线用户推送当前用户上线的消息  
        WebSocketMessageInboundPool.sendMessage(result.toString());  

     	//向连接池添加当前的连接对象  
      	WebSocketMessageInboundPool.addMessageInbound(this);  
        result = new JSONObject();  
        result.element("type", "get_online_user");  
        result.element("list", WebSocketMessageInboundPool.getOnlineUser());  
        
        //向当前连接发送当前在线用户的列表  
        WebSocketMessageInboundPool.sendMessage(result.toString());  
        result = null;
    }

    @Override
    protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
	System.out.println("发现二进制数据传入，系统暂无处理能力。");
    }

    @Override
    protected void onTextMessage(CharBuffer message) throws IOException {
	JSONObject result = new JSONObject();  
        result.element("user", this.user);  
        result.element("text", message.toString());  
        result.element("type", "chat");
	WebSocketMessageInboundPool.sendMessage(result.toString());  
    }

}
