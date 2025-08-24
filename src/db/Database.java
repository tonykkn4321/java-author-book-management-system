package db;

import config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Database {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Map<String, String> config = Config.getDBConfig();
            try {
                Class.forName(config.get("driver"));
                connection = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password")
                );
                createTablesIfNotExist(connection);
            } catch (ClassNotFoundException e) {
                throw new SQLException("JDBC Driver not found", e);
            }
        }
        return connection;
    }

    private static void createTablesIfNotExist(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String createAuthors = """
            CREATE TABLE IF NOT EXISTS authors (
                id INT PRIMARY KEY AUTO_INCREMENT,
                first_name VARCHAR(100),
                last_name VARCHAR(100)
            );
        """;

        String createBooks = """
            CREATE TABLE IF NOT EXISTS books (
                id INT PRIMARY KEY AUTO_INCREMENT,
                title VARCHAR(255),
                year INT,
                authorId INT,
                FOREIGN KEY (authorId) REFERENCES authors(id)
            );
        """;

        stmt.execute(createAuthors);
        stmt.execute(createBooks);
    }
}
