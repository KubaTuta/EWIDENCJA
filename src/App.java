import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        var dailyInvoicesButton = new Button("Faktury danego dnia");
        var commentsButton = new Button("Komentarze");
        var findCarInfoButton = new Button("Nr rej. / VIN");
        var promptLabel = new Label("Znajdź auto po tablicy lub VINie");
        var inputField = new TextField();
        var confirmationButton = new Button("OK");
        var feedbackLabel = new Label();

        var topButtons = new HBox(10, dailyInvoicesButton, commentsButton, findCarInfoButton);
        var layout = new VBox(10, topButtons, promptLabel, inputField, confirmationButton, feedbackLabel);

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

        dailyInvoicesButton.setOnAction(e -> {
            promptLabel.setText(" Wpisz datę, aby wyświetlić listę faktur z tego dnia (dd.mm.rrrr)");
            promptNumber = 1;
            inputField.clear();
        });

        commentsButton.setOnAction(e -> {
            promptLabel.setText(" Wpisz datę, aby wyświetlić komentarze do aut z tego dnia (dd.mm.rrrr)");
            promptNumber = 2;
            inputField.clear();
        });

        findCarInfoButton.setOnAction(e -> {
            promptLabel.setText("Wpisz nr rej. aby wyświetlić dane auta");
            promptNumber = 3;
            inputField.clear();
        });

        confirmationButton.setOnAction(e -> {
            String inputString = inputField.getText();
            switch (promptNumber) {
                case 1:

                    feedbackLabel.setText(CarMethods.showDailyInvoiceNumbers(cars, inputString));
                    break;
                case 2:
                    feedbackLabel.setText(CarMethods.showDailyComments(cars, inputString));
                    break;
                case 3:
                    feedbackLabel.setText(CarMethods.showCarOfInterest(cars, inputString));
                    break;
//                default:
//                throw new IllegalStateException("Zły format odpowiedzi: " + promptNumber);
            }
        });
    }
}
