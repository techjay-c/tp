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
            + ": Filters appointments by dentists using their dentist ID. \n"
            + "Example: " + COMMAND_WORD + " 1";

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
        if (attribute.equalsIgnoreCase("patient")) {
            appointmentPredicate = appointment -> appointment.getPatientId() == id;
        } else if (attribute.equalsIgnoreCase("dentist")) {
            appointmentPredicate = appointment -> appointment.getDentistId() == id;
        } else {
            return new CommandResult("Invalid inputs");
        }

        if (id >= 0) {
            model.updateFilteredAppointmentList(appointmentPredicate);

            if (model.getFilteredAppointmentList().isEmpty()) {
                return new CommandResult("No appointments with dentist/patient"
                        + " whose dentist/patient ID is "
                        + id + " found.");
            } else {
                return new CommandResult("Appointments with dentist/patient whose dentist/patient ID is "
                        + id + " listed.");
            }
        } else {
            return new CommandResult("Invalid ID");
        }

    }
}
