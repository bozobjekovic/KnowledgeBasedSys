package bbozo.sbz.webShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bbozo.sbz.webShop.model.CustomerCategory;

public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory, Long>{

}
