import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App extends Application {
    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";
    int promptNumber;

    @Override
    public void start(Stage stage) throws Exception {
        var promptLabel = new Label(" Co chcesz zrobić? \n [1] Wyświetl numery faktur z danego dnia \n " +
                "[2] Wyświetl komentarze do aut z danego dnia \n [3] Znajdź auto po tablicy lub VINie");
        var inputField = new TextField();
        var confirmationButton = new Button("OK");
        var feedbackLabel = new Label();
        var layout = new VBox(10, promptLabel, inputField, confirmationButton, feedbackLabel);

        var scene = new Scene(layout, 800, 300);
        stage.setScene(scene);
        stage.setTitle("Ewidencja Remarketing");
        stage.show();


        Path path = Paths.get(FILE_PATH);
        List<String[]> rows = CsvReader.readCsvFile(path);
        List<Car> cars = new ArrayList<>();

        for (String[] row : rows) {
            Car car = new Car(row);
            cars.add(car);
        }

        confirmationButton.setOnAction(e -> {
            String inputString = inputField.getText();
            int typeOfAction = Integer.parseInt(inputString);
            if (typeOfAction == 1) {
                feedbackLabel.setText(CarMethods.showDailyInvoiceNumbers(cars, "30.09.2025"));
                promptLabel.setText(" podaj datę");
            } else if (typeOfAction == 2) {
                promptLabel.setText(" podaj datę");
            } else if (typeOfAction == 3) {
                promptLabel.setText("podaj nr tablicy lub VIN");
            }
            inputField.clear();
        });
//
//        System.out.println("Co chcesz zrobić?");
//        System.out.println("[1] Wyświetl numery faktur z danego dnia");
//        System.out.println("[2] Wyświetl komentarze do aut z danego dnia");
//        System.out.println("[3] Znajdź auto po tablicy lub VINie");
//
//        Scanner sc = new Scanner(System.in);
//        int yourChoiceIs = sc.nextInt();
//        sc.nextLine();
//
//        System.out.println("Wpisz datę w formacie DD.MM.RRRR");
//        String input = sc.nextLine();
//        switch (yourChoiceIs) {
//            case 1:
//                CarMethods.showDailyInvoiceNumbers(cars, input);
//                break;
//            case 2:
//                CarMethods.showDailyComments(cars, input);
//                break;
//            case 3:
//                CarMethods.showCarOfInterest(cars, input);
//                break;
//            default:
//                throw new IllegalStateException("Zły format odpowiedzi: " + yourChoiceIs);
//        }
    }
}
