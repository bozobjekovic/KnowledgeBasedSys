package bbozo.sbz.webShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductCategory implements Serializable {
	
	private static final long serialVersionUID = 7311204348386015551L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private double maxDiscount;
	
	@ManyToOne
	private ProductCategory supercategory;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ProductCategory getSupercategory() {
		return supercategory;
	}
	
	public void setSupercategory(ProductCategory supercategory) {
		this.supercategory = supercategory;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMaxDiscount() {
		return maxDiscount;
	}
	
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	
}
