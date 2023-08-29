package net.javaguide.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.springboot.entity.Role;

	public interface RoleRepository extends JpaRepository<Role, Long>{
		   
		Optional<Role> findByName(String name);
	
	}