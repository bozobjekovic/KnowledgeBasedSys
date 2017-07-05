package bbozo.sbz.webShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bbozo.sbz.webShop.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	
	List<ProductCategory> findBySupercategory(ProductCategory productCategory);
	
	List<ProductCategory> findBySupercategoryNotNull();

}
