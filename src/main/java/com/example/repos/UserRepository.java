package com.example.repos;

import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User getByActivationCode(String code);

    User findByActivationCode(String code);
}
