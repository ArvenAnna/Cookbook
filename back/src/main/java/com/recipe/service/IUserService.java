package com.recipe.service;

import com.recipe.dto.LoginRequest;
import com.recipe.dto.UserDto;

public interface IUserService {
	UserDto logIn (LoginRequest loginRequest);
}
