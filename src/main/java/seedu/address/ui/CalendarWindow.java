package seedu.address.ui;

import java.util.logging.Logger;

import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Represents a window that contains a calendar view.
 */
public class CalendarWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);

    /**
     * Creates a new CalendarWindow.
     *
     * @param root Stage to use as the root of the CalendarWindow.
     */
    public CalendarWindow(Stage root) {
        super(root);
    }

    /**
     * Creates a new CalendarWindow.
     */
    public CalendarWindow() {
        this(new Stage());
    }

    /**
     * Shows the calendar window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing Calendar of ToothTracker.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the calendar window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the calendar window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the calendar window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

}
