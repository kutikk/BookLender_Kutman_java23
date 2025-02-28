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

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCurrentBooks(List<Book> currentBooks) {
        this.currentBooks = currentBooks;
    }

    public void setPastBooks(List<Book> pastBooks) {
        this.pastBooks = pastBooks;
    }

    private  String password;
    private List<Book> currentBooks;
    private List<Book> pastBooks;

    public Employee(int id, String name,String avatar, List<Book> currentBooks, List<Book> pastBooks) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.currentBooks = currentBooks;
        this.pastBooks = pastBooks;
    }
    public Employee(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
