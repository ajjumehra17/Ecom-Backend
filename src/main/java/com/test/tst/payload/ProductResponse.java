 package com.test.tst.payload;

import java.util.List;
import com.test.tst.model.Product;


public class ProductResponse {

	private  List<ProductDto> content;
	private int pageNumber;
	private int pageSize;
	private int totalPage;
	private boolean lastPage;
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<ProductDto> getContent() {
		return content;
	}
	public void setContent(List<ProductDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	

}
