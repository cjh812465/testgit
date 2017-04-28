package lmt.core.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 类名：SessionHolder.java
 * 时间：2014 2014-11-20 下午12:20:03
 * 作者：关连营
 * 邮箱：guanlianying@yeah.net
 * 电话：18642261882
 * 简介：
 */
public class SessionHolder {

    public static HttpServletRequest getRequest(){
	return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
 
    public static HttpSession getSession(){
	return getRequest().getSession();
    }
}
