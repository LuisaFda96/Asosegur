 package org.gpi.asosegur.mode.service;

import java.util.Arrays;
import java.util.Collection; 
import java.util.stream.Collectors;

import org.gpi.asosegur.dto.UserRegistrationDTO;
import org.gpi.asosegur.model.dao.UserDAO;
import org.gpi.asosegur.model.entity.Role;
import org.gpi.asosegur.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User save(UserRegistrationDTO registrationDTO) {
		User user = new User(registrationDTO.getNombre(), registrationDTO.getApellido(),
				registrationDTO.getCorreoElectronico(), passwordEncoder.encode(registrationDTO.getContraseña()),
				Arrays.asList(new Role("ROLE_USER")));
		return userDAO.save(user);
		}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDAO.findByCorreoElectronico(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario o contraseña invalida");
	 	}
		return new org.springframework.security.core.userdetails.User(user.getCorreoElectronico(), user.getContraseña(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());

	}
}
