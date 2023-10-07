package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Service in the address book. Guarantees: immutable; is valid as declared in
 * {@link #isValidService(String)}
 */
public class Service {

    public static final String MESSAGE_CONSTRAINTS = "Should be a valid string";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param service A valid service.
     */
    public Service(String service) {
        requireNonNull(service);
        checkArgument(isValidService(service), MESSAGE_CONSTRAINTS);
        value = service;
    }

    /**
     * Returns true if a given string is a valid service.
     */
    public static boolean isValidService(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Service)) {
            return false;
        }

        Service otherDate = (Service) other;
        return value.equals(otherDate.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
