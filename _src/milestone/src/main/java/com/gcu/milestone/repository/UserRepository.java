package com.gcu.milestone.repository;

import com.gcu.milestone.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RegistrationModel, Long> {
    RegistrationModel findByUsername(String username);
}
