package com.tuto.app.services;

import com.tuto.app.entites.AppRole;
import com.tuto.app.entites.AppUser;

public interface AccountService {
	
	
	public AppUser saveUser(String username,String password, String confirmedPassword);
	public AppRole saveRole(AppRole role);
	public AppUser loadUserByUsername(String username);
	public void AddRoleToUser(String username,String rolename);

}
