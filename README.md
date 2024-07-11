# BookStore

### Table of Contents
1. [Project Description](#project-description)
2. [Features](#features)
3. [Event Listeners](#event-listeners) 
4. [API Endpoints](#api-endpoints)
5. [Technologies Used](#technologies-used)

## Project Description
This is a Book Store Management application that allows librarians to manage books. It provides functionalities to add, edit, delete, rent a book and search for books. It also lists the available categories of books. The application is built using React for the frontend and Spring Boot for the backend. This project is made as a Laboratory exercise for the Electronic and Mobile Commerce (EMT) course at FCSE. 

## Features
- Add, edit, and delete books
- Search for books by title 
- View a list of all books
- Rent books
- List available categories of books

## Event Listeners
- BookEventHandlers: Listens to book events and prints messages to the console.
- Event Publishing: Events are published whenever a book is created, edited, or deleted.

## API Endpoints
#### Books
- `GET /api/books` - Get a list of all books
- `GET /api/books/{id}` - Get details of a specific book
- `POST /api/books/add` - Add a new book
- `PUT /api/books/edit/{id}` - Edit an existing book
- `DELETE /api/books/delete/{id}` - Delete a book
- `POST /api/books/rent/{id}` - Rent a book
- `GET /api/books/search` - Search for books by title (supports query parameter)
#### Authors
- `GET /api/authors` - Get a list of all authors
#### Categories
- `GET /api/books/categories` - Get a list of all book categories

## Technologies Used
- React
- React Router
- Axios
- Bootstrap
- Spring Boot
- Hibernate
- PostgreSQL
