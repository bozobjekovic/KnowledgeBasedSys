package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.ConsumptionLimit;
import bbozo.sbz.webShop.repository.ConsumptionLimitRepository;

@Service
public class ConsumptionLimitService {
	
	@Autowired
	ConsumptionLimitRepository consumptionLimitRepository;
	
	public ConsumptionLimit findOne(Long id){
		return consumptionLimitRepository.findOne(id);
	}
	
	public List<ConsumptionLimit> findAll(){
		return consumptionLimitRepository.findAll();
	}
	
	public ConsumptionLimit save(ConsumptionLimit consumptionLimit){
		return consumptionLimitRepository.save(consumptionLimit);
	}

}
