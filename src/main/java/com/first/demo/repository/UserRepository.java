package com.first.demo.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.demo.model.RegistrationModel;

@Repository
@ComponentScan

public interface UserRepository extends JpaRepository<RegistrationModel, String> {
    boolean existsByEmail(String email);
    RegistrationModel findByEmail(String email);

}
