package server;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import model.BookLenderDataModel;

import java.io.*;
import java.util.Map;

public class Server_HTTP extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();

    public  Server_HTTP(String host, int port) throws IOException {
        super(host, port);
        registerGet("/books", this::freemarkerSampleHandler);
        registerGet("/info", this::freemarkerInfoHandler);
        registerGet("/employee",this::freemarkerEmployeeHandler);

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



