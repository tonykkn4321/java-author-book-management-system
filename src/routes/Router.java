package routes;

import io.javalin.Javalin;
import dao.AuthorDAO;
import dao.BookDAO;
import models.Author;
import models.Book;

import java.util.List;

public class Router {
    public static void startServer() {
        Javalin app = Javalin.create().start(7000);

        // Instantiate DAO objects
        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();

        // Author endpoints
        app.get("/authors", ctx -> {
            try {
                List<Author> authors = authorDAO.getAllAuthors();
                ctx.json(authors);
            } catch (Exception e) {
                ctx.status(500).result("Error fetching authors: " + e.getMessage());
            }
        });

        app.post("/authors", ctx -> {
            try {
                Author author = ctx.bodyAsClass(Author.class);
                authorDAO.addAuthor(author);
                ctx.status(201).json(author);
            } catch (Exception e) {
                ctx.status(500).result("Error adding author: " + e.getMessage());
            }
        });

        // Book endpoints
        app.get("/books", ctx -> {
            try {
                List<Book> books = bookDAO.getAllBooks();
                ctx.json(books);
            } catch (Exception e) {
                ctx.status(500).result("Error fetching books: " + e.getMessage());
            }
        });

        app.post("/books", ctx -> {
            try {
                Book book = ctx.bodyAsClass(Book.class);
                bookDAO.addBook(book);
                ctx.status(201).json(book);
            } catch (Exception e) {
                ctx.status(500).result("Error adding book: " + e.getMessage());
            }
        });
    }
}
