package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Employee;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage {
    private static final String FILE_PATH = "data/employees.json";
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
}
