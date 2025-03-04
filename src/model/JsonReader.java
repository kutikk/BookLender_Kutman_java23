package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonReader {
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static List<Book> books = new ArrayList<>();
    public static void addBookToEmployee(int employeeId, int bookId) {
        Employee employee = employees.get(employeeId);
        Book book = getBookById(bookId);
        if (employee != null && book != null) {
            employee.getCurrentBooks().add(book);
            utils.EmployeeStorage.addEmployee(employee);
        }
    }
    public static Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public static void addBook(Book book) {
        books.add(book);
    }
}

