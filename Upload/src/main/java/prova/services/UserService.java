package prova.services;

import prova.model.User;

public interface UserService {

	public User findByUsername(String username);
}
