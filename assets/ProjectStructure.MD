# Project Structure:
java-author-book-management-system/
├── lib/                      # Javalin and JDBC .jar files
├── out/                     # Compiled .class files
└── src/
    ├── Main.java
    ├── config/
    │   └── Config.java
    ├── db/
    │   └── Database.java
    ├── models/
    │   ├── Author.java
    │   └── Book.java
    ├── dao/
    │   ├── AuthorDAO.java
    │   └── BookDAO.java
    └── routes/
        └── Router.java




# Compile the Project (run from root directory):
javac -cp "lib/*" -d out src\Main.java src\config\Config.java src\db\Database.java src\models\Author.java src\models\Book.java src\dao\AuthorDAO.java src\dao\BookDAO.java src\routes\Router.java

# Run the Server (run from root directory):
java -cp "lib/*;out" Main






