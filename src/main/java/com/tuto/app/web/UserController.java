package com.tuto.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.app.entites.AppUser;
import com.tuto.app.entites.UserForm;
import com.tuto.app.services.AccountService;

@RestController
public class UserController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser  register(@RequestBody UserForm userForm) {
		
		return accountService.saveUser(
				userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	}

}
