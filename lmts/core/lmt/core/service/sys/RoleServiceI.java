package lmt.core.service.sys;

import java.util.List;

import lmt.core.pageModel.base.PageFilter;
import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.sys.Role;

public interface RoleServiceI {

	public List<Role> dataGrid(Role role, PageFilter ph);

	public Long count(Role role, PageFilter ph);

	public void add(Role role);

	public void delete(String id);

	public void edit(Role role);

	public Role get(String id);

	public void grant(Role role);

	public List<Tree> tree();

}
