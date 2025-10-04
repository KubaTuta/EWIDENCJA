import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    public void run() throws IOException {
        Path path = Paths.get(FILE_PATH);
        List<String[]> rows = CsvReader.readCsvFile(path);
        List<Car> cars = new ArrayList<>();

        for (String[] row : rows) {
            Car car = new Car(row);
            cars.add(car);
        }

        CarMethods.showDailyComments(cars, "29.09.2025");
    }
}
