package prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prova.exception.BadRequest;
import prova.model.Users;
import prova.services.UserService;
import prova.services.auth.AuthService;

@RestController
public class UserController {

	@Autowired
	private UserService user_service;

	@Autowired
	private AuthService auth_service;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Users> registraUser(@RequestBody Users user) throws BadRequest {
		user.setPassword(encoder.encode(user.getPassword()));
		return user_service.registra(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserDetails authenticate(@RequestBody Users user) throws Exception {
		return auth_service.authenticate(user);

	}
}
