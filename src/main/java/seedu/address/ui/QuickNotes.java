package seedu.address.ui;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class QuickNotes extends UiPart<Region> {

    private static final String QUICK_NOTES_PATH = "./data/quicknotes.txt";

    private static final String FXML = "QuickNotes.fxml";

    @FXML
    private TextArea quickNotes;

    @FXML
    private Button saveButton;

    @FXML
    private Button clearButton;

    public QuickNotes() {
        super(FXML);
        initialize();
    }

    private void initialize() {
        saveButton.setOnAction(this::handleSaveNotes);
        clearButton.setOnAction(this::handleClearNotes);
        loadNotesOnStartup();
    }

    @FXML
    private void handleSaveNotes(ActionEvent event) {
        File dir = new File("./data");
        if (!dir.exists()) {
            dir.mkdirs(); // Create the directory if it doesn't exist
        }

        try (FileWriter writer = new FileWriter(QUICK_NOTES_PATH)) {
            writer.write(quickNotes.getText());
        } catch (IOException e) {
            e.printStackTrace();
            // Insert error message
        }
    }

    @FXML
    private void handleClearNotes(ActionEvent event) {
        quickNotes.clear();
    }

    private void loadNotesOnStartup() {
        if (new File(QUICK_NOTES_PATH).exists()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(QUICK_NOTES_PATH)));
                quickNotes.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
                // Insert error message
            }
        }
    }

}
