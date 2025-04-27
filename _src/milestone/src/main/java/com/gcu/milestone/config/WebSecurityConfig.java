package com.gcu.milestone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configuration class for web security settings
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Configures the password encoder bean
     * @return the password encoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for secure password hashing
    }

    /**
     * Configures the authentication manager
     * @param userDetailsService the user details service
     * @param passwordEncoder the password encoder
     * @return the authentication manager
     */
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService); // Use our custom UserDetailsService
        authenticationProvider.setPasswordEncoder(passwordEncoder); // Set password encoder
        return new ProviderManager(authenticationProvider);
    }

    /**
     * Configures the security filter chain
     * @param http the HTTP security configuration
     * @return the configured security filter chain
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing/development
                .authorizeHttpRequests((requests) -> requests
                        // Public URLs that don't require authentication
                        .requestMatchers("/", "/register/**", "/login/**", "/css/**", "/images/**").permitAll()
                        // All other URLs require authentication
                        .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login/") // Custom login page
                        .loginProcessingUrl("/login/doLogin") // Login form submission URL
                        .defaultSuccessUrl("/dashboard", true) // Redirect after successful login
                        .permitAll())
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Logout URL
                        .logoutSuccessUrl("/login/") // Redirect after logout
                        .permitAll());

        return http.build();
    }
}
