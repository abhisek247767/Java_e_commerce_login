package com.first.demo.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Table(name = "registration")
public class RegistrationModel {
    @Id
    @Column(unique = true)
	 private String email;
	 private String password;
	 private String name;

		/*
		 * private String user_flag; public String getUser_flag() { return user_flag; }
		 * public void setUser_flag(String user_flag) { this.user_flag = user_flag; }
		 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RegistrationModel [email=" + email + ", password=" + password + ", name=" + name + "]";
	}
	public RegistrationModel(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	  public RegistrationModel() {
	        // Default constructor
	    }
	 

}
