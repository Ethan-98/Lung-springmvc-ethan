package backend.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Table")
public class OrderBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer od_id;
	String od_name;
	String od_catalogue;
	String od_content;
	String od_amount;
	Integer od_number;
	Integer od_money;

	public OrderBean() {
	}

	public OrderBean(String od_name, String od_catalogue, String od_content, String od_amount, Integer od_number,
			Integer od_money) {
		super();
		this.od_name = od_name;
		this.od_catalogue = od_catalogue;
		this.od_content = od_content;
		this.od_amount = od_amount;
		this.od_number = od_number;
		this.od_money = od_money;
	}

	public OrderBean(Integer od_id, String od_name, String od_catalogue, String od_content, String od_amount,
			Integer od_number, Integer od_money) {
		super();
		this.od_id = od_id;
		this.od_name = od_name;
		this.od_catalogue = od_catalogue;
		this.od_content = od_content;
		this.od_amount = od_amount;
		this.od_number = od_number;
		this.od_money = od_money;
	}

	public OrderBean(Integer od_id) {
		this.od_id = od_id;
	}

	public Integer getOd_id() {
		return od_id;
	}

	public void setOd_id(Integer od_id) {
		this.od_id = od_id;
	}

	public String getOd_name() {
		return od_name;
	}

	public void setOd_name(String od_name) {
		this.od_name = od_name;
	}

	public String getOd_catalogue() {
		return od_catalogue;
	}

	public void setOd_catalogue(String od_catalogue) {
		this.od_catalogue = od_catalogue;
	}

	public String getOd_content() {
		return od_content;
	}

	public void setOd_content(String od_content) {
		this.od_content = od_content;
	}

	public String getOd_amount() {
		return od_amount;
	}

	public void setOd_amount(String od_amount) {
		this.od_amount = od_amount;
	}

	public Integer getOd_number() {
		return od_number;
	}

	public void setOd_number(Integer od_number) {
		this.od_number = od_number;
	}

	public Integer getOd_money() {
		return od_money;
	}

	public void setOd_money(Integer od_money) {
		this.od_money = od_money;
	}

//	public String toString() {
//		return "Order [od_id=" + od_id + ", od_name=" + od_name + ", od_catalogue=" + od_catalogue + ", od_content="
//				+ od_content + ", od_amount=" + od_amount + ", od_number=" + od_number + ", od_money=" + od_money + "]";
//	}
}
