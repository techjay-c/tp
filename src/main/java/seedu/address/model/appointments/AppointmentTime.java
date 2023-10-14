package seedu.address.model.appointments;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents the date and time of an appointment in ToothTracker.
 * Provides methods for manipulation and validation of appointment times.
 */
public class AppointmentTime {
    private LocalDateTime start;
    private Duration duration;
    public static final String VALIDATION_REGEX = "[^\\s].*";

    /**
     * Constructs an AppointmentTime object with the specified start time and duration.
     *
     * @param start The start time of the appointment in string format.
     * @param duration The duration of the appointment in string format.
     */
    public AppointmentTime(String start, String duration) {
        this.start = LocalDateTime.parse(start);
        this.duration = Duration.parse(duration);
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public LocalDateTime getEnd() {
        return this.start.plus(duration);
    }

    /**
     * Checks whether this appointment clashes with another.
     *
     * @param other The other appointment.
     * @return true if this appointment clashes with another
     *         false if it does not clash with another appointment.
     */
    public boolean isClashingAppointment(AppointmentTime other) {
        if (other == this) {
            return true;
        }
        LocalDateTime otherStartTime = other.getStart();
        LocalDateTime otherEndTime = other.getEnd();
        return ((this.getStart().isBefore(otherEndTime))
                && (this.getStart().isAfter(otherStartTime))) ||
                (otherStartTime.isEqual(this.getStart())) ||
                ((this.getEnd().isBefore(otherEndTime))
                        && (this.getEnd().isAfter(otherStartTime)));
    }

    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String startToString() {
        return this.start.toString();
    }

    public String durationToString() {
        return this.duration.toString();
    }

    public String endTimeToString() {
        return getEnd().toLocalTime().toString();
    }

    public String startTimeToString() {
        return this.start.toLocalTime().toString();
    }

    public String DateToString() {
        return this.start.toLocalDate().toString();
    }
    public String appointmentTimeToString() {
        return startTimeToString() + " - " + endTimeToString();
    }


}
