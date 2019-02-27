package prova.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/stampa", method = RequestMethod.GET)
	public String stampa() throws BadRequest {
		return user_service.stampa();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "logout occurred";
	}
	@RequestMapping(value = "/modificaImmagine/{immagine}", method = RequestMethod.PUT)
	public String modificaImmagine(@PathVariable("immagine")String immagine) throws BadRequest{
		return user_service.modificaImmagine(immagine);
	}
}
