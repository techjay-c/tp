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

    private static final String QUICK_NOTES_PATH = "./data/quicknotes.txt";

    /**
     * Saves the notes to the storage file.
     */
    public void saveNotes(String content) throws IOException {
        File dir = new File("./data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (FileWriter writer = new FileWriter(QUICK_NOTES_PATH)) {
            writer.write(content);
        }
    }

    /**
     * Clears all the notes from the storage file.
     */
    public void clearNotes() throws IOException {
        try (FileWriter writer = new FileWriter(QUICK_NOTES_PATH)) {
            writer.write("");
        }
    }

    /**
     * Loads the notes from the storage file.
     *
     * @return null if the file does not exist.
     */
    public String loadNotes() throws IOException {
        if (new File(QUICK_NOTES_PATH).exists()) {
            return new String(Files.readAllBytes(Paths.get(QUICK_NOTES_PATH)));
        }
        return null;
    }
}
