package config;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private static final String ENV = System.getenv("APP_ENV") != null
        ? System.getenv("APP_ENV")
        : "development";

    public static Map<String, String> getDBConfig() {
        Map<String, String> config = new HashMap<>();

        switch (ENV.toLowerCase()) {
            case "production":
                config.put("url", System.getenv("DATABASE_URL"));
                config.put("driver", "org.postgresql.Driver");
                config.put("username", System.getenv("DB_USERNAME"));
                config.put("password", System.getenv("DB_PASSWORD"));
                break;

            case "test":
                config.put("url", "jdbc:sqlite:test.sqlite");
                config.put("driver", "org.sqlite.JDBC");
                config.put("username", "");
                config.put("password", "");
                break;

            default:
                config.put("url", "jdbc:mysql://localhost:3306/author_book_management_system?createDatabaseIfNotExist=true");
                config.put("driver", "com.mysql.cj.jdbc.Driver");
                config.put("username", "root");
                config.put("password", "Aa161616");
                break;
        }

        return config;
    }
}
