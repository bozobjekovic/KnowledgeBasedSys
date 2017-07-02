package bbozo.sbz.webShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bbozo.sbz.webShop.model.Invoice;
import bbozo.sbz.webShop.utils.InvoiceStatus;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	
	public List<Invoice> findByCustomer_Id(Long id);
	
	public List<Invoice> findByStatus(InvoiceStatus status);

}
