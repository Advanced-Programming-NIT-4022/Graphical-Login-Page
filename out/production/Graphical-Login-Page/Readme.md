# Java Swing Login GUI

## Project Overview

This project aims to create a Java Swing-based graphical user interface (GUI) for a login and registration system. The application will allow users to register with a username, password, and email address, and subsequently log in using their credentials. The system will enforce password strength, validate email addresses using regular expressions, and securely store user credentials by hashing passwords with SHA-256. User data will be stored in files.

## Features

1. **User Registration and Login:**
   - Users can register by providing a username, password, and email.
   - Users can log in using their username and password.

2. **Password Strength Validation:**
   - Password strength will be evaluated based on the following criteria:
     1. Contains lowercase or uppercase characters or numbers.
     2. Contains both lowercase and uppercase characters.
     3. Contains uppercase, lowercase, and numbers.
     4. Contains special characters (@, -, _ , .).
     5. Longer than 8 characters.

3. **Email Validation:**
   - Email addresses will be validated using regular expressions to ensure they are in a valid format.

4. **Password Hashing:**
   - Passwords will be hashed using SHA-256 before storing.
   - The login process will involve hashing the entered password and comparing it to the stored hash.

5. **Data Storage:**
   - User data will be stored in files on the filesystem.

6. **Graphical User Interface:**
   - Developed using Java Swing for a robust and user-friendly interface.

## Recommended Project Structure

- `src`
  - `Answers.Main.java` - Entry point of the application.
  - `LoginGUI.java` - Handles the GUI components and events.
  - `User.java` - Represents a user and contains methods for hashing and validating passwords.
  - `UserStore.java` - Handles storing and retrieving user data from files.
  - `PasswordUtils.java` - Contains utility methods for password strength evaluation and hashing.
  - `EmailValidator.java` - Contains method for validating email addresses using regex.

## Detailed Explanation

### Password Strength Evaluation

The password strength is evaluated based on the following criteria:
1. **Level 1:** Contains lowercase or uppercase characters or numbers.
2. **Level 2:** Contains both lowercase and uppercase characters.
3. **Level 3:** Contains uppercase, lowercase, and numbers.
4. **Level 4:** Contains special characters (@, -, _ , .).
5. **Level 5:** Longer than 8 characters.

### Email Validation

Email addresses are validated using a regular expression to ensure they are in a standard format. 


### Password Hashing and Login Process

Passwords are hashed using the SHA-256 algorithm. Here’s a brief explanation of how hashing and login work:

1. **Hashing:** When a user registers, their password is hashed using SHA-256 before being stored.
2. **Storing:** The hashed password, along with the username and email, is stored in a file.
3. **Login:** During login, the entered password is hashed, and the resulting hash is compared to the stored hash. If they match, the login is successful.

## GUI Design

The GUI will be designed using Java Swing with the following components:
- **Login Panel:** Username field, password field, and login button.
- **Registration Panel:** Username field, password field, email field, and register button.
- **Message Labels:** For displaying success or error messages.

## Recommended File Storage Format

User data will be stored in a text file (`users.txt`) with each line containing a user's username, hashed password, and email, separated by commas.

Example:
```
username1,hashedpassword1,email1@example.com
username2,hashedpassword2,email2@example.com
```

## Description

This project is a Java Swing-based application that provides a graphical user interface for user login and registration. The application includes password strength validation, email validation, password hashing using SHA-256, and file-based user data storage.

## Features

- User registration with username, password, and email.
- User login with username and password.
- Password strength evaluation.
- Email format validation.
- Secure password storage using SHA-256 hashing.
- User-friendly GUI developed with Java Swing.


### Usage

1. **Register a new user:**
   - Open the application.
   - Navigate to the registration panel.
   - Enter a username, password, and email.
   - Click the "Register" button.

2. **Login:**
   - Open the application.
   - Navigate to the login panel.
   - Enter your username and password.
   - Click the "Login" button.
