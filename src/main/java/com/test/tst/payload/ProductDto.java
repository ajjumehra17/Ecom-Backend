package com.test.tst.payload;

//Data Transfer Object
public class ProductDto {

	private int pro_id;
	private String pro_name;
	private int pro_price;
    private boolean pro_stocks;
    private int pro_quantity;
    private boolean live=true;
    private String pro_image;
    private String pro_des;
    
	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
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

	public String getPro_image() {
		return pro_image;
	}

	public void setPro_image(String pro_image) {
		this.pro_image = pro_image;
	}

	public String getPro_des() {
		return pro_des;
	}

	public void setPro_des(String pro_des) {
		this.pro_des = pro_des;
	}

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
