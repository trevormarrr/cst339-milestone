package com.gcu.milestone.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class LoginModel {

	

	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
}
