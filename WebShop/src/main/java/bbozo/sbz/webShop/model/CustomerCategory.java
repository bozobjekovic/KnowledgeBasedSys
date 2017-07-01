package bbozo.sbz.webShop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerCategory implements Serializable {

	private static final long serialVersionUID = 8054093986187957243L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "customerCategory")
	private Set<ConsumptionLimit> consumptionLimit = new HashSet<ConsumptionLimit>(0);
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<ConsumptionLimit> getConsumptionLimit() {
		return consumptionLimit;
	}
	
	public void setConsumptionLimit(Set<ConsumptionLimit> consumptionLimit) {
		this.consumptionLimit = consumptionLimit;
	}

}
