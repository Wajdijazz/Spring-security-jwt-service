package com.tuto.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tuto.app.dao.AppRoleRepository;
import com.tuto.app.dao.AppUserRepository;
import com.tuto.app.entites.AppRole;
import com.tuto.app.entites.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	

	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		// TODO Auto-generated method stub
		
		AppUser user=appUserRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("user already exists");
		if(!password.equals(confirmedPassword))throw new RuntimeException("Please confirm your password");
		
		AppUser appUser=new AppUser();
		appUser.setUsername(username);
		appUser.setActivated(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepository.save(appUser);
		AddRoleToUser(username, "USER");
		return appUser;
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void AddRoleToUser(String username, String rolename) {
		// TODO Auto-generated method stub
		AppUser appUser=appUserRepository.findByUsername(username);
		AppRole appRole=appRoleRepository.findByRoleName(rolename);
		appUser.getRoles().add(appRole);
		
	}

}
