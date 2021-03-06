package prova.services.auth;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import prova.model.Users;








@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Authenticate a user.
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public UserDetails authenticate(Users user) throws Exception {

		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(user.getEmail());

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loadUserByUsername.getUsername(), user.getPassword());

		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return loadUserByUsername;
	}

}