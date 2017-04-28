package lmt.core.controller.handan;

import javax.servlet.http.HttpSession;

import lmt.core.framework.constant.GlobalConstant;
import lmt.core.pageModel.base.Json;
import lmt.core.pageModel.base.SessionInfo;
import lmt.core.pageModel.sys.User;
import lmt.core.service.sys.ResourceServiceI;
import lmt.core.service.sys.UserServiceI;
import lmt.core.utils.SessionHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：IndexController.java
 * 时间：2014 2014-11-24 下午2:41:30
 * 作者：关连营
 * 邮箱：guanlianying@yeah.net
 * 电话：18642261882
 * 简介：
 */
@Controller
@RequestMapping("/handan")
public class HandanController {
    
    @Autowired
    private UserServiceI userService;
    	
    @Autowired	
    private ResourceServiceI resourceService;

    @ResponseBody
    @RequestMapping(params="login",method=RequestMethod.POST)
    public Json login(User user, HttpSession session) {
	Json j = new Json();
	User sysuser = userService.login(user);
	if (sysuser != null) {
		j.setSuccess(true);
		j.setMsg("登陆成功！");

		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setId(sysuser.getId());
		sessionInfo.setLoginname(sysuser.getLoginname());
		sessionInfo.setName(sysuser.getName());
		// user.setIp(IpUtil.getIpAddr(getRequest()));
		sessionInfo.setResourceList(userService.resourceList(sysuser.getId()));
		sessionInfo.setResourceAllList(resourceService.resourceAllList());
		session.setAttribute(GlobalConstant.SESSION_INFO, sessionInfo);
	} else {
		j.setMsg("用户名或密码错误！");
	}
	return j;
    }
    
    @ResponseBody
    @RequestMapping(params="logout")
    public Json logout(HttpSession session) {
	Json j = new Json();
	if (session != null) {
		session.invalidate();
	}
	j.setSuccess(true);
	j.setMsg("注销成功！");
	return j;
    }
    
    @RequestMapping(params="index",method=RequestMethod.GET)
    public String index(){
	return "handan/index";
    }
    
    @RequestMapping(params="room",method=RequestMethod.GET)
    public String room(){
//	List<LmtChat> chats = chatService.queryList();
//	model.addAttribute("chats", chats);
	return "handan/main/room";
    }
    
    @RequestMapping(params="vedio",method=RequestMethod.GET)
    public String vedio(){
	return "handan/main/vedio";
    }
    
    @RequestMapping(params="lecturer",method=RequestMethod.GET)
    public String lecturer(){
	return "handan/main/lecturer";
    }
    
    @RequestMapping(params="message",method=RequestMethod.GET)
    public String message(){
	return "handan/main/message";
    }
    
    @RequestMapping(params="users",method=RequestMethod.GET)
    public String users(){
	return "handan/main/users";
    }
    
    @RequestMapping(params="chat",method=RequestMethod.GET)
    public String chat(){
	return "handan/main/chat";
    }
    
    @RequestMapping(params="top",method=RequestMethod.GET)
    public String top(){
	return "handan/main/top";
    }
    
    
    
}
