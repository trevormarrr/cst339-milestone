# CST-339 Programming in Java III
## Project Status and Design Report

- Topic:
    - Scope of Project

    - More information if needed.

-  Date: 2025-01-14

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

| What Went Well |
| -------------- |
| something      |
| something      |
| something      |
| something      |

The following table should be completed after each Retrospective on things that didn’t go well (stop doing) and what would be done differently next time with an action plan to improve (try doing and continuous improvement)

| What Did Not Go Well | Action Plan | Due Date  |
| -------------------- | ----------- | --------- |
| something            | something   | something |
| something            | something   | something |
| something            | something   | something |

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
- Image file of your ER database diagram. 

### DDL Scripts:
- This should contain a link to Bitbucket wherefrom the DDL script can be downloaded. 

### Sitemap Diagram:
- Image file of your Sitemap diagram. 

### User Interface Diagrams:
You should insert any wireframe drawings or whiteboard concepts that were developed to support your application. If you have no supporting documentation, please explain the rationale for why you are able to leave this section as N/A.

### Class Diagrams:
You should insert any class diagrams here. Your class diagrams should be drawn correctly with the 3 appropriate class compartments, + and – minus to indicate accessibility, and also the data types for the state/properties as well as method arguments and return types. If you have no supporting documentation, please explain the rationale for why you are able to leave this section as N/A.


# Service API Design

## User Authentication


### **POST /auth/login**  
Authenticate the user and provide a token.

**Request Body**  
```json
{
  "username": "example@example.com",
  "password": "Password123!"
}
```

**Response**  
```json
{
  "token": "tkHjfnscHg7jfqg11NiIsInR5cCI6IkpXVCJ9..."
}
```

---

### **POST /auth/register**  
Register a new user.

**Request Body**  
```json
{
  "username": "example@example.com",
  "password": "Password123!",
  "role": "Member"
}
```

**Response**  
```json
{
  "message": "User successfully registered",
  "userId": 1
}
```



## Book Management (Admin)

### **GET /books**  
Retrieve a list of all books.

**Response**  
```json
[
  {
    "id": 1,
    "title": "Book 1",
    "genre": "Sci-Fi",
    "author": "John Appleseed",
    "year": 2000,
    "checkedOut": true
  },
  {
    "id": 2,
    "title": "Book 2",
    "genre": "Fiction",
    "author": "Johnny Seedapple",
    "year": 2020,
    "checkedOut": false
  }
]
```


### **POST /books**  
Add a new book to the catalog (Admin only).

**Request Body**  
```json
{
  "title": "Book 3",
  "genre": "Non-Fiction",
  "author": "Old Apple John",
  "year": 2025,
  "checkedOut": false
}
```

**Response**  
```json
{
  "message": "Book added successfully",
  "id": 3
}
```


### **PUT /books/{id}**  
Update a book's details (Admin only).

**Path Parameter**  
`id`: The ID of the book to update.

**Request Body**  
```json
{
  "title": "Book 3",
  "genre": "Biography",
  "author": "Old Apple John",
  "year": 2023,
  "checkedOut": true
}
```

**Response**  
```json
{
  "message": "Book updated successfully"
}
```


### **DELETE /books/{id}**  
Delete a book from the catalog (Admin only).

**Path Parameter**  
`id`: The ID of the book to delete.

**Response**  
```json
{
  "message": "Book deleted successfully"
}
```


## Book Bag (User)


### **POST /cart**  
Add a book to the book bag.

**Request Body**  
```json
{
  "id": 1,
  "quantity": 1
}
```

**Response**  
```json
{
  "message": "Book added to Book Bag"
}
```


### **GET /cart**  
Retrieve the contents of the shopping cart.

**Response**  
```json
[
  {
    "id": 1,
    "title": "Book 1",
    "genre": "Sci-Fi",
    "author": "John Appleseed",
    "year": 2000,
    "checkedOut": true
  },
  {
    "id": 2,
    "title": "Book 2",
    "genre": "Fiction",
    "author": "Johnny Seedapple",
    "year": 2020,
    "checkedOut": false
  }
]
```

### **DELETE /cart/{bookId}**  
Remove a book from the book bag.

**Path Parameter**  
`bookId`: The ID of the book to remove.

**Response**  
```json
{
  "message": "Book removed from Book Bag"
}
```

## Error Responses

All error responses follow this JSON format:

**Response**  
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
     
### Other Documentation:
You should insert any additional drawings, storyboards, whiteboard pictures, project schedules, tasks lists, etc. that support your approach, design, and project. If you have no supporting documentation, please explain the rationale for why you are able to leave this section as N/A




