package bbozo.sbz.webShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = 4956782122463005601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
