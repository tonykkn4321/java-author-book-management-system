package dao;

import db.Database;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() throws SQLException {
        Connection conn = Database.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM books");

        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            books.add(new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("year"),
                rs.getInt("authorId")
            ));
        }
        return books;
    }

    public void addBook(Book book) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO books (title, year, authorId) VALUES (?, ?, ?)"
        );
        stmt.setString(1, book.getTitle());
        stmt.setInt(2, book.getYear());
        stmt.setInt(3, book.getAuthorId());
        stmt.executeUpdate();
    }
}
