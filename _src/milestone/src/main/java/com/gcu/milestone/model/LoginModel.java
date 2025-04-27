package com.gcu.milestone.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class representing login form data
 */
public class LoginModel {

	/**
	 * Default constructor for LoginModel
	 */
	public LoginModel() {
	}

	/**
	 * login model for users with existing account
	 * username & password
	 */
	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
	private String username;

	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;

	/**
	 * getters for username
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter for username
	 * 
	 * @param username username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * get password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter for password
	 * 
	 * @param password password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * tostring for login
	 */
	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
}
