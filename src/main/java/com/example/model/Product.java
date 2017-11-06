package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="PRODUCT")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="product_id_seq")
	@SequenceGenerator(name="product_id_seq", sequenceName="product_seq", allocationSize=1)
	@Column (name="PRODUCT_ID", length= 19, nullable= false, unique= true)
	private long product_id;
	
	@Column(name="PRODUCT_NAME", length=20, nullable=false, unique=true)
	private String product_name;
	
	@Column(name="CATEGORY_1", length=20, nullable=false)
	private String category_1;
	
	@Column(name="CATEGORY_2", length=20, nullable=true)
	private String category_2;
	
	@Column(name="CATEGORY_3", length=20, nullable=true)
	private String category_3;
	
	
	@Column(name="MANUFACTURER_NAME", length=20, nullable=false)
	private String manufacturer_name;
	
	
	
	@Column(name="PRODUCT_PRICE", length=8, nullable=false)
	private double product_price;



	public long getProduct_id() {
		return product_id;
	}



	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getCategory_1() {
		return category_1;
	}



	public void setCategory_1(String category_1) {
		this.category_1 = category_1;
	}



	public String getCategory_2() {
		return category_2;
	}



	public void setCategory_2(String category_2) {
		this.category_2 = category_2;
	}



	public String getCategory_3() {
		return category_3;
	}



	public void setCategory_3(String category_3) {
		this.category_3 = category_3;
	}



	public String getManufacturer_name() {
		return manufacturer_name;
	}



	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}



	public double getProduct_price() {
		return product_price;
	}



	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
