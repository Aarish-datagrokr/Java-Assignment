package org.datagrokr.assignment.BookStore;

import org.datagrokr.assignment.BookStore.JDBC.DBConnection;
import org.datagrokr.assignment.BookStore.entity.Book;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
public class BookStore {

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book_store (book_name,genre,author) values(?,?,?)");
            preparedStatement.setString(1,book.getBookName());
            preparedStatement.setString(2,book.getGenre());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book.getBookName()+" added to the database.";
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book_store where book_id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Book with id : "+id+" deleted.";
    }

    @GetMapping("/getMaxSoldBook/{genre}")
    public Book getBookFromQuery(@PathVariable String genre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book_pu");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        Query query;
        query = entityManager.createNativeQuery("Select book_name from sales inner join book_store on " +
                "book_store.book_id=sales.book_id where book_store.genre=? " +
                "Group by(book_store.book_name) order by(count(sales.book_id)) desc limit 1");
        query.setParameter(1,genre);

        String bookName = (String) query.getSingleResult();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cr = cb.createQuery(Book.class);
        Root<Book> root = cr.from(Book.class);
        cr.select(root).where(cb.equal(root.get("bookName"),bookName));
        List<Book> results = entityManager.createQuery(cr).getResultList();
        if(results.size()==0) return null;
        else {
            return results.get(0);
        }

    }

    @GetMapping("/getBook/{id}")
    public Book findBookById(@PathVariable("id") Integer id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book_store where book_id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()==false)
            {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new RuntimeException("Invalid id : "+id);
            }
            Book book = new Book(resultSet.getInt("book_id"), resultSet.getString("book_name"), resultSet.getString("genre"), resultSet.getString("author"));
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") Integer id, @RequestBody Book book) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        if (Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
            try {
                preparedStatement = connection.prepareStatement("update book_store set book_name=? where book_id=?");
                preparedStatement.setString(1,book.getBookName());
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        if (Objects.nonNull(book.getGenre()) && !"".equalsIgnoreCase(book.getGenre())) {
            try {
                preparedStatement = connection.prepareStatement("update book_store set genre=? where book_id=?");
                preparedStatement.setString(1,book.getGenre());
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
            try {
                preparedStatement = connection.prepareStatement("update book_store set author=? where book_id=?");
                preparedStatement.setString(1,book.getAuthor());
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            connection.close();
        }
        return "Book with id : "+id+" updated.";
    }
}
