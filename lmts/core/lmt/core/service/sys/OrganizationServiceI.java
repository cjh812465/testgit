package lmt.core.service.sys;

import java.util.List;

import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.sys.Organization;

public interface OrganizationServiceI {

	public List<Organization> treeGrid();

	public void add(Organization organization);

	public void delete(String id);

	public void edit(Organization organization);

	public Organization get(String id);

	public List<Tree> tree();

}
