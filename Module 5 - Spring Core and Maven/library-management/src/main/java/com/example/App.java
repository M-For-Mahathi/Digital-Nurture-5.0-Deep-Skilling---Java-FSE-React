package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        // Exercise 1:
        // Load the Spring Application Context from XML
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Exercise 1:
        // Get the BookService bean and invoke its method
        BookService service =
                context.getBean("bookService", BookService.class);

        service.displayService();

    }

}