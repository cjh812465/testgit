package lmt.core.controller.handan;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import lmt.core.utils.LmtMessageInbound;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * 类名：EchoServlet.java
 * 时间：2014 2014-11-27 下午5:43:59
 * 作者：关连营
 * 邮箱：guanlianying@yeah.net
 * 电话：18642261882
 * 简介：
 */

@WebServlet(urlPatterns = "/echo.ws")
public class LmtSocketServlet extends WebSocketServlet {
    
    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol,
	    final HttpServletRequest request) {
	// Log
	String user = "";
	try {
	    Map<String,String[]> map = request.getParameterMap();
	    Set<String> sets = map.keySet();
	    for(String key : sets){
		if(map.get(key).length>1){
		    
		}else{
		    System.out.println(new String(map.get(key)[0].getBytes("iso8859-1"),"UTF-8"));
		}
	    }
	    user = new String(request.getParameter("loginname").getBytes("iso8859-1"), "UTF-8");
	} catch (UnsupportedEncodingException e1) {
	    e1.printStackTrace();
	}
	return new LmtMessageInbound(user);
    }
}