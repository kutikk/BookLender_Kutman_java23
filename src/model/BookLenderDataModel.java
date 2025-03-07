package model;
import utils.JsonReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookLenderDataModel {
    public static Map<String, Object> BookListDataModel() {
        List<Book> jsonBook = JsonReader.loadBooks();
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("beforeBooks", jsonBook);
        return dataModel;
    }

}
