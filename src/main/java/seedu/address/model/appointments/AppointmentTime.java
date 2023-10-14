package seedu.address.model.appointments;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentTime {
    private LocalDateTime start;
    private Duration duration;
    public static final String VALIDATION_REGEX = "[^\\s].*";

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

    public boolean isStartTimeBetween(AppointmentTime other) {
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
