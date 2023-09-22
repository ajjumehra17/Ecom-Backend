package com.test.tst.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tst.model.Category;
import com.test.tst.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>  {
	List<Product> findByCategory(Category category);


}
