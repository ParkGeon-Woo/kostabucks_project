package com.my.vo;

import java.util.Date;

public class Drink {
	public int drink_no;
	public int drink_theme_no;
	public int drink_nutrition_no;
	public int drink_explanation_no;
	public int drink_allergy_no;
	public int drink_origin_no;
	public Date drink_release_date;
	public String drink_name_kor;
	public String drink_name_eng;
	public int drink_caffeine;
	public int drink_price;
	public int drink_limited_flag;
	public int drink_category_no;
	public Category category;
	
//	public Drink(int drink_no, int drink_theme_no, int drink_nutrition_no, int drink_explanation_no,
//			int drink_allergy_no, int drink_origin_no, Date drink_release_date, String drink_name_kor,
//			String drink_name_eng, int drink_caffeine, int drink_price, int drink_limited_flag, int drink_category_no,
//			Category category) {
//		super();
//		this.drink_no = drink_no;
//		this.drink_theme_no = drink_theme_no;
//		this.drink_nutrition_no = drink_nutrition_no;
//		this.drink_explanation_no = drink_explanation_no;
//		this.drink_allergy_no = drink_allergy_no;
//		this.drink_origin_no = drink_origin_no;
//		this.drink_release_date = drink_release_date;
//		this.drink_name_kor = drink_name_kor;
//		this.drink_name_eng = drink_name_eng;
//		this.drink_caffeine = drink_caffeine;
//		this.drink_price = drink_price;
//		this.drink_limited_flag = drink_limited_flag;
//		this.drink_category_no = drink_category_no;
//		this.category = category;
//	}
	
	@Override
	public String toString() {
		return "Drink [drink_no=" + drink_no + ", drink_theme_no=" + drink_theme_no + ", drink_nutrition_no="
				+ drink_nutrition_no + ", drink_explanation_no=" + drink_explanation_no + ", drink_allergy_no="
				+ drink_allergy_no + ", drink_origin_no=" + drink_origin_no + ", drink_release_date="
				+ drink_release_date + ", drink_name_kor=" + drink_name_kor + ", drink_name_eng=" + drink_name_eng
				+ ", drink_caffeine=" + drink_caffeine + ", drink_price=" + drink_price + ", drink_limited_flag="
				+ drink_limited_flag + ", drink_category_no=" + drink_category_no + ", category=" + category + "]";
	}
	public int getDrink_no() {
		return drink_no;
	}
	public void setDrink_no(int drink_no) {
		this.drink_no = drink_no;
	}
	public int getDrink_theme_no() {
		return drink_theme_no;
	}
	public void setDrink_theme_no(int drink_theme_no) {
		this.drink_theme_no = drink_theme_no;
	}
	public int getDrink_nutrition_no() {
		return drink_nutrition_no;
	}
	public void setDrink_nutrition_no(int drink_nutrition_no) {
		this.drink_nutrition_no = drink_nutrition_no;
	}
	public int getDrink_explanation_no() {
		return drink_explanation_no;
	}
	public void setDrink_explanation_no(int drink_explanation_no) {
		this.drink_explanation_no = drink_explanation_no;
	}
	public int getDrink_allergy_no() {
		return drink_allergy_no;
	}
	public void setDrink_allergy_no(int drink_allergy_no) {
		this.drink_allergy_no = drink_allergy_no;
	}
	public int getDrink_origin_no() {
		return drink_origin_no;
	}
	public void setDrink_origin_no(int drink_origin_no) {
		this.drink_origin_no = drink_origin_no;
	}
	public Date getDrink_release_date() {
		return drink_release_date;
	}
	public void setDrink_release_date(Date drink_release_date) {
		this.drink_release_date = drink_release_date;
	}
	public String getDrink_name_kor() {
		return drink_name_kor;
	}
	public void setDrink_name_kor(String drink_name_kor) {
		this.drink_name_kor = drink_name_kor;
	}
	public String getDrink_name_eng() {
		return drink_name_eng;
	}
	public void setDrink_name_eng(String drink_name_eng) {
		this.drink_name_eng = drink_name_eng;
	}
	public int getDrink_caffeine() {
		return drink_caffeine;
	}
	public void setDrink_caffeine(int drink_caffeine) {
		this.drink_caffeine = drink_caffeine;
	}
	public int getDrink_price() {
		return drink_price;
	}
	public void setDrink_price(int drink_price) {
		this.drink_price = drink_price;
	}
	public int getDrink_limited_flag() {
		return drink_limited_flag;
	}
	public void setDrink_limited_flag(int drink_limited_flag) {
		this.drink_limited_flag = drink_limited_flag;
	}
	public int getDrink_category_no() {
		return drink_category_no;
	}
	public void setDrink_category_no(int drink_category_no) {
		this.drink_category_no = drink_category_no;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
