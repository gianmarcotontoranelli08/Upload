package prova.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import prova.exception.BadRequest;
import prova.model.Users;
import prova.model.UserProfileType;
import prova.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository user_repo;

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return user_repo.findByUsername(username);
	}

	@Override
	public ResponseEntity<Users> registra(Users user) throws BadRequest {
		List<Users> users = user_repo.findAll();
		boolean ok = true;
		for (Users u : users) {
			if (u.getUsername().equals(user.getUsername()))
				throw new BadRequest("001", "username gia presente");
			else if (u.getEmail().equals(user.getEmail()))
				throw new BadRequest("002", "email gia presente");
			else {
				ok = true;
			}
		}
		if (ok) {
			user.setUserProfileType(UserProfileType.ROLE_USER);
			user_repo.save(user);
			return new ResponseEntity<Users>(HttpStatus.OK);
		} else
			return new ResponseEntity<Users>(HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return user_repo.findByEmail(email);
	}

	@Override
	public String stampa() throws BadRequest {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user = user_repo.findByEmail(auth.getName());
		if (user == null) {
			throw new BadRequest("001", "utente non trovato");
		} else

			return "ciao";
	}

	@Override
	public String modificaImmagine(String immagine) throws BadRequest {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user = user_repo.findByEmail(auth.getName());
		if (user == null) {
			throw new BadRequest("001", "Utente non trovato");
		} else {
			user.setImmagine(immagine);
			user_repo.save(user);
			
		}
		return "immagine modificata";
	}

}
