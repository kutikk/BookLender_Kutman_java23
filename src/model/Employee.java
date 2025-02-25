package model;

import java.util.List;

public class Employee {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<Book> getCurrentBooks() {
        return currentBooks;
    }

    public List<Book> getPastBooks() {
        return pastBooks;
    }

    private int id;
    private String name;
    private String avatar;
    private List<Book> currentBooks;
    private List<Book> pastBooks;

    public Employee(int id, String name,String avatar, List<Book> currentBooks, List<Book> pastBooks) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.currentBooks = currentBooks;
        this.pastBooks = pastBooks;
    }
}
