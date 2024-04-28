package com.openclassrooms.webapp.repository;

import com.openclassrooms.webapp.model.User;
import org.springframework.data.jpa.repository.*;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}