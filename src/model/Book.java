package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String imagePath;
    private String status;

    public Book(int id, String title, String author, String imagePath, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getImage() { return imagePath; }
    public String getStatus() { return status; }
}


