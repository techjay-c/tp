package seedu.address.model.person.dentist;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Doctor's specialty in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSpecialization(String)}
 */
public class Specialization {

    public static final String MESSAGE_CONSTRAINTS =
            "Specialization should only contain alphanumeric characters and spaces, and it should not be blank!";

    /*
     * The first character of the specialty must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    private static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private final String specialization;

    /**
     * Constructs a {@code Specialization}.
     *
     * @param specialization A valid specialization.
     */
    public Specialization(String specialization) {
        requireNonNull(specialization);
        checkArgument(isValidSpecialization(specialization), MESSAGE_CONSTRAINTS);
        this.specialization = specialization;
    }

    /**
     * Returns true if a given string is a valid specialization.
     */
    public static boolean isValidSpecialization(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return specialization;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Specialization // instanceof handles nulls
                && specialization.equals(((Specialization) other).specialization)); // state check
    }

    @Override
    public int hashCode() {
        return specialization.hashCode();
    }

    public String getValue() {
        return specialization;
    }
}
