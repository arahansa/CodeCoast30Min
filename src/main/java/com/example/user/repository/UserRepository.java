package com.example.user.repository;

import com.example.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arahansa on 2016-04-17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
