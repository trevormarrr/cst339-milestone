package com.gcu.milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Spring Boot application class
 * Initializes and runs the application
 */
@SpringBootApplication
@ComponentScan("com.gcu.milestone")
public class MilestoneApplication {
	/**
	 * Default constructor for MilestoneApplication
	 */
	public MilestoneApplication() {
	}

	/**
	 * Main entry point of the application
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MilestoneApplication.class, args);
	}

}
