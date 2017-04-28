package lmt.core.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lmt.core.controller.base.BaseController;
import lmt.core.pageModel.base.Json;
import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.sys.Organization;
import lmt.core.service.base.ServiceException;
import lmt.core.service.sys.OrganizationServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

	@Autowired
	private OrganizationServiceI organizationService;
	
	@RequestMapping("/manager")
	public String manager() {
		return "/admin/organization";
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<Organization> treeGrid() {
		return organizationService.treeGrid();
	}

	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		return organizationService.tree();
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/admin/organizationAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Organization organization) {
		Json j = new Json();
		try {
			organizationService.add(organization);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Organization get(String id) {
		return organizationService.get(id);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request,String id) {
		Organization o = organizationService.get(id);
		request.setAttribute("organization", o);
		return "/admin/organizationEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Organization org) throws InterruptedException {
		Json j = new Json();
		try {
			organizationService.edit(org);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		try {
			organizationService.delete(id);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (ServiceException e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
