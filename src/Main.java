import javax.swing.*;
import java.io.IOException;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    public static void main(String[] args) {
//
        try {
            App app = new App(FILE_PATH);
            app.run();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
