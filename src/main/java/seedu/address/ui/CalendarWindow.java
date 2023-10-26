package seedu.address.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.calendarfx.model.*;
import com.calendarfx.view.CalendarView;

import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.appointments.Appointment;

/**
 * Controller for a calendar page.
 */
public class CalendarWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);

    private final CalendarView calendarView;
    private static CalendarWindow instance = null;
    private List<Entry<Appointment>> calendarEntries = new ArrayList<>();

    /**
     * Creates a new CalendarWindow.
     *
     * @param root Stage to use as the root of the CalendarWindow.
     */
    public CalendarWindow(Stage root) {
        super(root);
        this.calendarView = new CalendarView();
        root.setScene(new Scene(calendarView));

        root.setWidth(800);
        root.setHeight(600);

        initialiseCalendarSettings();
    }

    /**
     * Creates a new CalendarWindow.
     */
    private CalendarWindow() {
        this(new Stage());
    }


    public static CalendarWindow getInstance() {
        if (instance == null) {
            instance = new CalendarWindow();
        }
        return instance;
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
        getCalendarRoot().show();
        getCalendarRoot().centerOnScreen();
    }

    /**
     * Returns true if the calendar window is currently being shown.
     */
    public boolean isShowing() {
        return getCalendarRoot().isShowing();
    }

    /**
     * Hides the calendar window.
     */
    public void hide() {
        getCalendarRoot().hide();
    }

    /**
     * Focuses on the calendar window.
     */
    public void focus() {
        getCalendarRoot().requestFocus();
    }

    private void initialiseCalendarSettings() {
        calendarView.setShowPageToolBarControls(true);
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(true);
        calendarView.setShowPrintButton(false);
        calendarView.setShowSourceTrayButton(true);
        calendarView.setShowSearchField(false);

        calendarView.showMonthPage(); // Default view is Month

        // Disable drag and drop of events
        calendarView.setEntryEditPolicy(param -> false);
    }

    /**
     * Ensure there's an "Appointment" calendar and return it.
     * If it doesn't exist, create it and add to calendarView.
     */
    private Calendar getCalendar() {
        return calendarView.getCalendarSources().get(0).getCalendars().get(0);
    }

    /**
     * Converts an appointment to a CalendarFX entry.
     *
     * @param appointment Appointment to be converted.
     * @return Entry object representing the appointment.
     */
    private Entry<Appointment> convertToEntry(Appointment appointment) {
        com.calendarfx.model.Entry<Appointment> entry = new com.calendarfx.model.Entry<>();
        String entryTitle = appointment.getTreatment();
        entry.setTitle(entryTitle);

        LocalDateTime startTime = appointment.getAppointmentTime().getStart();
        Duration duration = appointment.getAppointmentTime().getDuration();
        LocalDateTime endTime = startTime.plus(duration);
        entry.setInterval(startTime, endTime);
        return entry;
    }

    /**
     * Loads a list of appointments into the calendar.
     *
     * @param appointments List of appointments to be loaded.
     */
    public void loadAppointments(List<Appointment> appointments) {
        System.out.println("Inside loadAppointments");
        // Clear old entries
        calendarEntries.clear();

        Calendar appointmentCalendar = getCalendar();

        // Check if CalendarView has calendars before accessing it
        for (Appointment appt : appointments) {
            Entry<Appointment> entry = convertToEntry(appt);
            calendarEntries.add(entry);
            appointmentCalendar.addEntry(entry);
        }

    }

    /**
     * Removes an appointment from the calendar.
     *
     * @param appt Appointment to be removed.
     */
    public void removeAppointment(Appointment appt) {
        // Find the entry
        Entry<Appointment> entryToRemove = calendarEntries.stream()
                .filter(e -> e.getUserObject().equals(appt))
                .findFirst()
                .orElse(null);

        if (entryToRemove != null) {
            calendarView.getCalendars().get(0).removeEntry(entryToRemove);
            calendarEntries.remove(entryToRemove);
        }
    }

    /**
     * Updates an appointment in the calendar.
     *
     * @param oldAppt Old appointment entry to be replaced.
     * @param newAppt New appointment entry to replace the old one.
     */
    public void updateAppointment(Appointment oldAppt, Appointment newAppt) {
        // Find the old entry
        Entry<Appointment> oldEntry = calendarEntries.stream()
                .filter(e -> e.getUserObject().equals(oldAppt))
                .findFirst()
                .orElse(null);

        if (oldEntry != null) {
            // Remove old entry
            calendarView.getCalendars().get(0).removeEntry(oldEntry);
            calendarEntries.remove(oldEntry);

            // Add new entry
            Entry<Appointment> newEntry = convertToEntry(newAppt);
            calendarEntries.add(newEntry);
            calendarView.getCalendars().get(0).addEntry(newEntry);
        }
    }


}
