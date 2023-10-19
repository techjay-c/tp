package seedu.address.model.treatment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a treatment's start time in the address book. Guarantees: immutable; is valid as
 * declared in {@link #isValidTime(String)}
 */
public class TreatmentTime {

    public static final String MESSAGE_CONSTRAINTS =
        "Treatment Time should only be in the following format HH:MM";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String treatmentTime;

    /**
     * Constructs a {@code TreatmentName}.
     *
     * @param time A valid time.
     */
    public TreatmentTime(String time) {
        requireNonNull(time);
        checkArgument(isValidTime(time), MESSAGE_CONSTRAINTS);
        treatmentTime = time;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return treatmentTime;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TreatmentTime)) {
            return false;
        }

        TreatmentTime otherTime = (TreatmentTime) other;
        return treatmentTime.equals(otherTime.treatmentTime);
    }

    @Override
    public int hashCode() {
        return treatmentTime.hashCode();
    }

}
