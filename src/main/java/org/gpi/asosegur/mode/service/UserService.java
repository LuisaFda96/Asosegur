package org.gpi.asosegur.mode.service;

import org.gpi.asosegur.dto.UserRegistrationDTO;
import org.gpi.asosegur.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDTO registrationDTO);

}
