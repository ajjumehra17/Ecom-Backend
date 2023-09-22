package com.test.tst.model;

	
import com.test.tst.payload.CategoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



	@Entity
	@Table(name="product")
	public class Product {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	
		private int proId;
		private String pro_name;
		private int pro_price;
		private boolean pro_stocks;
		private int pro_quantity;
		private boolean live=true;
		private String pro_image;
		private String pro_des;
		
		@ManyToOne(fetch = FetchType.EAGER)
		private Category category;
		
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
	
	    public String getPro_image() {
			return pro_image;
		}
		public void setPro_image(String pro_image) {
			this.pro_image = pro_image;
		}

	
		public int getProId() {
			return proId;
		}
		public void setProId(int proId) {
			this.proId = proId;
		}
		public String getPro_name() {
			return pro_name;
		}
		public void setPro_name(String pro_name) {
			this.pro_name = pro_name;
		}
		public int getPro_price() {
			return pro_price;
		}
		public void setPro_price(int pro_price) {
			this.pro_price = pro_price;
		}
		public boolean isPro_stocks() {
			return pro_stocks;
		}
		public void setPro_stocks(boolean pro_stocks) {
			this.pro_stocks = pro_stocks;
		}
		public int getPro_quantity() {
			return pro_quantity;
		}
		public void setPro_quantity(int pro_quantity) {
			this.pro_quantity = pro_quantity;
		}
		public boolean isLive() {
			return live;
		}
		public void setLive(boolean live) {
			this.live = live;
		}
		public String getPro_imageName() {
			return pro_image;
		}
		public void setPro_imageName(String pro_imageName) {
			this.pro_image = pro_imageName;
		}
		public String getPro_des() {
			return pro_des;
		}
		public void setPro_des(String pro_des) {
			this.pro_des = pro_des;
		}
	    
	    
		
	}

