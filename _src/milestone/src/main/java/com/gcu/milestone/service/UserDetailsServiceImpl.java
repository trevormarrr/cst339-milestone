package com.gcu.milestone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.gcu.milestone.data.DataAccessInterface;
import com.gcu.milestone.model.RegistrationModel;

import java.util.Collections;

/**
 * Custom implementation of Spring Security's UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DataAccessInterface<RegistrationModel> userDAO; // Inject our data access object

    /**
     * Required method to load user details by username
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user in database
        RegistrationModel user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Convert our user model to Spring Security's UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                // Assign ROLE_USER to all authenticated users
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
