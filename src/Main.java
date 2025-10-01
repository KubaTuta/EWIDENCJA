import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";

    static void main(String[] args) {

        try {
            Path path = Paths.get(FILE_PATH);
            List<String[]> rows = CsvReader.readCsvFile(path);
            List<Car> cars = new ArrayList<>();

            for (String[] row : rows) {
                Car car = new Car(row);
                cars.add(car);
            }

            for (Car car : cars) {
                System.out.println(car.allAttributeNames());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
