package bbozo.sbz.webShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bbozo.sbz.webShop.model.Product;
import bbozo.sbz.webShop.service.ProductService;

@RestController
@RequestMapping(value = "webShop/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Product product = productService.findOne(id);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productService.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getNewProducts() {
		List<Product> products = productService.findNewest();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long category) {
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Product> products = productService.findByCategory(category);
		if(products.size() == 0){
			products = productService.findBySupercategory(category);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		if(!checkInput(product)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Product existProduct = productService.findByCode(product.getCode());
		if (existProduct != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		productService.save(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> searchProducts(@RequestParam(value = "search") String search){
		List<Product> products = new ArrayList<>();
		try {
			int code = Integer.parseInt(search);
			products.add(productService.findByCode(code));
		} catch (Exception e) {
			String[] params = search.split("#");
			if (params[0].equals("")) {
				if (!params[1].equals("null")) {
					if (params[2].equals("null")) {
						products = productService.findByGreaterPrice(Double.parseDouble(params[1]));
					} else {
						products = productService.findByPrice(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
					}
				} else {
					products = productService.findByLowerPrice(Double.parseDouble(params[2]));
				}
			} else {
				if (!params[1].equals("null")) {
					if (!params[2].equals("null")) {
						products = productService.findByNameAndPrice(params[0], Double.parseDouble(params[1]), Double.parseDouble(params[2]));
					} else {
						products = productService.findByNameAndGreaterPrice(params[0], Double.parseDouble(params[1]));
					}
				} else if (!params[2].equals("null")) {
					products = productService.findByNameAndLowerPrice(params[0], Double.parseDouble(params[2]));
				} else {
					products = productService.findByName(params[0]);
				}
			}
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> orderProducts(){
		List<Product> products = productService.findProductsToOrder();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/{id}/quantity/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<Void> orderProduct(@PathVariable Long id, @PathVariable int quantity){
		if (id == null || quantity == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Product product = productService.findOne(id);
		product.setStock(product.getStock() + quantity);
		productService.save(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private boolean checkInput(Product product) {
		// TODO Auto-generated method stub
		return true;
	}
}
