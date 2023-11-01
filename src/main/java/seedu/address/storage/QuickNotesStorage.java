package seedu.address.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A class to access QuickNotes data stored as a txt file on the hard disk.
 */
public class QuickNotesStorage {

    private String QUICK_NOTES_PATH = "./data/quicknotes.txt";

    public QuickNotesStorage() {
    }

    public QuickNotesStorage(String filePath) {
        QUICK_NOTES_PATH = filePath;
    }

    /**
     * Saves the notes to the storage file.
     */
    public void saveNotes(String content) throws IOException {
        File file = new File(QUICK_NOTES_PATH);
        File directory = new File(file.getParent());
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(QUICK_NOTES_PATH)) {
            writer.write(content);
        }
    }

    /**
     * Clears the notes from the storage file.
     */
    public void clearNotes() throws IOException {
        try (FileWriter writer = new FileWriter(QUICK_NOTES_PATH)) {
            writer.write("");
        }
    }

    /**
     * Loads the notes from the storage file.
     */
    public String loadNotes() throws IOException {
        if (!new File(QUICK_NOTES_PATH).exists()) {
            throw new IOException("File not found");
        }
        return new String(Files.readAllBytes(Paths.get(QUICK_NOTES_PATH)));
    }

    public String getQuickNotesPath() {
        return QUICK_NOTES_PATH;
    }
}
