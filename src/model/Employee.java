package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String avatar;
    private String password;
    private List<Book> currentBooks = new ArrayList<>();
    private List<Book> pastBooks = new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String name, String avatar, List<Book> currentBooks, List<Book> pastBooks) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.currentBooks = currentBooks != null ? currentBooks : new ArrayList<>();
        this.pastBooks = pastBooks != null ? pastBooks : new ArrayList<>();
    }

    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getCurrentBooks() {
        return currentBooks;
    }

    public void setCurrentBooks(List<Book> currentBooks) {
        this.currentBooks = currentBooks;
    }

    public List<Book> getPastBooks() {
        return pastBooks;
    }

    public void setPastBooks(List<Book> pastBooks) {
        this.pastBooks = pastBooks;
    }

    public void addBook(Book book) {
        if (currentBooks == null) {
            currentBooks = new ArrayList<>();
        }
        currentBooks.add(book);
    }
}
