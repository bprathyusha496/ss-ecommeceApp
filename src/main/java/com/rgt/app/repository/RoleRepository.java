package com.rgt.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgt.app.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
		

}
