package com.recipe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLoginAndPassword(String login, String password);
}
