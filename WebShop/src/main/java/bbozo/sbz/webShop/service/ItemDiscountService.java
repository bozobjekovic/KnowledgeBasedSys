package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.ItemDiscount;
import bbozo.sbz.webShop.repository.ItemDiscountRepository;

@Service
public class ItemDiscountService {
	
	@Autowired
	ItemDiscountRepository itemDiscountRepository;
	
	public ItemDiscount findOne(Long id){
		return itemDiscountRepository.findOne(id);
	}
	
	public List<ItemDiscount> findAll(){
		return itemDiscountRepository.findAll();
	}
	
	public ItemDiscount save(ItemDiscount itemDiscount){
		return itemDiscountRepository.save(itemDiscount);
	}

}
