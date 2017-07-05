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

import bbozo.sbz.webShop.model.ConsumptionLimit;
import bbozo.sbz.webShop.model.CustomerCategory;
import bbozo.sbz.webShop.service.ConsumptionLimitService;
import bbozo.sbz.webShop.service.CustomerCategoryService;

@RestController
@RequestMapping(value = "webShop/customerCategory")
public class CustomerCategoryController {
	
	@Autowired
	CustomerCategoryService customerCategoryService;
	
	@Autowired
	ConsumptionLimitService consumptionLimitService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerCategory>> getCustomerCategories() {
		List<CustomerCategory> customerCategories = customerCategoryService.findAll();
		return new ResponseEntity<>(customerCategories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerCategory> getInvoice(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		CustomerCategory customerCategory = customerCategoryService.findOne(id);
		if (customerCategory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customerCategory, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ConsumptionLimit> saveCustomerCategory(@RequestBody ConsumptionLimit limit){
		if(!checkInput(limit)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		consumptionLimitService.save(limit);
		return new ResponseEntity<>(limit, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public ResponseEntity<ConsumptionLimit> addToCustomerCategory(@PathVariable Long id, @RequestBody ConsumptionLimit limit){
		if(!checkInput(limit)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		CustomerCategory customerCategory = customerCategoryService.findOne(id);
		if (customerCategory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerCategory.getConsumptionLimit().add(limit);
		customerCategoryService.save(customerCategory);
		return new ResponseEntity<>(limit, HttpStatus.OK);
	}

	private boolean checkInput(ConsumptionLimit category) {
		// TODO Auto-generated method stub
		return true;
	}
}
