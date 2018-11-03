package com.recipe.dto;

import com.recipe.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private UserRole role;

	@Getter
	public enum UserRole {
		ADMIN, REGULAR_USER, GUEST
	}

	public static UserDto of(User user) {
		return UserDto.builder()
				.id(user.getId())
				.login(user.getLogin())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.role(UserRole.valueOf(user.getRole().getValue()))
				.email(user.getEmail())
				.build();
	}
}
