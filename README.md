# CST-339 CLC Project Overview

## Introduction
In this course, you will design and build a complete enterprise-class N-Layer application using the Spring Boot framework. The application must adhere to a specific set of high-level functional and technical requirements, as outlined below. 

### Project Overview
- **Team Size**: Teams of up to 2 students (or 3 if necessary due to an odd number of students).
- **Application Scope**: Examples include e-commerce, customer management, order management, blog sites, or media management applications.
- **Deliverables**: 
  - Design Report for each milestone, capturing:
    - Technical approach
    - Design decisions
    - UI wireframe designs
    - Sitemap designs
    - ER database designs
    - Project risks/issues
  - Code maintained in a GCU-approved private GIT repository.
- **Approval**: Project must be approved by the instructor before detailed design and development.

---

## Application Requirements

### High-Level Requirements
1. **User Modules**:
   - User registration.
   - Login functionality.

2. **Architecture**:
   - Must follow an N-Layer architecture with separate:
     - Presentation components.
     - Business services.
     - Persistence services.
   - Adherence to industry best practices for exception and error handling.

3. **Presentation**:
   - Technologies: Spring MVC, Thymeleaf templates, Bootstrap, and Spring Boot Embedded Tomcat.
   - Features:
     - Fully responsive design.
     - Data validation for all form entries.
     - CRUD operations on business domain (e.g., products):
       - List all entities (e.g., products) in a tabular format.
       - Create, read, update, and delete individual entities.
     - No business logic in MVC components.

4. **Persistence**:
   - Relational databases (MySQL or PostgreSQL preferred).
   - Use Spring JDBC or Spring Data JDBC.

5. **Security**:
   - Use Spring Security for form-based authentication and authorization.
   - Secure APIs with at least Basic HTTP Authentication.

6. **Development Practices**:
   - Implement Spring Beans with dependency injection (DI).
   - Fully document application classes with JavaDoc.
   - Deploy as a JAR using Maven.

---

## Milestones

### Milestone 1: Proposal and Planning
- Deliverables:
  - Project proposal.
  - Draft sitemap.
  - Draft division of work across the team.

---

### Milestone 2: Initial Modules
- Deliverables:
  - Main application module.
  - Registration and login modules (without database).
  - Responsive design using Bootstrap.
  - Page layouts with Thymeleaf.
  - Design report.
  - Screencast running on the local development environment.

---

### Milestone 3: Product Creation Module
- Deliverables:
  - Product creation functionality (without database).
  - Refactored registration and login modules using Spring Beans and IoC.
  - Updated design report.
  - Screencast running on the local development environment.

---

### Milestone 4: Database Integration
- Deliverables:
  - Refactored registration, login, and product creation modules using Spring JDBC or Spring Data JDBC.
  - Application built as a JAR file using Maven.
  - Updated design report.
  - Screencast running on the local development environment.

---

### Milestone 5: CRUD Operations
- Deliverables:
  - Product display, update, and delete modules (integrated with the database).
  - Updated design report.
  - Screencast running on the local development environment.

---

### Milestone 6: Security Implementation
- Deliverables:
  - Refactored login module using Spring Security (form-based authentication with database).
  - Secure all pages except registration and login.
  - Updated design report.
  - Screencast running on the local development environment.

---

### Milestone 7: REST APIs
- Deliverables:
  - REST API design using a template (e.g., Microsoft Word or Swagger).
  - APIs for:
    - Returning all products.
    - Returning a specific product.
  - Secure APIs with Spring Security and Basic HTTP Authentication.
  - Design and code cleanup.
  - Updated design report.

---

### Milestone 8: Final Delivery
- Deliverables:
  - JavaDoc generation.
  - Final application code.
  - Final project presentation.
  - Final design report.

---

## Conclusion
This project is an opportunity to apply Spring Boot and industry best practices to design and develop a scalable, secure, and functional enterprise-class application. Collaboration, iterative development, and adherence to milestones are key to successfully completing the project.
