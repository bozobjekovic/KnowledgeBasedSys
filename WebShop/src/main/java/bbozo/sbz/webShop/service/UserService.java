package bbozo.sbz.webShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbozo.sbz.webShop.dto.LoginUser;
import bbozo.sbz.webShop.model.User;
import bbozo.sbz.webShop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findOne(Long id){
		return userRepository.findOne(id);
	}
	
	public User login(LoginUser loginUser){
		return userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
}
