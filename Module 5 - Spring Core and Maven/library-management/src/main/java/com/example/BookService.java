package com.example;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    // Exercise 7
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Exercise 2,5,7
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {

        System.out.println("Book Service");

        if(bookRepository != null){
            bookRepository.displayRepository();
        }

    }

}