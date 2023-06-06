package com.mds.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.demo.entities.User;
import com.mds.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return this.repository.findAll();
	}
	public User findOneUser(Long userId) {
		return this.repository.findById(userId).orElse(null);	
	}
	/*public void save(User user) {
		this.repository.save(user);
	}*/
	
	public void generateUsers(final Integer nb) {
		for (int i = 0; i < nb; i++) {
			User user = new User();
			user.setFirstname("fname"+i);
			user.setLastname("lname"+i);
			
			this.repository.save(user);
		}
	}
}
