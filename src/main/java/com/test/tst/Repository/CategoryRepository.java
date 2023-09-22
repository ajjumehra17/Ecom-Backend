package com.test.tst.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.test.tst.model.Category;

public interface CategoryRepository  extends JpaRepository<Category ,Integer>{

	
}
