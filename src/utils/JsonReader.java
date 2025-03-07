package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Book;
import model.Employee;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    private static final String FILE_PATH = "data/employees.json";
    private static final String FILE_PATH_Book = "data/books.json";


    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Employee> loadEmployees() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(file)) {
            Type employeeListType = new TypeToken<List<Employee>>() {}.getType();
            return gson.fromJson(reader, employeeListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public static List<Book> loadBooks() {
        File file = new File(FILE_PATH_Book);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(file)) {
            Type bookListType = new TypeToken<List<Book>>() {}.getType();
            return gson.fromJson(reader, bookListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public static void saveEmployees(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEmployeeExists(int id) {
        return loadEmployees().stream().anyMatch(emp -> emp.getId() == id);
    }

    public static void addEmployee(Employee newEmployee) {
        List<Employee> employees = loadEmployees();
        employees.add(newEmployee);
        saveEmployees(employees);
    }

    public static boolean addEmpl(int urlid, int bookid) {
        List<Employee> empl = loadEmployees();

        for (Employee e : empl) {
            if (e.getId() == urlid) {
                if (e.getCurrentBooks().size() >= 2) {
                    return false;
                }
                List<Book> listBooks = loadBooks();
                for (Book b : listBooks) {
                    if (b.getId() == bookid) {
                        b.setStatus("Занят");
                        e.getCurrentBooks().add(b);
                        saveEmployees(empl);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void removeBook(int urlid, int bookUrl) {
        List<Employee> employees = loadEmployees();
        for (Employee e : employees) {
            if (e.getId() == urlid) {
                List<Book> books = e.getCurrentBooks();
                books.removeIf(b -> b.getId() == bookUrl);
                List<Book> biblioteka = loadBooks();
                for (Book v : biblioteka){
                    if(v.getId()==bookUrl){
                        e.getPastBooks().add(v);
                    }
                }
                break;
            }
        }
        saveEmployees(employees);
    }



}
