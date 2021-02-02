package com.app.dto;

import javax.validation.constraints.NotNull;

public class LoginDto {
	@NotNull(message="Email cannot be null")
	private String email;
	@NotNull(message="Password cannot be null")
	private String password;

	public LoginDto() {
		// TODO Auto-generated constructor stub
	}

	public LoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
