package lmt.core.service.mb;

import java.util.List;

import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.mb.Mbgroup;

public interface MbgroupServiceI {

	public List<Mbgroup> treeGrid();

	public void add(Mbgroup mbgroup);

	public void delete(String id);

	public void edit(Mbgroup mbgroup);

	public Mbgroup get(String id);

	public List<Tree> tree();

}
