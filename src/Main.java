import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//
        try {
            App app = new App();
            app.run();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
