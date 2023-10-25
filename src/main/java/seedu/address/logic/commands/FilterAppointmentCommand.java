package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.model.Model;
import seedu.address.model.appointments.Appointment;

/**
 * Filters the appointment list by dentistID.
 */
public class FilterAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "filter-appointment";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Filters appointments by dentists/patients using their dentist/patient ID. \n"
            + "Parameters: " + "ID_TYPE[dentist/patient] " + "DENTIST_ID/PATIENT_ID \n"
            + "Example: " + COMMAND_WORD + " dentist/patient" + " 1";

    private String attribute;
    private long id;

    public FilterAppointmentCommand(String attribute, long id) {
        this.attribute = attribute;
        this.id = id;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        Predicate<Appointment> appointmentPredicate;
        String success;
        String failure;
        if (attribute.equalsIgnoreCase("patient")) {
            appointmentPredicate = appointment -> appointment.getPatientId() == id;
            success = "Appointments with patient whose patient ID is " + id + " listed.";
            failure = "No appointments with patient whose patient ID is " + id + " found.";
        } else if (attribute.equalsIgnoreCase("dentist")) {
            appointmentPredicate = appointment -> appointment.getDentistId() == id;
            success = "Appointments with dentist whose dentist ID is " + id + " listed.";
            failure = "No appointments with dentist whose dentist ID is " + id + " found.";
        } else {
            return new CommandResult("Invalid inputs. Please key in correct format: "
                    + "dentist/patient DENTIST_ID/PATIENT_ID");
        }

        if (id >= 0) {
            model.updateFilteredAppointmentList(appointmentPredicate);

            if (model.getFilteredAppointmentList().isEmpty()) {
                return new CommandResult(failure);
            } else {
                return new CommandResult(success);
            }
        } else {
            return new CommandResult("Invalid ID. ID must be a positive number.");
        }

    }
}
