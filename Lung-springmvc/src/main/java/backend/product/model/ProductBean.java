package backend.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Table")
public class ProductBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pd_id;
	String pd_items;
	String pd_product_name;
	String pd_image;
	String pd_content;
	String pd_specification;
	Integer pd_quantity;
	Integer pd_amount;

	public ProductBean() {

	}

	public ProductBean(Integer pd_id, String pd_items, String pd_product_name, String pd_image, String pd_content,
			String pd_specification, Integer pd_quantity, Integer pd_amount) {
		super();

		this.pd_id = pd_id;
		this.pd_items = pd_items;
		this.pd_product_name = pd_product_name;
		this.pd_image = pd_image;
		this.pd_content = pd_content;
		this.pd_specification = pd_specification;
		this.pd_quantity = pd_quantity;
		this.pd_amount = pd_amount;
	}

	public ProductBean(String pd_items, String pd_product_name, String pd_image, String pd_content, String pd_specification,
			Integer pd_quantity, Integer pd_amount) {
		super();
		this.pd_items = pd_items;
		this.pd_product_name = pd_product_name;
		this.pd_image = pd_image;
		this.pd_content = pd_content;
		this.pd_specification = pd_specification;
		this.pd_quantity = pd_quantity;
		this.pd_amount = pd_amount;
	}

	public String getPd_image() {
		return pd_image;
	}

	public void sePd_image(String pd_image) {
		this.pd_image = pd_image;
	}

	public ProductBean(Integer pd_id) {
		this.pd_id = pd_id;
	}

	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}

	public void setPd_items(String pd_items) {
		this.pd_items = pd_items;
	}

	public String getPd_items() {
		return pd_items;
	}

	public void setPd_product_name(String pd_product_name) {
		this.pd_product_name = pd_product_name;
	}

	public String getPd_product_name() {
		return pd_product_name;
	}

	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}

	public String getPd_content() {
		return pd_content;
	}

	public void setPd_specification(String pd_specification) {
		this.pd_specification = pd_specification;
	}

	public String getPd_specification() {
		return pd_specification;
	}

	public void setPd_quantity(Integer pd_quantity) {
		this.pd_quantity = pd_quantity;
	}

	public Integer getPd_quantity() {
		return pd_quantity;
	}

	public void setPd_amount(Integer pd_amount) {
		this.pd_amount = pd_amount;
	}

	public Integer getPd_amount() {
		return pd_amount;
	}

}