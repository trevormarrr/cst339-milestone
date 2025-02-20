package com.gcu.milestone.model;

// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationModel {

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(min = 1, max = 32, message = "Invalid email format") // changed @Email to @Size
    private String email;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    private String phoneNumber;

    @NotNull(message = "Username is required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 32, message = "Password must be between 6 and 32 characters")
    private String password;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
