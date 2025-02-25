package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookLenderDataModel {
    public static Map<String, Object> BookListDataModel() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Martin Iden", "Jack London", "images/martin.jpg", "Свободен"));
        books.add(new Book(2, "1984", "George Orwell", "images/1984.png", "Занят"));
        books.add(new Book(3, "Ak keme", "Chyngyz Aitmatov", "images/akkeme.png", "Свободен"));
        books.add(new Book(4, "Гарри Поттер", "K. Rouling", "images/garri.png", "Свободен"));
        books.add(new Book(5, "Милдмарч", "Джордж Элиот", "images/mildmarch.png", "Свободен"));
        books.add(new Book(6, "Распад", "Jack London", "images/raspad.png", "Свободен"));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("beforeBooks", books);
        return dataModel;
    }
    public static Map<String, Object> InformDataModel(){
        Book garriPotter = new Book(7,"Garri Potter","K. Rouling","images/garri.png","Занят");
        Map<String,Object> dat = new HashMap<>();
        dat.put("Garri",garriPotter);
        return dat;
    }
    public static Map<String,Object> EmployeeDataModel() {
        Book garriPotter = new Book(7, "Garri Potter", "K. Rouling", "images/garri.png", "Занят");
        Book akkeme = new Book(7, "Ak-keme", "Chyngyz Aitmatov", "images/akkeme.png", "Свободна");
        Book raspad = new Book(7, "Raspad", "K. Rouling", "images/raspad.png", "Занят");
        List<Book> currentBooks = new ArrayList<>();
        currentBooks.add(garriPotter);
        currentBooks.add(akkeme);
        currentBooks.add(raspad);
        Book mildmarch   = new Book(7, "Mildmarch", "K. Rouling", "images/mildmarch.png", "Свободна");
        Book book1984 = new Book(2, "1984", "George Orwell", "images/1984.png", "Свободна");
        List<Book>  pastBooks = new ArrayList<>();
        pastBooks.add(mildmarch);
        pastBooks.add(book1984);


        Employee kutman = new Employee(1, "Kutman Okenov", "images/shelbi.png",currentBooks, pastBooks);

        Map<String, Object> emplData = new HashMap<>();
        emplData.put("Employee", kutman);
        return emplData;
    }
}
