package com.test.tst.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tst.Repository.CategoryRepository;
import com.test.tst.exception.ResourceNotFoundException;
import com.test.tst.model.Category;
import com.test.tst.payload.CategoryDto;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ModelMapper mapper;
	
	public CategoryDto create(CategoryDto dto) {
		
		//CategoryDto to Category 
		Category cat= this.mapper.map( dto, Category.class);
		Category save= this.catRepo.save(cat);
		
	//cat to CatDto
	return this.mapper.map(save,CategoryDto.class);
	}
	
	     
	public CategoryDto update(CategoryDto newcat, int catId) {
		// category to category Dto
		Category oldcat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("This Category Id Not Found"));
		
		oldcat.setCategoryId(newcat.getCategoryId());
		oldcat.setTitle(newcat.getTitle());
		oldcat.setTitle(newcat.getTitle());
		Category save = this.catRepo.save(oldcat);
		
		return this.mapper.map(save, CategoryDto.class);
	}
	
	public void delete(int catId) {
		Category cat = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("This Category Id Not Found"));
		this.catRepo.delete(cat);
		
	} 
	public CategoryDto getById(int catId) {
		Category getById = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("This Category Id Not Found"));
		
		return this.mapper.map(getById, CategoryDto.class);
	}
	public List<CategoryDto> getAll(){
		List<Category>  findAll = this.catRepo.findAll();
		List<CategoryDto> allDto= findAll.stream().map(cat->this.mapper.map(cat , CategoryDto.class)).collect(Collectors.toList());
		return (List<CategoryDto>) allDto;
	}
}
