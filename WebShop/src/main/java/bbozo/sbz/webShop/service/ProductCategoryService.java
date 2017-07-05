package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.ProductCategory;
import bbozo.sbz.webShop.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public ProductCategory findOne(Long id){
		return productCategoryRepository.findOne(id);
	}
	
	public List<ProductCategory> findAll(){
		return productCategoryRepository.findAll();
	}
	
	public ProductCategory save(ProductCategory productCategory){
		return productCategoryRepository.save(productCategory);
	}
	
	public List<ProductCategory> findSupercategories(){
		return productCategoryRepository.findBySupercategory(null);
	}
	
	public List<ProductCategory> findSubcategories(){
		return productCategoryRepository.findBySupercategoryNotNull();
	}
}
