package lmt.core.pageModel.mb;


public class Mbgroup implements java.io.Serializable {

	private String id;
  	private String name;
  	private Integer credit; //'消费金额',
  	private Integer discount; //'折扣'
  	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
