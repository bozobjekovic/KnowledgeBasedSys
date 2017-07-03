package bbozo.sbz.webShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		productService.save(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> filterProducts(@RequestParam(value = "filter") String filter){
		SpecificationBuilder builder = new SpecificationBuilder();
		
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?(\\s\\w+?)?(\\_?(\\w+?(\\s\\w+?)?)?)*),");
		Matcher matcher = pattern.matcher(filter + ",");
		
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		
		Specification<Product> spec = builder.build();
		List<Product> products = productService.findAllBySpecification(spec);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}*/
	
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
