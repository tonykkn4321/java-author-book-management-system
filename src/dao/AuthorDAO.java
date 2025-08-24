package dao;

import db.Database;
import models.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    public List<Author> getAllAuthors() throws SQLException {
        Connection conn = Database.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM authors");

        List<Author> authors = new ArrayList<>();
        while (rs.next()) {
            authors.add(new Author(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name")
            ));
        }
        return authors;
    }

    public void addAuthor(Author author) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO authors (first_name, last_name) VALUES (?, ?)"
        );
        stmt.setString(1, author.getFirst_name());
        stmt.setString(2, author.getLast_name());
        stmt.executeUpdate();
    }
}
