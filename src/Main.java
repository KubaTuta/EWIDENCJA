import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    public static void main(String[] args) {
        try {
            Path path = Paths.get(FILE_PATH);
            List<String[]> rows = CsvReader.readCsvFile(path);
            List<Car> cars = new ArrayList<>();

            for (String[] row : rows) {
                Car car = new Car(row);
                cars.add(car);
            }
            CarMethods.showDailyInvoiceNumbers(cars, "2.10.2025");
            CarMethods.showDailyComments(cars, "30.09.2025");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
