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

    private long dentistId;

    public FilterAppointmentCommand(long dentistId) {
        this.dentistId = dentistId;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        if (dentistId >= 0) {
            Predicate<Appointment> appointmentPredicate = appointment -> appointment.getDentistId() == dentistId;
            model.updateFilteredAppointmentList(appointmentPredicate);

            if (model.getFilteredAppointmentList().isEmpty()) {
                return new CommandResult("No appointments with dentist whose dentist ID is "
                        + dentistId + " found.");
            } else {
                return new CommandResult("Appointments with dentist whose dentist ID is "
                        + dentistId + " listed.");
            }
        } else {
            return new CommandResult("Invalid dentist ID");
        }
    }
}
