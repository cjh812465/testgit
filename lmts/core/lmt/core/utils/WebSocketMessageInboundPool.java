package lmt.core.utils;
/**
 * 类名：WebSocketMessageInboundPool.java
 * 时间：2014 2014-12-1 上午9:18:18
 * 作者：关连营
 * 邮箱：guanlianying@yeah.net
 * 电话：18642261882
 * 简介：
 */
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
  
public class WebSocketMessageInboundPool {  
  
    //保存连接的MAP容器  
    private static final Map<String,LmtMessageInbound > connections = new HashMap<String,LmtMessageInbound>();  
      
    //向连接池中添加连接  
    public static void addMessageInbound(LmtMessageInbound inbound){  
        //添加连接  
        System.out.println("用户 : " + inbound.getUser() + " 加入聊天室");  
        connections.put(inbound.getUser(), inbound);  
    }  
      
    //获取所有的在线用户  
    public static Set<String> getOnlineUser(){  
        return connections.keySet();  
    }  
      
    public static void removeMessageInbound(LmtMessageInbound inbound){  
        //移除连接  
        System.out.println("用户 : " + inbound.getUser() + " 退出聊天室");  
        connections.remove(inbound.getUser());  
    }  
      
    public static void sendMessageToUser(String user,String message){  
        try {  
            //向特定的用户发送数据  
//            System.out.println("send message to user : " + user + " ,message content : " + message);  
            LmtMessageInbound inbound = connections.get(user);  
            if(inbound != null){  
                inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    //向所有的用户发送消息  
    public static void sendMessage(String message){  
        try {  
            Set<String> keySet = connections.keySet();  
            for (String key : keySet) {  
        	LmtMessageInbound inbound = connections.get(key);  
                if(inbound != null){  
//                    System.out.println("send message to user : " + key + " ,message content : " + message);  
                    inbound.getWsOutbound().writeTextMessage(CharBuffer.wrap(message));  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  