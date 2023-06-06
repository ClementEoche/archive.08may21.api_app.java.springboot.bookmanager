package com.mds.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.demo.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{

}
