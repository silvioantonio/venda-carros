package com.silvio.plataforma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.silvio.plataforma.model.Usuario;
import com.silvio.plataforma.repository.UserRepository;

@Repository
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String u) throws UsernameNotFoundException {

		Usuario usuario = Optional.ofNullable(userRepository.findByUserName(u))
		.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
				
		return new User(
				usuario.getUsername(), 
				usuario.getPassword(), 
				usuario.isAdmin() ? authorityListAdmin : authorityListUser
			);
	}

}
