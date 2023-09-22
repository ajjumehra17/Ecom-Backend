package com.test.tst.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import com.test.tst.Service.ProductService;
import com.test.tst.model.Product;
import com.test.tst.payload.AppConstant;
import com.test.tst.payload.ProductDto;
import com.test.tst.payload.ProductResponse;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/creates/{catid}")
	@ResponseBody
	//products/creates
   public ResponseEntity<ProductDto > createProduct(@RequestBody ProductDto product, @PathVariable int catid) {
		//System.out.println(product.getPro_name());
		ProductDto createProduct=productService.createProduct(product,catid);  
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}
	
	//view Product
	
	@GetMapping("/view")
	public ProductResponse viewAllProduct(
		@RequestParam(value ="pageNumber",defaultValue=AppConstant.PAGE_NUMBER_STRING,required =false) int pageNumber,
	    @RequestParam(value = "pageSize" , defaultValue = AppConstant.PAGE_SIZE_STRING,required = false) int pageSize,
		@RequestParam(value ="sortBy", defaultValue = AppConstant.SORT_BY_STRING , required = false) String sortBy,
		@RequestParam(value = "sortDir" , defaultValue = AppConstant.SORT_DIRECTION_STRING,required = false) String sortDir)
		{
		
		ProductResponse response = productService.viewAll(pageNumber, pageSize, sortBy, sortDir);
		return response;
	    }
	
		//View Product By Id 
		@GetMapping("view/{proId}")
		public ResponseEntity<ProductDto> viewProductById(@PathVariable int proId){
			ProductDto  viewById = productService.viewProductById(proId);
			return new ResponseEntity<ProductDto>(viewById,HttpStatus.OK);
		}
	
	//delete Product 
	@DeleteMapping("/del/{proId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int proId){
		productService.deleteProduct(proId);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
	
	//Update Product 
	@PutMapping("/update/{proId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int proId,@RequestBody ProductDto newProduct ) {
		ProductDto update=productService.updateProduct(proId,newProduct);
		return new ResponseEntity<ProductDto>(update,HttpStatus.ACCEPTED);
	}
	
	// Find Product By category 
	@GetMapping("/category/{catId}")
	public ResponseEntity<List<ProductDto>>getProductByCategory(@PathVariable int catId ){
		List<ProductDto> pcat= this.productService.findProductByCategory(catId);
		return new ResponseEntity<List<ProductDto>>(pcat,HttpStatus.ACCEPTED);
		}
}
