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

import bbozo.sbz.webShop.model.Invoice;
import bbozo.sbz.webShop.model.InvoiceItem;
import bbozo.sbz.webShop.service.InvoiceService;
import bbozo.sbz.webShop.service.ProductService;
import bbozo.sbz.webShop.utils.InvoiceStatus;

@RestController
@RequestMapping(value = "webShop/invoices")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Invoice invoice = invoiceService.findOne(id);
		if (invoice == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices() {
		List<Invoice> invoices = invoiceService.findAll();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
		if (!checkInput(invoice)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		invoiceService.save(invoice);
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{customerID}", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getCustomerInvoices(@PathVariable Long customerID) {
		if (customerID == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Invoice> invoices = invoiceService.findByCustomer_Id(customerID);
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoicesByStatus(@PathVariable InvoiceStatus status) {
		if (status == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Invoice> invoices = invoiceService.findByStatus(status);
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> cancelInvoice(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Invoice invoice = invoiceService.findOne(id);
		invoice.setStatus(InvoiceStatus.CANCELED);
		invoiceService.save(invoice);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> invoiceProcessing(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Invoice invoice = invoiceService.findOne(id);
		for (InvoiceItem invoiceItem : invoice.getInvoiceItem()) {
			invoiceItem.getProduct().setStock(invoiceItem.getProduct().getStock() - invoiceItem.getAmount());
		}
		invoice.setStatus(InvoiceStatus.SUCCESSFUL);
		invoiceService.save(invoice);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private boolean checkInput(Invoice invoice) {
		// TODO Auto-generated method stub
		return true;
	}

}
