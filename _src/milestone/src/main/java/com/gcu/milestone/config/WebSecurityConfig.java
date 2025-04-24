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

/*
 * Main security configuration class for Spring Security
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /*
     * Configure password encryption
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for secure password hashing
    }

    /*
     * Configure authentication manager
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

    /*
     * Configure security rules and filters
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
