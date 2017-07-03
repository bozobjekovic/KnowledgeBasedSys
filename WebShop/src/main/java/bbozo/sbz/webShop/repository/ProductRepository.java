package bbozo.sbz.webShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import bbozo.sbz.webShop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	
	List<Product> findTop9ByOrderByIdDesc();
	
	List<Product> findByProductCategory_Id(Long id);
	
	List<Product> findByProductCategory_Supercategory_Id(Long id);
	
	@Query("select p from Product p where p.stock <= p.minimumStock")
	List<Product> find();

}
