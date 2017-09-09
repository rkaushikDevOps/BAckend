package ecom.test.BackEnd.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prod_id;
	
	private String prod_brand;
	
	private String prod_name;
	
	private String prod_description;
	
	private String supplier;
	private String prodImg_url;
	
	private long price;
	
	private int quantity;
	
	private boolean ActiveIs = true;

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_brand() {
		return prod_brand;
	}

	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_description() {
		return prod_description;
	}

	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getProdImg_url() {
		return prodImg_url;
	}

	public void setProdImg_url(String prodImg_url) {
		this.prodImg_url = prodImg_url;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActiveIs() {
		return ActiveIs;
	}

	public void setActiveIs(boolean activeIs) {
		ActiveIs = activeIs;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_brand=" + prod_brand + ", prod_name=" + prod_name
				+ ", prod_description=" + prod_description + ", supplier=" + supplier + ", prodImg_url=" + prodImg_url
				+ ", price=" + price + ", quantity=" + quantity + ", ActiveIs=" + ActiveIs + "]";
	}
	
	
}
