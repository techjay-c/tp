package seedu.address.model.person.dentist;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Doctor's specialty in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSpecialization(String)}
 */
public class Specialization {

    public enum Recognized_specialization {
        ORTHODONTICS,
        ENDODONTICS,
        PROSTHODONTICS,
        PERIODONTICS,
        DENTAL_PUBLIC_HEALTH,
        ORAL_AND_MAXILLOFACIAL_SURGERY,
        PAEDIATRIC_DENTISTRY,
    };

    public static String[] recognizedSpecs = {
            "ORTHODONTICS",
            "ENDODONTICS",
            "PROSTHODONTICS",
            "PERIODONTICS",
            "DENTAL PUBLIC HEALTH",
            "ORAL AND MAXILLOFACIAL SURGERY",
            "PAEDIATRIC DENTISTRY",
    };

    public static final String MESSAGE_CONSTRAINTS = getMessageConstraints();

    /*
     * The first character of the specialty must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    private static final String VALIDATION_REGEX =
            "ENDODONTICS|DENTAL PUBLIC HEALTH|ORAL AND MAXILLOFACIAL SURGERY|ORTHODONTICS|" +
            "|PAEDIATRIC DENTISTRY|PERIODONTICS|PROSTHODONTICS";

    private final String specialization;

    /**
     * Constructs a {@code Specialization}.
     *
     * @param specialization A valid specialization.
     */
    public Specialization(String specialization) {
        requireNonNull(specialization);
        checkArgument(isValidSpecialization(specialization), MESSAGE_CONSTRAINTS);
        this.specialization = specialization.toUpperCase();
    }

    /**
     * Returns true if a given string is a valid specialization.
     */
    public static boolean isValidSpecialization(String test) {
        String formattedTest = test.toUpperCase(); // Convert test to uppercase for comparison

        for (String specs : recognizedSpecs) {
            if (specs.equals(formattedTest)) {
                return true && formattedTest.matches(VALIDATION_REGEX);
            }
        }
        return false;
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

    public static String getMessageConstraints() {
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized Specialization entered! "
                + "Currently the following are recognized dental specialization in Singapore:\n");
        for (String specs : recognizedSpecs) {
            sb.append(specs).append("\n");
        }
        sb.append("\nSource: "
                + "https://www.healthprofessionals.gov.sg/dsab/specialist-training/list-of-recognised-specialties"
                + "\nPlease contact ToothTracker developers if you need to modify the recognized specializations!");
        return sb.toString();
    }
}
