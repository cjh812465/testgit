package lmt.core.service.sys;

import java.util.List;

import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.sys.Dictionarytype;

public interface DictionarytypeServiceI {


	public void add(Dictionarytype dictionarytype);

	public void delete(String id);

	public void edit(Dictionarytype dictionarytype);

	public Dictionarytype get(String id);

	public List<Tree> tree();


}
