package bbozo.sbz.webShop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bbozo.sbz.webShop.utils.InvoiceStatus;

@Entity
public class Invoice implements Serializable {

	private static final long serialVersionUID = -940184194440477534L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	@ManyToOne
	private User customer;
	@Enumerated(EnumType.ORDINAL)
	private InvoiceStatus status;
	private double originalPrice;
	private double discount;
	private double totalPrice;
	private int spentBonusPoints;
	private int newBonusPoints;
	
	@OneToOne
	private GeneralDiscount generalDiscount;
	@OneToMany(mappedBy = "invoice")
	private Set<InvoiceItem> invoiceItem = new HashSet<InvoiceItem>(0);
	@JsonIgnore
	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ItemDiscount> itemDiscounts = new HashSet<ItemDiscount>(0);
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public InvoiceStatus getStatus() {
		return status;
	}
	
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getSpentBonusPoints() {
		return spentBonusPoints;
	}
	
	public void setSpentBonusPoints(int spentBonusPoints) {
		this.spentBonusPoints = spentBonusPoints;
	}
	
	public int getNewBonusPoints() {
		return newBonusPoints;
	}
	
	public void setNewBonusPoints(int newBonusPoints) {
		this.newBonusPoints = newBonusPoints;
	}
	
	public Set<InvoiceItem> getInvoiceItem() {
		return invoiceItem;
	}
	
	public void setInvoiceItem(Set<InvoiceItem> invoiceItem) {
		this.invoiceItem = invoiceItem;
	}
	
	public Set<ItemDiscount> getItemDiscounts() {
		return itemDiscounts;
	}
	
	public void setItemDiscounts(Set<ItemDiscount> itemDiscounts) {
		this.itemDiscounts = itemDiscounts;
	}
	
}
