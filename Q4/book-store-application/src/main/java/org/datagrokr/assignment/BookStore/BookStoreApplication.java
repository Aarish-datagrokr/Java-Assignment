package org.datagrokr.assignment.BookStore;

import org.datagrokr.assignment.BookStore.CLI.BookStoreCLI;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		BookStoreCLI.runner(args);
	}


}
