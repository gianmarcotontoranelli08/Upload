package prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prova.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	public User findById(long id);
	public User findByEmail(String email);
	
}
