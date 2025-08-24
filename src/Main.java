import db.Database;
import routes.Router;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize database connection and auto-create tables
            Database.getConnection();

            // Start the REST API server
            Router.startServer();

            System.out.println("✅ Server is running at http://localhost:7000");
            System.out.println("Available endpoints:");
            System.out.println("  GET    /authors");
            System.out.println("  POST   /authors");
            System.out.println("  GET    /books");
            System.out.println("  POST   /books");

        } catch (Exception e) {
            System.err.println("❌ Startup error: " + e.getMessage());
        }
    }
}
