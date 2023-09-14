# Movie Full Stack App⚡

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Database Setup](#database-setup)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Movie Full Stack App is a web application built with React.js and Spring Boot. It allows users to browse and discover information about movies, including details like titles, genres, release dates, and more. This application demonstrates the development of a full-stack project, combining front-end and back-end technologies.

## Technologies Used

- **Frontend**:
  - [React.js](https://reactjs.org/): A JavaScript library for building user interfaces.
  - [React Router](https://reactrouter.com/): For client-side routing.
  - [Bootstrap](https://getbootstrap.com/): A popular CSS framework for styling.

- **Backend**:
  - [Spring Boot](https://spring.io/projects/spring-boot): A Java framework for building robust, scalable applications.
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa): For database access.
  - [Swagger](https://swagger.io/): For API documentation.

- **Database**:
  - [PostgreSQL](https://www.postgresql.org/): An open-source relational database management system.

- **Build Tool**:
  - [Maven](https://maven.apache.org/): A popular build automation tool for Java projects.

## Features

- Browse and search for movies by title, genre, or release date.
- View detailed information about each movie, including cast, description, and ratings.
- Add movies to your favorites list (user authentication may be required for this feature).
- Explore a user-friendly and responsive user interface.

## Getting Started

To run the Movie Full Stack App locally, follow these steps:

```bash
# Clone the repository
git clone https://github.com/RATHISHKUMAR07/Movie-Full-Stack-App.git

# Change directory to the project folder
cd Movie-Full-Stack-App

# Install dependencies for both frontend and backend
cd frontend
npm install
cd ../backend
mvn clean install

# Start the frontend (React.js) and backend (Spring Boot) applications
cd frontend
npm start
cd ../backend
mvn spring-boot:run
