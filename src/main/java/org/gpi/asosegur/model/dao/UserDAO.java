package org.gpi.asosegur.model.dao;

import org.gpi.asosegur.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	User findByCorreoElectronico(String correoElectronico); 
}
