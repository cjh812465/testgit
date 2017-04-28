package lmt.core.controller.mb;

import java.util.List;

import lmt.core.controller.base.BaseController;
import lmt.core.pageModel.base.Grid;
import lmt.core.pageModel.base.Json;
import lmt.core.pageModel.base.PageFilter;
import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.mb.Member;
import lmt.core.service.mb.MemberServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberServiceI memberService;

	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(Member member, PageFilter ph) {
		Grid grid = new Grid();
		grid.setRows(memberService.dataGrid(member, ph));
		grid.setTotal(memberService.count(member, ph));
		return grid;
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree() {
		return memberService.tree();
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Member member) {
		Json j = new Json();
		memberService.add(member);
		j.setSuccess(true);
		j.setMsg("添加成功！");
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		memberService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Member get(String id)  {
		return memberService.get(id);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Member member) {
		Json j = new Json();
		memberService.edit(member);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	@RequestMapping("/grant")
	@ResponseBody
	public Json grant(Member member) {
		Json j = new Json();
		memberService.grant(member);
		j.setMsg("授权成功！");
		j.setSuccess(true);
		return j;
	}

}
