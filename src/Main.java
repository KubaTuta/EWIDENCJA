import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    private static void loopRemovingLineBreaks(String[] carAttributes) {
        for (int i = 0; i < carAttributes.length; i++) {
            carAttributes[i] =
                    (carAttributes[i] == null) ? "" : carAttributes[i].replace("\n", " ").replace("\r", " ").trim();
        }
    }

    static void main(String[] args) {


        try {
            System.out.println("zawartość pliku");
            Path path = Paths.get(FILE_PATH);
            List<String> rows = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String row : rows) {
                String[] carAttributes = row.split(";");

                loopRemovingLineBreaks(carAttributes);

                for (String singleCarAttribute : carAttributes) {
                    System.out.print(singleCarAttribute + "; ");
                }

                System.out.println(" ");
                System.out.println("-------------------------------------------------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
