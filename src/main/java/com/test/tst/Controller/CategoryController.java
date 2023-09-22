package com.test.tst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tst.Service.CategoryService;
import com.test.tst.payload.ApiResponse;
import com.test.tst.payload.CategoryDto;

@RestController
@RequestMapping("/categories")
public class CategoryController {

		@Autowired
	private CategoryService catService;
	private CategoryDto create;

   // Create Category 
	@PostMapping("/create")
	public ResponseEntity<CategoryDto>create(@RequestBody CategoryDto catDto){
		CategoryDto create=  this.catService.create(catDto);
		return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);
		
	}
	
	//update Category
	@PostMapping("/update/{catid}")
	public ResponseEntity<CategoryDto>update(@RequestBody CategoryDto catDto,@PathVariable int catid ){
		System.out.println(catid);
		CategoryDto update=this.catService.update(catDto,catid);
		return new ResponseEntity<CategoryDto>(update,HttpStatus.OK);
	} 
	
	//Delete Category
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse>delete(@PathVariable int catId){
		this.catService.delete(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Delete SuccussFully",true),HttpStatus.OK);
	}
	
	//get Category By Id 
	@GetMapping("getByid/{catId}")
	public ResponseEntity<CategoryDto>getById(@PathVariable int catId){
		CategoryDto getByid= this.catService.getById(catId);
		return new ResponseEntity<CategoryDto>(getByid,HttpStatus.OK);
	}
	
	//Get All Category 
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>>getAll(){
	List<CategoryDto> all=	this.catService.getAll();
		return new ResponseEntity<List<CategoryDto>>(all,HttpStatus.OK);
	}
}
