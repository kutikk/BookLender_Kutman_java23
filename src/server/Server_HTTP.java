package server;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import model.Book;
import model.BookLenderDataModel;
import model.Employee;
import utils.EmployeeStorage;
import utils.Helper;
import utils.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server_HTTP extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();


    public  Server_HTTP(String host, int port) throws IOException {
        super(host, port);
        registerGet("/books", this::freemarkerSampleHandler);
        registerGet("/info", this::freemarkerInfoHandler);
        registerGet("/employee",this::freemarkerEmployeeHandler);
        registerGet("/register",this::regGEt);
        registerPost("/register",this::regPost);
        registerGet("/login",this::logGet);
        registerPost("/login",this::logPost);
        registerGet("/profile",this::authoGet);

    }
    private void authoGet(HttpExchange exchange) {
        Employee employee = (Employee) exchange.getAttribute("employee");

        if (employee == null) {
            employee = new Employee();
            employee.setName("Некий пользователь");
            employee.setPassword("******");
            employee.setAvatar("/images/avatar_placeholder.jpg");
        }

        Map<String, Object> model = new HashMap<>();
        model.put("employee", employee);

        renderTemplate(exchange, "profile.ftlh", model);
    }

    private void regGEt(HttpExchange exchange){
        Path path = makeFilePath("/register.ftlh");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }
    private void regPost(HttpExchange exchange) throws IOException {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");

        String username = parsed.get("username");
        String password = parsed.get("password");

        if (username == null || password == null) {
            String redirectPage = Helper.getHTMLNotAllData();

            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, redirectPage.getBytes(StandardCharsets.UTF_8).length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(redirectPage.getBytes(StandardCharsets.UTF_8));
            }
            return;
        }

        List<Employee> employees = EmployeeStorage.loadEmployees();

        for (Employee emp : employees) {
            if (emp.getName().equals(username)) {
                String redirectPage = Helper.getHTMLinFailedRegister();

                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(200, redirectPage.getBytes(StandardCharsets.UTF_8).length);

                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(redirectPage.getBytes(StandardCharsets.UTF_8));
                }
                return;
            }
        }

        int newId = employees.isEmpty() ? 1 : employees.get(employees.size() - 1).getId() + 1;

        Employee newEmployee = new Employee(newId, username, password);
        EmployeeStorage.addEmployee(newEmployee);

        String redirectPage = Helper.getSuccesHTML();
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, redirectPage.getBytes(StandardCharsets.UTF_8).length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(redirectPage.getBytes(StandardCharsets.UTF_8));
        }
        return;
    }
    private void sendResponse(HttpExchange exchange, String message, int statusCode) {
        try {
            byte[] responseBytes = message.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logGet(HttpExchange exchange){
        Path path = makeFilePath("/login.ftlh");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }
    private void logPost(HttpExchange exchange) throws IOException {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        String username = parsed.get("username");
        String password = parsed.get("password");

        if (username == null ||     password == null) {
            sendResponse(exchange, "Ошибка: не все данные переданы!", ResponseCodes.NOT_FOUND.getCode());
            return;
        }

        List<Employee> employees = EmployeeStorage.loadEmployees();

        for (Employee emp : employees) {
            if (emp.getName().equals(username) && emp.getPassword().equals(password)) {
                Map<String, Object> model = new HashMap<>();
                model.put("employee", emp);


                renderTemplate(exchange, "profile.ftlh", model);
                return;
            }
        }
        int newId = employees.isEmpty() ? 1 : employees.get(employees.size() - 1).getId() + 1;

        Employee newEmployee = new Employee(newId, username, password);
        EmployeeStorage.addEmployee(newEmployee);

        String redirectPage = Helper.getHTMLWrongPassword();
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, redirectPage.getBytes(StandardCharsets.UTF_8).length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(redirectPage.getBytes(StandardCharsets.UTF_8));
        }
    }






    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("data"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void freemarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "books.ftlh", getSampleDataModel());
    }
    private void freemarkerInfoHandler(HttpExchange exchange) {
        renderTemplate(exchange, "info.ftlh", getInformDataModel()  );
    }
    private void freemarkerEmployeeHandler(HttpExchange exchange) {
        renderTemplate(exchange, "employee.ftlh", getEmlDataModel());
    }


    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                temp.process(dataModel, writer);
                writer.flush();
                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getSampleDataModel() {
        return BookLenderDataModel.BookListDataModel();
    }
    private Map<String,Object> getInformDataModel() {
        return BookLenderDataModel.InformDataModel();
    }
    private Map<String ,Object> getEmlDataModel(){
        return BookLenderDataModel.EmployeeDataModel();
    }

}



