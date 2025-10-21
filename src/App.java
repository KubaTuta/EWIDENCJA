import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private static final String FILE_PATH = "C:/JAVA/EWIDENCJA/src/csv.csv";
    private final StringProperty promptLabelText = new SimpleStringProperty("");
    private final StringProperty inputData = new SimpleStringProperty("");
    private final StringProperty outputText = new SimpleStringProperty("");

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContents(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("EWIDENCJA Remarketing");
        stage.show();
    }

    private Region createContents() {

        VBox wholeView = new VBox(createTopButtons(), createPromptLabel(), createInputField(), createConfirmationButton(), createFeedbackLabel());

//        dailyInvoicesButton.setOnAction(e -> {
//            promptLabel.setText(" Wpisz datę, aby wyświetlić listę faktur z tego dnia (dd.mm.rrrr)");
//            promptNumber = 1;
//            inputField.clear();
//        });

        return wholeView;
    }

    private Node createTopButtons() {
        HBox topButtons = new HBox(createTopButton("Nr rej. / VIN", "Wpisz nr rej. lub VIN, aby wyświetlić parametry pojazdu"),
                createTopButton("Komentarze", "Wpisz datę, aby wyświetlić pojazdy z komentarzami z tego dnia (dd.mm.rrrr)"),
                createTopButton("Faktury danego dnia", "Wpisz datę, aby wyświetlić listę faktur z tego dnia (dd.mm.rrrr)"));
        topButtons.setSpacing(10);
        topButtons.setPadding(new Insets(10));
        topButtons.setAlignment(Pos.BASELINE_CENTER);
        return topButtons;
    }

    private Node createTopButton(String title, String labelSetter) {
        Button button = new Button(title);
        button.setOnAction(e -> {
            promptLabelText.set(labelSetter);
        });
        return button;
    }

    private Node createPromptLabel() {
        Label promptLabel = new Label("");
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
        return confirmationButton;
    }

    private Node createFeedbackLabel() {
        Label feedbackLabel = new Label("");
        return feedbackLabel;
    }
}