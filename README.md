# P1 - Solo Programming Movie Search Project

## Introduction

This is a Spring boot and Angular movie/actor search full stack application. Users can search for movies and add them to a watchlist or to their watch history.
The application will be primarily built using Java and will utilize a PostgreSQL database to store product and user information.

## User Stories

- **As a user**, I want to register an account so that I can have a personalized browsing experience.
- **As a user**, I want to log in to my account so that I can access my watch list and watch history.
- **As a user**, I want to browse through movies only when logging in.
- **As a user**, I want to search for products by title, actor, or keyword.
- **As a user**, I want to add products to my watch list so that I can watch them later.
- **As a user**, I want to review my watch history so that I can keep track of my watch progress.
- **As a user**, I want to rate and review movies so that I can share my experience with other users.
- **As a user**, I want to view ratings and reviews from other users to help gauge my interest in titles I am unfamiliar with.


## MVP (Minimum Viable Product)

- User registration and login
- Browsing and searching for movies
- Adding movies to a watch list for later viewing
- Modifying the watch list
- Watch history
- Movie rating and reviewing

## Stretch Goals

- Implementing a recommendation system based on user's previous view
- Implementing a random movie selection.
- Implementing a random movie selection based of an actor name or keyword.

## Tech Stacks

- **Java/Spring**: The main programming language used for building the back-end application.
- **Angular**: The main programming language used for building the front-end application.
- **PostgreSQL**: Used as the database to store user, product, and order data.
- **Maven or Gradle**: Used for managing project dependencies.
- **JUnit**: A testing framework for Java applications, used to ensure our code works as expected.
- **Log4j**: A logging utility for debugging purposes.
- **JDBC (Java Database Connectivity)**: An API for connecting and executing queries on the database.
- **BCrypt**: A Java library for hashing and checking passwords for security.
- **JUnit, Mockito, and PowerMock**: Used for unit and integration testing.
- **Git and GitHub**: Used for version control.

## Requirements

- **Clean Codebase**: All code should be clean and well-documented. The repository should not include any unnecessary files or folders such as the `target/`, `.DS_Store`, etc. All files and directories should be appropriately named and organized.

- **Database Design**: The database should be designed following the principles of the 3rd Normal Form (3NF) to ensure data integrity and efficiency. An Entity Relationship Diagram (ERD) should be included in the documentation.

- **Secure**: All sensitive user data such as passwords must be securely hashed before storing it in the database. The application should not display any sensitive information in error messages.

- **Error Handling**: The application should handle potential errors gracefully and provide clear and helpful error messages to the users.

- **Testing**: The application should have a high test coverage. Unit tests and integration tests should be implemented using JUnit, Mockito, and PowerMock.

- **Version Control**: The application should be developed using a version control system, preferably Git, with regular commits denoting progress.

- **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.

- **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.

