import server.Server_HTTP;
import java.io.IOException;

public class Main {
   private static final int PORT =9889;
    public static void main(String[] args) {
        try {
            new Server_HTTP("localhost", PORT).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}