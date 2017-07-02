package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.model.Invoice;
import bbozo.sbz.webShop.repository.InvoiceRepository;
import bbozo.sbz.webShop.utils.InvoiceStatus;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public Invoice findOne(Long id){
		return invoiceRepository.findOne(id);
	}
	
	public List<Invoice> findAll(){
		return invoiceRepository.findAll();
	}
	
	public Invoice save(Invoice invoice){
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> findByCustomer_Id(Long id){
		return invoiceRepository.findByCustomer_Id(id);
	}
	
	public List<Invoice> findByStatus(InvoiceStatus status){
		return invoiceRepository.findByStatus(status);
	}

}
