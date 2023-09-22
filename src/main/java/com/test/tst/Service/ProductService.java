package com.test.tst.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.tst.Repository.CategoryRepository;
import com.test.tst.Repository.ProductRepository;
import com.test.tst.exception.ResourceNotFoundException;
import com.test.tst.model.Category;
import com.test.tst.model.Product;
import com.test.tst.payload.CategoryDto;
import com.test.tst.payload.ProductDto;
import com.test.tst.payload.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	 private CategoryRepository catRepo;
	 public ProductDto createProduct(ProductDto productDto , int catid ) {
		 
		//fetch Category is available or not 
		Category  cat= this.catRepo.findById(catid).orElseThrow(()->new ResourceNotFoundException("Not Found any Category "));
  
	  	//ProductDto to Product 
		Product product = toEntity(productDto,catid);
		product.setCategory(cat);
		Product save = this.productRepo.save(product);
	  
		  //product to ProductDto
		  ProductDto dto= toDto(save);
		   return dto;
	  }
  
  //Show Products
  public ProductResponse viewAll(int pageNumber,int pageSize, String sortBy ,String sortDir){
	  Sort sort= null;
	   if (sortDir.trim().toLowerCase().equals("asc"))
	   {
		   sort = Sort.by(sortBy).ascending();
		   System.out.println(sort);
	   }
	   else {
		   Sort.by(sortBy).descending();
		   System.out.println(sort);
	   }
	   
	   Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
	   Page<Product> page =this.productRepo.findAll(pageable);
	   List<Product> pageProduct = page.getContent();
	   List<Product> product= pageProduct.stream().filter(p ->p.isLive()).collect(Collectors.toList());
	   List<ProductDto> productDto=product.stream().map(p->this.toDto(p)).collect(Collectors.toList());
	   
	   ProductResponse response= new ProductResponse();
	   response.setContent(productDto);
	   response.setPageNumber(page.getNumber());
	   response.setPageSize(page.getSize());
	   response.setTotalPage(page.getTotalPages());
	   response.setLastPage(page.isLast());
	   
	   	//ProductDto to product
		//	  List<Product> findAll=productRepo.findAll();
		//	  List<ProductDto> findAllDto=findAll.stream().map(product ->this.toDto(product)).collect(Collectors.toList()); 
	  return response;
  }
  
  //Show Product By Id
  public ProductDto viewProductById(int pid){
	  Product findById = productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid +"this id product Not found"));
	  ProductDto dto=this.toDto(findById);
	  return  dto;
  }
  //Delete Products
  public void deleteProduct(int pid) {
	  Product byId =productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid +"this id product Not found"));
				
	  productRepo.delete(byId);
  }
  
  //Update Product
  public ProductDto updateProduct(int pid, ProductDto newProduct ) {
	Product  oldp =  productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid +"this id product Not found"));
	oldp.setPro_imageName(newProduct.getPro_image());
	oldp.setLive(newProduct.isLive());
	oldp.setPro_stocks(true);
	oldp.setPro_price(newProduct.getPro_price());
	oldp.setPro_des(newProduct.getPro_des());
	oldp.setPro_quantity(newProduct.getPro_quantity());
	oldp.setPro_name(newProduct.getPro_name());
	Product save=productRepo.save(oldp);
	ProductDto dto=this.toDto(save);
	return  dto;
  }
  
  //Find Product By CAtegory
  public List<ProductDto>findProductByCategory(int catId) {
	Category cat= this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException(+catId +"this id Cat Not found"));;
	List<Product> findByCategoryList= this.productRepo.findByCategory(cat); 
	List<ProductDto> collect= findByCategoryList.stream().map(product->toDto(product)).collect(Collectors.toList());
	return collect ;
}
  
  //ProductDto to Product

  public Product toEntity(ProductDto productDto,int catid) {
	  Product p=new Product();
	  p.setPro_name(productDto.getPro_name());
	  p.setProId(productDto.getPro_id());
	  p.setPro_price(productDto.getPro_price());
	  p.setPro_stocks(productDto.isPro_stocks());
	  p.setPro_des(productDto.getPro_des());
	  p.setPro_quantity(productDto.getPro_quantity());
	  p.setLive(productDto.isLive());
	  p.setPro_imageName(productDto.getPro_image());
	  
	  //Change category To CategoryDto
	  CategoryDto catDto = new CategoryDto();
	  catDto.setCategoryId(catid); // Set the categoryId with the provided catId
	  catDto.setTitle(p.getCategory().getTitle());

	  // Create a new Category object and set its properties manually
	  Category category = new Category();
	  category.setCategoryId(catDto.getCategoryId());
	  category.setTitle(catDto.getTitle());
  
	  // Set the Category to the Product
	  p.setCategory(category);
	  return p;
  }
   
  //product to Product
  public ProductDto toDto(Product product) {
	  ProductDto pDto= new ProductDto();
	  pDto.setPro_id(product.getProId());
	  pDto.setPro_name(product.getPro_name());
	  pDto.setPro_price(product.getPro_price());
	  pDto.setPro_quantity(product.getPro_quantity());
	  pDto.setPro_stocks(product.isPro_stocks());
	  pDto.setPro_des(product.getPro_des());
	  pDto.setLive(product.isLive());
	  return pDto;
  }
  
}
