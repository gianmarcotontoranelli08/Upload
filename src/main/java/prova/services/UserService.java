package prova.services;

import org.springframework.http.ResponseEntity;

import prova.exception.BadRequest;
import prova.model.User;

public interface UserService {

	public User findByUsername(String username);
	
	public ResponseEntity<User> registra(User user) throws BadRequest;
}