package com.auth.sample.authentication.repository;

import com.auth.sample.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUserName(String username);
}
