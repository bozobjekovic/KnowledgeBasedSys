package bbozo.sbz.webShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GeneralDiscount implements Serializable {
	
	private static final long serialVersionUID = 13553800959894260L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Invoice invoice;
	private double discount;
	private boolean basicDiscount;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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

}
