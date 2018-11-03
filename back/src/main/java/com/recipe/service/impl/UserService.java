package com.recipe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.dto.LoginRequest;
import com.recipe.dto.UserDto;
import com.recipe.exception.Errors;
import com.recipe.exception.UserNotFoundException;
import com.recipe.repository.UserRepository;
import com.recipe.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements IUserService {

	private final UserRepository userRepository;

	@Override
	@Transactional
	public UserDto logIn(LoginRequest loginRequest) {
		return UserDto.of(userRepository.findByLoginAndPassword(loginRequest.getLogin(),
				loginRequest.getPassword()).orElseThrow(() -> new UserNotFoundException(Errors.USER_NOT_FOUND)));
	}
}
