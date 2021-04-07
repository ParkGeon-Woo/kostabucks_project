package com.my.vo;

public class Category {
	public String category_name;
	public int category_no;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String category_name, int category_no) {
		super();
		this.category_name = category_name;
		this.category_no = category_no;
	}
	
	@Override
	public String toString() {
		return "Category [category_name=" + category_name + ", category_no=" + category_no + "]";
	}
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	
	
	
	
}
