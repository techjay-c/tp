package seedu.address.ui;

import java.time.LocalTime;
import java.util.logging.Logger;

import com.calendarfx.view.CalendarView;

import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Represents a window that contains a calendar view.
 */
public class CalendarWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);

    private final CalendarView calendarView;
    /**
     * Creates a new CalendarWindow.
     *
     * @param root Stage to use as the root of the CalendarWindow.
     */
    public CalendarWindow(Stage root) {
        super(root);
        this.calendarView = new CalendarView();
        root.setScene(new Scene(calendarView));
        initialiseCalendarSettings();
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

    private void initialiseCalendarSettings() {
        calendarView.setShowAddCalendarButton(true);
        calendarView.setShowPageToolBarControls(true);
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowPrintButton(false);
        calendarView.setShowSourceTrayButton(false);
        calendarView.setShowSearchField(false);
    }

}
