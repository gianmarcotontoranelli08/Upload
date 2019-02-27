package prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prova.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
	public Users findById(long id);
	public Users findByEmail(String email);
	
}
