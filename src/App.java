import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";
    private final StringProperty promptLabelText = new SimpleStringProperty("");
    private final StringProperty inputData = new SimpleStringProperty("");
    private final StringProperty outputText = new SimpleStringProperty("");
    List<Car> cars = initializeInsetData();

    public App() throws IOException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContents(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("EWIDENCJA Remarketing");
        stage.show();
    }

    public List<Car> initializeInsetData() throws IOException {
        Path path = Paths.get(FILE_PATH);
        List<String[]> rows = CsvReader.readCsvFile(path);
        List<Car> cars = new ArrayList<>();

        for (String[] row : rows) {
            Car car = new Car(row);
            cars.add(car);
        }
        return cars;
    }

    private Region createContents() throws IOException {
        VBox wholeView = new VBox(createTopButtons(), createPromptLabel(), createInputField(), createConfirmationButton(), createFeedbackLabel());
        wholeView.getStylesheets().add(this.getClass().getResource("/styled.css").toExternalForm());
        return wholeView;
    }

    private Node createTopButtons() {
        HBox topButtons = new HBox(createTopUniversalButton("Nr rej. / VIN", "Wpisz nr rej. lub VIN, aby wyświetlić parametry pojazdu"),
                createTopUniversalButton("Komentarze", "Wpisz datę, aby wyświetlić pojazdy z komentarzami z tego dnia (dd.mm.rrrr)"),
                createTopUniversalButton("Faktury danego dnia", "Wpisz datę, aby wyświetlić listę faktur z tego dnia (dd.mm.rrrr)"));
        topButtons.setSpacing(10);
        topButtons.setPadding(new Insets(10));
        topButtons.setAlignment(Pos.BASELINE_CENTER);
        return topButtons;
    }

    private Node createTopUniversalButton(String title, String labelSetter) {
        Button button = new Button(title);
        button.getStyleClass().add("top-button");
        button.setOnAction(e -> {
            promptLabelText.set(labelSetter);
        });
        return button;
    }

    private Node createPromptLabel() {
        Label promptLabel = new Label("");
        promptLabel.getStyleClass().add("prompt-label");
        promptLabel.textProperty().bind(promptLabelText);
        return promptLabel;
    }

    private Node createInputField() {
        TextField inputFieldLabel = new TextField("");
        inputFieldLabel.textProperty().bindBidirectional(inputData);
        return inputFieldLabel;
    }

    private Node createConfirmationButton() {
        Button confirmationButton = new Button("OK");
        HBox wrapper = new HBox(confirmationButton);
        wrapper.setAlignment(Pos.CENTER);
        return wrapper;
    }

    private Node createFeedbackLabel() throws IOException {
        TextArea feedbackLabel = new TextArea("");
        feedbackLabel.textProperty().bind(outputText);
        feedbackLabel.setEditable(false);
        feedbackLabel.setWrapText(true);
        feedbackLabel.setPadding(new Insets(10));
        feedbackLabel.getStyleClass().add("feedback-label");
        return feedbackLabel;
    }
}