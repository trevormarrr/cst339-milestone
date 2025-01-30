# Milestone 2: Project Proposal and Planning

## Overview
This is a Collaborative Learning Community (CLC) assignment. In this course, the team will design and build a complete enterprise-class N-Layer application using the Spring Boot framework. For this milestone, the tasks outlined below must be completed to set the foundation for the project.

---

## Requirements

### Review Project Overview
- Examine the project requirements in the **"CST-339 CLC Project Overview"**

### Complete the Following Tasks:

1. **Main Application Module**
   - This will be the main application page that is visible when the root URI of the application is accessed.
   - The main application should provide initial navigation concepts (e.g., a menu bar) to access the application's core functionality, such as Login and Register.
   - The main application, at this point, should have well-defined styles, fonts, colors, and an overall application theme implemented that will be used for the remaining milestone deliverables.
   - The application should leverage Spring MVC for all dynamic page generation.
   - The application should have a title (and possible a logo).

2. **Registration Module**
   - A user should be able to register to access the application.
   - Registration details, at a minimum, should include First Name, Last Name, Email Address, Phone Number, and Login Credentials (Username and Password).
   - The Registration page should leverage Spring MVC for all dynamic page generation.
   - A user object model should be designed and implemented.
   - A database model should be designed, but an implementation is not required until Milestone 4.
   - All data entered by the user must be validated and proper error messages provided so as to enable the user to easily correct the data.

3. **Login Module**
   - Initial login module that will emulate authenticating the user (i.e., no database).
   - The log page should leverage Spring MVC for all dynamic page generation.
   - A login/principle object model should be designed and implemented.
   - A database model should be designed, but an implementation is not required until Milestone 4.
   - All data entered by the user must be validated and proper error messages provided so as to enable the user to easily correct the data.
   - Security will be implemented as part of Milestone 6 using the Spring Security framework. For now, it is not required to securely protect any pages in the application.
   - Once the user is logged in, the main "product" page should be displayed and the menu system dynamically updated to reflect the logged in state of the application.
  
  *Note: All pages must be designed using one or more common Thymeleaf layouts.*

4. **Responsive Design**
   - Configure the application to use the Bootstrap framework.
   - Ensure application can be rendered properly on at least one mobile device, one tablet, and two desktop browsers.


5. **Review and Documentation**
   - It is expected that the team will perform peer code reviews on all code.
   - It is expected that the team will fully document all code modules, classes, methods, and use inline comments for all code.
   - It is expected that the team will meet with the instructor if there are project management issues.
  
---

## Deliverables and Submission

### Submit the Following Documents:

1. **An *updated* Design Report Including**
   - Cover Page:
     - With a list of tasks completed.
   - Planning Documentation:
     - Outline of how the project will be managed.
   - Design Documentation:
     - To include the General Technical Approach, Key Technical Decisions, Install or Configuration Instructions, Known Issues, Risks, Sitemap Diagram, User Interface Diagrams, ER Diagram, DDL Scripts and Class Diagrams (for all controllers and object models).
   - The screencast URL:
     - Presenting a technical and functional demonstration running the application from the local development environment.

---

### Additional Notes
- APA style is not required, but solid academic writing is expected.
- Review the assignment rubric prior to starting to ensure successful completion.
- **LopesWrite Submission**: This assignment does not need to be submitted to LopesWrite.

---

By completing this milestone, the team will establish a strong foundation for the project, ensuring alignment on goals, technical approach, and team responsibilities.
