package com.tuto.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tuto.app.entites.AppRole;


@RepositoryRestResource
public interface AppRoleRepository  extends JpaRepository<AppRole,Long> {
	public AppRole findByRoleName (String roleName);

}
