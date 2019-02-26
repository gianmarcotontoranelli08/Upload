package prova.services;

import org.springframework.beans.factory.annotation.Autowired;

import prova.model.User;
import prova.repository.UserRepository;

public class UserServiceImpl implements UserService{
@Autowired
UserRepository user_repo;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return user_repo.findByUsername(username);
	}

}
