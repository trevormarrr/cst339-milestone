package com.gcu.milestone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * registration model for new users
 */
@Entity
@Table(name = "users")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(min = 1, max = 32, message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "Username is required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    @Column(unique = true)
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 60, message = "Password must be between 6 and 60 characters")
    @Column(length = 60)
    private String password;

    // Getters and Setters

    /**
     * getter for id
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter for id
     * 
     * @param id id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter for firstname
     * 
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for firstname
     * 
     * @param firstName firstname to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter for lastname
     * 
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for lastname
     * 
     * @param lastName lastname to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter for email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email
     * 
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for phonenumber
     * 
     * @return phonenumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setter for phonenumber
     * 
     * @param phoneNumber phonenumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getter for username
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username
     * 
     * @param username username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * 
     * @param password password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
