import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    static void main(String[] args) {

        try {
            System.out.println("zawartość pliku");
            Path path = Paths.get(FILE_PATH);
            List<String[]> rows = CsvReader.readCsvFile(path);
            for (String[] row : rows) {

                for (String singleCarAttribute : row) {
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
