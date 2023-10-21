package seedu.address.model.person.dentist;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a dentist's Years of Expetience (YoE) in ToothTracker address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidYoe(String)}
 */
public class Yoe {
    public static final String FULL_CLASS_NAME = "Years of Experience";
    public static final String MESSAGE_CONSTRAINTS =
            "Years of Experience (YOE) should only contain numbers, and it should be at most 2 digits long";
    private static final String VALIDATION_REGEX = "^0*[0-9][0-9]{0,1}$";
    private final String value;

    /**
     * Constructs a {@code YOE}.
     *
     * @param yearsOfExperience A valid number of years.
     */
    public Yoe(String yearsOfExperience) {
        requireNonNull(yearsOfExperience);
        checkArgument(isValidYoe(yearsOfExperience), MESSAGE_CONSTRAINTS);
        yearsOfExperience = yearsOfExperience.replaceFirst("^0+(?!S)", "");
        value = yearsOfExperience;
    }

    /**
     * Returns true if a given string is a valid format for Years of Experience.
     * @param test The input of years of experience to be tested.
     */
    public static boolean isValidYoe(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // Short Circuit
                || (other instanceof Yoe)
                && value.equals(((Yoe) other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public String getValue() {
        return value;
    }


}
