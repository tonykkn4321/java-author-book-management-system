package models;

public class Book {
    private int id;
    private String title;
    private int year;
    private int authorId;

    public Book() {}

    public Book(String title, int year, int authorId) {
        this.title = title;
        this.year = year;
        this.authorId = authorId;
    }

    public Book(int id, String title, int year, int authorId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', year=" + year + ", authorId=" + authorId + "}";
    }
}
