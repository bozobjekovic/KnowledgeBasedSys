package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.GeneralDiscount;
import bbozo.sbz.webShop.repository.GenerealDiscountRepository;

@Service
public class GeneralDiscountService {
	
	@Autowired
	GenerealDiscountRepository generealDiscountRepository;
	
	public GeneralDiscount findOne(Long id){
		return generealDiscountRepository.findOne(id);
	}
	
	public List<GeneralDiscount> findAll(){
		return generealDiscountRepository.findAll();
	}
	
	public GeneralDiscount save(GeneralDiscount generalDiscount){
		return generealDiscountRepository.save(generalDiscount);
	}

}
