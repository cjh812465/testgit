package lmt.core.controller.mb;

import java.util.List;

import javax.servlet.http.HttpSession;

import lmt.core.controller.base.BaseController;
import lmt.core.pageModel.base.Json;
import lmt.core.pageModel.base.Tree;
import lmt.core.service.base.ServiceException;
import lmt.core.service.mb.MbgroupServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mbgroup")
public class MbgroupController extends BaseController {

	@Autowired
	private MbgroupServiceI mbgroupService;


	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		return mbgroupService.tree();
	}


	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		try {
			mbgroupService.delete(id);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (ServiceException e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}
}
