package com.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("sample")
public class Product {

	 private Integer Id;
	 private String pName;
	 private String pCode;
	 
	 
	 
	 
	public Product() {
		super();
	}
	public Product(Integer id, String pName, String pCode) {
		super();
		Id = id;
		this.pName = pName;
		this.pCode = pCode;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	 
}
