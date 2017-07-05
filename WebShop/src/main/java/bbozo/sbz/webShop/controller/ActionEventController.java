package bbozo.sbz.webShop.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bbozo.sbz.webShop.model.ActionEvent;
import bbozo.sbz.webShop.model.ProductCategory;
import bbozo.sbz.webShop.service.ActionEventService;
import bbozo.sbz.webShop.service.ProductCategoryService;

@RestController
@RequestMapping(value = "webShop/actionEvents")
public class ActionEventController {
	
	@Autowired
	ActionEventService actionEventService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActionEvent>> getActionEvents() {
		List<ActionEvent> actionEvents = actionEventService.findAll();
		return new ResponseEntity<>(actionEvents, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ActionEvent> getActionEvent(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ActionEvent actionEvent = actionEventService.findOne(id);
		if (actionEvent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(actionEvent, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ActionEvent> saveActionEvent(@RequestBody ActionEvent actionEvent){
		if(!checkInput(actionEvent)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (actionEvent.getProductCategories().size() < 1) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Set<ProductCategory> categories = new HashSet<>();
		for (ProductCategory category : actionEvent.getProductCategories()) {
			categories.add(productCategoryService.findOne(category.getId()));
		}
		actionEvent.getProductCategories().clear();
		actionEvent.setProductCategories(categories);
		actionEventService.save(actionEvent);
		return new ResponseEntity<>(actionEvent, HttpStatus.OK);
	}

	private boolean checkInput(ActionEvent category) {
		// TODO Auto-generated method stub
		return true;
	}

}
