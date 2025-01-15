# CST-339 Programming in Java III
## Project Status and Design Report

- Topic:
    - Scope of Project

    - More information if needed.

-  Date: 

-  Revision: 1.0
### Team:
1. Ashley Barron
2. Trevor Marr

### Weekly Team Status Summary (UseCase)


### GIT URL
- The git URL that can be used to clone your code and design artifacts

### Screencast URL:
- The URL that can be used to access your screencast demonstration video for the respective assignment

### Peer Review:
- [x] We acknowledge that our team has reviewed this Report and we agree to the approach we are all taking


## Planning Documentation

### Initial Planning:
Summary

### Retrospective Results:
The following table should be completed after each Retrospective on things that went well (keep doing)

|What Went Well|
|--|
|something|
|something|
|something|
|something|

The following table should be completed after each Retrospective on things that didn’t go well (stop doing) and what would be done differently next time with an action plan to improve (try doing and continuous improvement)

|What Did Not Go Well|Action Plan|Due Date
|--|--|--|
|something|something|something|
|something|something|something|
|something|something|something|

## Design Documentation
### Install Instruction
Step-by-step instructions for setting up your database, and configuring and deploying/installing your application. This section should also include detailed instructions for what configuration files are required by your application, what configuration settings need to be adjusted for various runtime (development or production) environments, and where the files need to be deployed to. This section should also contain detailed instructions for how to clone your application source code from GIT and deploy the application to an externally hosted site.

### General Technical Approach:
Add data here.
- The App needs:
  - a database of movies.
  - a databse of users with usernames and passwords.
    - Two different types of users:
      - Admins have access to CRUD operations.
      - Customers have access to view the inventory, adding and removing from the shooping cart, and to checkout.

### Key Technical Design Decisions:
- Spring Boot: Spring tools help Java development effiecency. 
- MySQL: To manage databases
- Postman: enviornment for API development


### Known Issues:
Any anomalies or known issues in the code or functionality should be documented here

### Risks:
- Time Constraint: The project timeline could be challenging to keep up with while keeping up with other academic responsibilities.
The risk of not meeting the deadline due to unforseen issues arises.
- Team Collaboration: The communication and coordination for any challenges within the team can cause the risk of delayed integration.
- Database Integration: The project requires the use of a database, risk of issues can arise for integration with the project and the relational databse, schema issues.
- Learning Curve: The project uses Spring Boot features we learn through the weeks; the risk of unfamilarity can cause issues with handeling error and the set up for the CRUD operations.

### ER Diagram:


### DDL Scripts:

### Sitemap Diagram:

### User Interface Diagrams:


### Class Diagrams:



### Service API Design:
#### User Authentication
---
#### POST /auth/login
Authenticate the user and provide a token.

**Request Body**
```json
{
"username": "admin@example.com",
"password": "YourSecurePassword123!"
}
```

***Response***
```json
{
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
&nbsp;
#### POST /auth/register
Register a new user.

**Request Body**
```json
{
"username": "user@example.com",
"password": "YourSecurePassword123!",
"role": "USER"
}
```
***Response***
```json
{
"message": "User registered successfully",
"userId": 123
}
```
&nbsp;

### Movies Management (Admin Only)
---
#### GET /movies
Retrieve a list of all movies.

***Response***
```json
[
{
"id": 1,
"title": "Inception",
"genre": "Sci-Fi",
"releaseYear": 2010,
"rating": 8.8
},
{
"id": 2,
"title": "The Godfather",
"genre": "Crime",
"releaseYear": 1972,
"rating": 9.2
}
]
```
&nbsp;

#### POST /movies
Add a new movie to the catalog (Admin only).

**Request Body**
```json
{
"title": "The Matrix",
"genre": "Sci-Fi",
"releaseYear": 1999,
"rating": 8.7
}
```

***Response***
```json
{
"message": "Movie added successfully",
"movieId": 3
}
```
&nbsp;

#### PUT /movies/{id}
Update a movie's details (Admin only).

**Path Parameter**

id: The ID of the movie to update.

**Request Body**
```json
{
"title": "The Matrix Reloaded",
"genre": "Sci-Fi",
"releaseYear": 2003,
"rating": 7.2
}
```

***Response***
```json
{
"message": "Movie updated successfully"
}
```
&nbsp;

#### DELETE /movies/{id}
Delete a movie from the catalog (Admin only).

**Path Parameter**

id: The ID of the movie to delete.

**Response**
```json
{
"message": "Movie deleted successfully"
}
```
&nbsp;

### Shopping Cart (User)
---
#### POST /cart
Add a movie to the shopping cart.

**Request Body**
```json
{
"movieId": 1,
"quantity": 1
}
```

***Response***
```json
{
"message": "Movie added to cart"
}
```
&nbsp;

#### GET /cart
Retrieve the contents of the shopping cart.

***Response***
```json
[
{
"movieId": 1,
"title": "Inception",
"quantity": 1,
"price": 3.99
},
{
"movieId": 2,
"title": "The Godfather",
"quantity": 2,
"price": 5.99
}
]
```
&nbsp;

#### DELETE /cart/{movieId}
Remove a movie from the shopping cart.

**Path Parameter**

movieId: The ID of the movie to remove.

***Response***
```json
{
"message": "Movie removed from cart"
}
```
&nbsp;

### Error Responses
---
All errors return the following JSON format:
```json
{
"error": "Unauthorized",
"message": "You are not allowed to perform this action"
}
```
### Security Design:

1. **Authentication Mechanism**
   - **User Authentication**  
     Our project will be using two-factor authentication with a username and password and verification code.

   - **Flow**  
     After a user types in their credentials, the system will verify them against the database then prompt them for second factor.

   - **Credential Storage**  
     Credentials will be stored in the database and passwords will be hashed for encryption. Verification codes will not be stored.

   - **Session Management**  
     Sessions will be stored using Redis for scalability and better performance. Sessions will expire after 90 minutes of no activity.

   - **Password Requirements**  
     - One uppercase letter  
     - One special character  
     - One number  
     - Non-sequential characters (letters or numbers)  
     - Minimum of ten characters  
     - Maximum of twenty characters

2. **Authorization Mechanism**
   - **Role-Based Access Control(RBAC)**  
     - Admin 
        - Create New DVD
        - Update DVD
        - Delete DVD
        - View Inventory 
        - Login 
        - Register
     - User
        - View DVDs
        - Update Library with favorites
        - Login
        - Register

3. **Security Features**
    - **Two-Factor Authentication**  
        - Password creation with specified requirements and verification code
    - **Encryption**  
        - Password will be hashed before stored into database and data will be encrypted during transit using HTTPS
    - **Session Expiration**  
        - Users will be automatically logged out of their account after 90 minutes of no activity.
    - **RBAC**  
        - Users will be restricted specific actions whereas Admins will have the ability to do everything. 
     
### Other Document:
You should insert any additional drawings, storyboards, whiteboard pictures, project schedules, tasks lists, etc. that support your approach, design, and project. If you have no supporting documentation, please explain the rationale for why you are able to leave this section as N/A