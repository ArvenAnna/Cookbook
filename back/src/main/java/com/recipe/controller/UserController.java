package com.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.dto.LoginRequest;
import com.recipe.dto.UserDto;
import com.recipe.service.IUserService;

@RestController
@RequestMapping(value = {"/user"}, headers = "Accept=application/json")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public UserDto logIn(@RequestBody LoginRequest loginRequest) {
		return userService.logIn(loginRequest);
	}
}
