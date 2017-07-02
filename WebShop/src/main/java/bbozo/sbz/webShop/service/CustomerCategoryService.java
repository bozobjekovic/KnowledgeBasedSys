package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.CustomerCategory;
import bbozo.sbz.webShop.repository.CustomerCategoryRepository;

@Service
public class CustomerCategoryService {

	@Autowired
	CustomerCategoryRepository customerCategoryRepository;
	
	public CustomerCategory findOne(Long id){
		return customerCategoryRepository.findOne(id);
	}
	
	public List<CustomerCategory> findAll(){
		return customerCategoryRepository.findAll();
	}
	
	public CustomerCategory save(CustomerCategory customerCategory){
		return customerCategoryRepository.save(customerCategory);
	}
}
