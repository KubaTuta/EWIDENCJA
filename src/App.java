import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("Co chcesz zrobić?");
        System.out.println("[1] Wyświetl numery faktur z danego dnia");
        System.out.println("[2] Wyświetl komentarze do aut z danego dnia");

        Scanner sc = new Scanner(System.in);
        int yourChoiceIs = sc.nextInt();
        sc.nextLine();

        switch (yourChoiceIs) {
            case 1:
                System.out.println("Wpisz datę w formacie DD.MM.RRRR");
                String date1 = sc.nextLine();
                CarMethods.showDailyInvoiceNumbers(cars, date1);
                break;
            case 2:
                System.out.println("Wpisz datę w formacie DD.MM.RRRR");
                String date2 = sc.nextLine();
                CarMethods.showDailyInvoiceNumbers(cars, date2);
        }

    }
}
