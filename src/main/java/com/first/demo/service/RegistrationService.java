package com.first.demo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.demo.model.RegistrationModel;
import com.first.demo.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(String email, String password, String name) {
		// Check if the email is already registered
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }
	    
	    // Create a new User object and set the properties
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

	    RegistrationModel user = new RegistrationModel();
	    user.setEmail(email);
	    user.setPassword(hashedPassword);
	    user.setName(name);
	    
	    // Save the user data to the database
	    userRepository.save(user);
	}
}
