package lmt.core.pageModel.base;

import java.util.List;

public class SessionInfo implements java.io.Serializable {

    private String id;// 用户ID
    private String loginname;// 登录名
    private String name;// 姓名
    private String ip;// 用户IP
    private String nicname;// 昵称

    private List<String> resourceList;// 用户可以访问的资源地址列表

    private List<String> resourceAllList;

    public List<String> getResourceList() {
	return resourceList;
    }

    public void setResourceList(List<String> resourceList) {
	this.resourceList = resourceList;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getLoginname() {
	return loginname;
    }

    public void setLoginname(String loginname) {
	this.loginname = loginname;
    }

    public List<String> getResourceAllList() {
	return resourceAllList;
    }

    public void setResourceAllList(List<String> resourceAllList) {
	this.resourceAllList = resourceAllList;
    }

    public String getNicname() {
	return nicname;
    }

    public void setNicname(String nicname) {
	this.nicname = nicname;
    }

    @Override
    public String toString() {
	return this.name;
    }

}
