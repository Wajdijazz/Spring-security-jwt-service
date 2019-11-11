package com.tuto.app;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tuto.app.entites.AppRole;
import com.tuto.app.services.AccountService;

@SpringBootApplication
public class SecurityJwtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtServiceApplication.class, args);
	}
@Bean
CommandLineRunner start(AccountService accountService) {
	return args->{
		
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		Stream.of("USER1","USER2","USER3","admin").forEach(un->{
			
			accountService.saveUser(un, "1234", "1234");
			
		});
			
		accountService.AddRoleToUser("admin", "ADMIN");
		
		
	};

}

@Bean
BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
	
}	
	
}
