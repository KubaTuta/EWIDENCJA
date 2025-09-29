import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    private static void loopRemovingLineBreaks(String[] parts) {
        for (int i = 0; i < parts.length; i++) {
            parts[i] =
                    (parts[i] == null) ? "" : parts[i].replace("\n", " ").replace("\r", " ").trim();
        }
    }

    static void main(String[] args) {


        try {
            System.out.println("zawartość pliku");
            Path path = Paths.get(FILE_PATH);
            List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String fileText : strings) {
                String[] parts = fileText.split(";");

                loopRemovingLineBreaks(parts);

                for (String part : parts) {
                    System.out.print(part + "; ");
                }

                System.out.println(" ");
                System.out.println("-------------------------------------------------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
