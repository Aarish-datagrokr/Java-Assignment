package org.datagrokr.assignment.BookStore.CLI;

import org.datagrokr.assignment.BookStore.BookStoreApplication;
import org.springframework.boot.SpringApplication;

public class BookStoreCLI {
    public static void runner(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

}
