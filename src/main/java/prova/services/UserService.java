package prova.services;

import org.springframework.http.ResponseEntity;

import prova.exception.BadRequest;
import prova.model.Users;

public interface UserService {

	public Users findByUsername(String username);
	
	public Users findByEmail(String email);
	
	public ResponseEntity<Users> registra(Users user) throws BadRequest;
}
