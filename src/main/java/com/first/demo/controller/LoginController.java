package com.first.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.model.LoginForm;
import com.first.demo.model.RegistrationModel;
import com.first.demo.repository.UserRepository;
import com.first.demo.service.LoginService;

@RestController
@CrossOrigin("http://localhost:4200")

@RequestMapping("/api2")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    
    private final String adminEmail = "admin@example.com";
    private final String adminPassword = "admin123";
    
    @PostMapping("/login")
    public LoginService login(@RequestBody LoginForm loginForm) {
        boolean isValidCredentials = validateCredentials(loginForm.getEmail(), loginForm.getPassword());

        // Create a new LoginService instance
        LoginService response = new LoginService();
        response.setSuccess(isValidCredentials);

        // Check if the login email matches the admin email
        if (isValidCredentials && loginForm.getEmail().equals(adminEmail)) {
            // Set the isAdmin flag to true for the admin user
        	System.out.print("Admin???: "+response.isAdmin());
        	 System.out.println(response);
            response.setAdmin(true);
            System.out.print("Is it Admin: "+response.isAdmin());
            
        }

        return response;
    }

    private boolean validateCredentials(String email, String password) {
        if (email.equals(adminEmail) && password.equals(adminPassword)) {
            return true;
        } else {
            // Retrieve the user from the database based on the email
            RegistrationModel user = userRepository.findByEmail(email);

            // Check if the user exists and the password matches
            return user != null && user.getPassword().equals(password);
        }
    }
}
