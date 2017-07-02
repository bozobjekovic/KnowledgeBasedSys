package bbozo.sbz.webShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bbozo.sbz.webShop.dto.LoginUser;
import bbozo.sbz.webShop.model.User;
import bbozo.sbz.webShop.service.UserService;

@RestController
@RequestMapping(value = "webShop/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody LoginUser loginUser) {
		if (loginUser.getUsername().equals("") ||
			loginUser.getPassword().equals("")) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		User user = userService.login(loginUser);
		if (user == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
