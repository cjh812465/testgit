package lmt.core.service.mb;

import java.util.List;

import lmt.core.pageModel.base.PageFilter;
import lmt.core.pageModel.base.Tree;
import lmt.core.pageModel.mb.Member;

public interface MemberServiceI {

	public List<Member> dataGrid(Member member, PageFilter ph);

	public Long count(Member member, PageFilter ph);

	public void add(Member member);

	public void delete(String id);

	public void edit(Member member);

	public Member get(String id);

	public void grant(Member member);

	public List<Tree> tree();

}
