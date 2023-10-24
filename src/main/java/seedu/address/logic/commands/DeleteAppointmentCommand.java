package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointments.Appointment;

/**
 * Deletes an appointment identified using it's displayed index from ToothTracker.
 */
public class DeleteAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "delete-appointment";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the appointment identified by the given appointment ID.\n"
            + "Parameters: ID (must be a valid appointment ID)\n"
            + "Example: " + COMMAND_WORD + "001";

    public static final String MESSAGE_DELETE_APPOINTMENT_SUCCESS = "Deleted Appointment: %1$s";

    private final long targetId;

    public DeleteAppointmentCommand(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        try {
            Appointment appointmentToDelete = model.getAppointmentById(targetId);

            if (appointmentToDelete == null) {
                throw new CommandException(String.format(Messages.MESSAGE_NO_SUCH_APPOINTMENT, targetId));
            }

            model.deleteAppointment(appointmentToDelete);
            return new CommandResult(
                    String.format(Messages.MESSAGE_DELETE_APPOINTMENT_SUCCESS, Messages.format(appointmentToDelete)));

        } catch (Exception e) {
            throw new CommandException("An error occurred while deleting the appointment: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteAppointmentCommand)) {
            return false;
        }

        DeleteAppointmentCommand otherDeleteAppointmentCommand = (DeleteAppointmentCommand) other;
        return Objects.equals(targetId, otherDeleteAppointmentCommand.targetId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetId)
                .toString();
    }
}
