package bbozo.sbz.webShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemDiscount implements Serializable {

	private static final long serialVersionUID = -1646446114296106917L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private double discount;
	private boolean basicDiscount;
	
	@ManyToOne
	@JoinColumn(name = "invoiceD_id")
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "invoiceItem_id")
	private InvoiceItem invoiceItem;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public boolean isBasicDiscount() {
		return basicDiscount;
	}
	
	public void setBasicDiscount(boolean basicDiscount) {
		this.basicDiscount = basicDiscount;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public InvoiceItem getInvoiceItem() {
		return invoiceItem;
	}
	
	public void setInvoiceItem(InvoiceItem invoiceItem) {
		this.invoiceItem = invoiceItem;
	}
	
}
