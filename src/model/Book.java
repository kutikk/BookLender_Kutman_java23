package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String imagePath;
    private String status;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book(int id, String title, String author, String imagePath, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getImage() { return imagePath; }
    public String getStatus() { return status; }
}


