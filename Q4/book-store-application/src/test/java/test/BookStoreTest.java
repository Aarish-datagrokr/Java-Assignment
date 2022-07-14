package test;

import org.datagrokr.assignment.BookStore.BookStore;
import org.datagrokr.assignment.BookStore.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookStoreTest {
    Book book;
    BookStore bookStore;

    @BeforeEach
    void setUp() {
        book = new Book();
        bookStore = new BookStore();
    }

    @AfterEach
    void tearDown() {
        book.setBookName("");
        book.setAuthor("");
        book.setGenre("");
    }

    @Test
    @DisplayName("Add Book test")
    void addBook() {
        book.setBookName("Test Sample");
        book.setGenre("Test Sample");
        book.setAuthor("Test Sample");
        String expected = "Test Sample added to the database.";
        String actual = bookStore.addBook(book);
        assertEquals(expected,actual);
    }

    @Test
    void deleteBook() {
        int id = 1;
        String expected = "Book with id : "+id+" deleted.";
        String actual = bookStore.deleteBook(id);
        assertEquals(expected,actual);
    }

    @Test
    void findBookById() {
        int id = 1;
        Object expected = book.getClass().getName();
        Object actual = bookStore.findBookById(id).getClass().getName();
        assertEquals(expected,actual);
    }
}