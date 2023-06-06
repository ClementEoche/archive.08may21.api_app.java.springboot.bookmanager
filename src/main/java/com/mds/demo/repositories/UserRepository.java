package com.mds.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
