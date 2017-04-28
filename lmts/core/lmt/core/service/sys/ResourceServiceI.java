package lmt.core.service.sys;

import java.util.List;

import lmt.core.pageModel.base.SessionInfo;
import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.sys.Resource;

public interface ResourceServiceI {

	public List<Resource> treeGrid();

	public void add(Resource resource);

	public void delete(String id);

	public void edit(Resource resource);

	public Resource get(String id);

	public List<Tree> tree(SessionInfo sessionInfo);

	public List<Tree> allTree(boolean flag);

	public List<String> resourceAllList();

}
