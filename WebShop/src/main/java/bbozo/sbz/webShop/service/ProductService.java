package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.Product;
import bbozo.sbz.webShop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product findOne(Long id){
		return productRepository.findOne(id);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public List<Product> findAllBySpecification(Specification<Product> specifications) {
		return productRepository.findAll(specifications);
	}
	
	public Product findByCode(int code) {
		return productRepository.findByCode(code);
	}
	
	public List<Product> findNewest(){
		return productRepository.findTop9ByOrderByIdDesc();
	}
	
	public List<Product> findByCategory(Long id){
		return productRepository.findByProductCategory_Id(id);
	}
	
	public List<Product> findBySupercategory(Long id){
		return productRepository.findByProductCategory_Supercategory_Id(id);
	}
	
	public List<Product> findByName(String name) {
		return productRepository.findByNameContaining(name);
	}
	
	public List<Product> findByLowerPrice(double price) {
		return productRepository.findByPriceLessThan(price);
	}
	
	public List<Product> findByGreaterPrice(double price) {
		return productRepository.findByPriceGreaterThan(price);
	}
	
	public List<Product> findByPrice(double priceFrom, double priceTo) {
		return productRepository.findByPriceBetween(priceFrom, priceTo);
	}
	
	public List<Product> findByNameAndLowerPrice(String name, double price) {
		return productRepository.findByNameContainingAndPriceLessThan(name, price);
	}
	
	public List<Product> findByNameAndGreaterPrice(String name, double price) {
		return productRepository.findByNameContainingAndPriceGreaterThan(name, price);
	}
	
	public List<Product> findByNameAndPrice(String name, double priceFrom, double priceTo) {
		return productRepository.findByNameContainingAndPriceBetween(name, priceFrom, priceTo);
	}
	
	public List<Product> findProductsToOrder(){
		return productRepository.find();
	}
	
}
