package bbozo.sbz.webShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bbozo.sbz.webShop.model.ProductCategory;
import bbozo.sbz.webShop.service.ProductCategoryService;

@RestController
@RequestMapping(value = "webShop/productCategory")
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductCategory>> getProductCategories() {
		List<ProductCategory> productCategories = productCategoryService.findAll();
		return new ResponseEntity<>(productCategories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/supercategories", method = RequestMethod.GET)
	public ResponseEntity<List<ProductCategory>> getSuperCategories() {
		List<ProductCategory> productCategories = productCategoryService.findSupercategories();
		return new ResponseEntity<>(productCategories, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductCategory> saveProductCategory(@RequestBody ProductCategory category){
		if(!checkInput(category)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		productCategoryService.save(category);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	private boolean checkInput(ProductCategory category) {
		// TODO Auto-generated method stub
		return true;
	}

}
