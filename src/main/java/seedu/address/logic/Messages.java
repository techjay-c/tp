package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.person.Person;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.treatment.Treatment;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_DENTIST_DISPLAYED_INDEX = "The dentist index provided is invalid!";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DENTISTS_LISTED_OVERVIEW = "%1$d dentists listed!";

    public static final String MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX = "The patient index provided is invalid";
    public static final String MESSAGE_PATIENTS_LISTED_OVERVIEW = "%1$d patients listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
        "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_DELETE_PATIENT_SUCCESS = "Deleted Patient: %1$s";
    public static final String MESSAGE_DELETE_DENTIST_SUCCESS = "Deleted Dentist: %1$s";
    public static final String MESSAGE_NO_SUCH_PATIENT = "There is no patient in the address book with ID: %1$s";
    public static final String MESSAGE_NO_SUCH_DENTIST = "There is no dentist in the address book with ID: %1$s";


    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
            Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
            .append("; Phone: ")
            .append(person.getPhone())
            .append("; Email: ")
            .append(person.getEmail())
            .append("; Address: ")
            .append(person.getAddress())
            .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * Formats the {@code treatment} for display to the user.
     */
    public static String format(Treatment treatment) {
        final StringBuilder builder = new StringBuilder();
        builder.append(treatment.getName())
            .append("; Cost: ")
            .append(treatment.getCost())
            .append("; Time: ")
            .append(treatment.getTime());
        return builder.toString();
    }

    /**
     * Formats the {@code patient} for display to the user.
     */
    public static String format(Patient person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
            .append("; Phone: ")
            .append(person.getPhone())
            .append("; BirthDate: ")
            .append(person.getBirthdate())
            .append("; Gender: ")
            .append(person.getGender())
            .append("; Appointment: ")
            .append(person.getAppointmentdate())
            .append("; Service: ")
            .append(person.getService())
            .append("; Address: ")
            .append(person.getAddress())
            .append("; Email: ")
            .append(person.getEmail())
            .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * Formats the {@code dentist} for display to the user.
     */
    public static String format(Dentist dentist) {
        final StringBuilder builder = new StringBuilder();
        builder.append(dentist.getName())
                .append("; Phone: ")
                .append(dentist.getPhone())
                .append("; Email: ")
                .append(dentist.getEmail())
                .append("; Address: ")
                .append(dentist.getAddress())
                .append("; Specialization: ")
                .append(dentist.getSpecialization())
                .append("; Years of Experience: ")
                .append(dentist.getYoe())
                .append("; Dentist ID: ")
                .append(dentist.getId())
                .append("; Tags: ");
        dentist.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * Formats the given appointment as a string.
     * The string format includes information about the dentist, patient, appointment start time, and duration.
     *
     * @param appointment The appointment to be formatted.
     * @return A formatted string representation of the appointment.
     * @throws NullPointerException if the appointment is null.
     */
    public static String format(Appointment appointment) {
        final StringBuilder builder = new StringBuilder();
        builder.append("; Dentist: ")
            .append(appointment.getDentistName())
            .append("; Patient: ")
            .append(appointment.getPatientName())
            .append("; Appointment: ")
            .append(appointment.getAppointmentTime().startToString())
            .append("; Duration: ")
            .append(appointment.getAppointmentTime().durationToString());
        return builder.toString();
    }

}
