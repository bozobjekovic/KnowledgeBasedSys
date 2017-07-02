package bbozo.sbz.webShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bbozo.sbz.webShop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
