package com.example.repository;

import com.example.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arahansa on 2016-04-17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
