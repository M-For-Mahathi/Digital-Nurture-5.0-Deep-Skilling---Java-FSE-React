package com.example;

public class BookService {

    // Exercise 2:
    // Dependency to be injected by Spring IoC Container
    private BookRepository bookRepository;

    // Exercise 2:
    // Setter method used for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Exercise 1:
    // Method to demonstrate the Book Service
    public void displayService() {

        System.out.println("Book Service is working");

        // Exercise 2:
        // Use the injected BookRepository bean
        if (bookRepository != null) {
            bookRepository.displayRepository();
        }

    }

}