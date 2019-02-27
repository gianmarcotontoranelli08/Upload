package prova.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import prova.exception.BadRequest;
import prova.model.User;
import prova.model.UserProfileType;
import prova.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository user_repo;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return user_repo.findByUsername(username);
	}

	@Override
	public ResponseEntity<User> registra(User user) throws BadRequest {
		List<User> users = user_repo.findAll();
		boolean ok = true;
		for (User u : users) {
			if (u.getUsername().equals(user.getUsername()))
				throw new BadRequest("001", "username gia presente");
			else if (u.getEmail().equals(user.getEmail()))
				throw new BadRequest("002", "email gia presente");
			else {

				ok = true;
			}

		}
		if(ok) {
			user.setUserProfileType(UserProfileType.ROLE_USER);
			user_repo.save(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		}else
			
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return user_repo.findByEmail(email);
	}

}
