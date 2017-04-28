package lmt.core.service.sys;

import java.util.List;

import lmt.core.pageModel.base.PageFilter;
import lmt.core.pageModel.sys.Dictionary;

public interface DictionaryServiceI {

	public List<Dictionary> dataGrid(Dictionary dictionary, PageFilter ph);

	public Long count(Dictionary dictionary, PageFilter ph);

	public void add(Dictionary dictionary);

	public void delete(String id);

	public void edit(Dictionary dictionary);

	public Dictionary get(String id);

	public List<Dictionary> combox(String code);

	public Dictionary checkUnique(Dictionary dictionary);

}
