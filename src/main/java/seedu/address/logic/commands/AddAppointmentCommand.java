package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DENTIST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATIENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.Model;

public class AddAppointmentCommand extends Command {
    public static final String COMMAND_WORD = "add-appointment";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an appointment to ToothTracker. "
            + "Parameters: "
            + PREFIX_DENTIST + "DENTIST "
            + PREFIX_PATIENT + "PATIENT "
            + PREFIX_APPOINTMENT + "APPOINTMENT "
            + PREFIX_DURATION + "DURATION \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DENTIST + "TOM "
            + PREFIX_PATIENT + "JOHN "
            + PREFIX_APPOINTMENT + "11-11-23 "
            + PREFIX_DURATION + "2 ";

    public static final String MESSAGE_SUCCESS = "New Appointment added: %1$s";

    public static final String MESSAGE_CLASHING_APPOINTMENTS = "This Appointment clashes with a current one";

    private final Appointment toAdd;

    public AddAppointmentCommand(Appointment appointment) {
        requireNonNull(appointment);
        toAdd = appointment;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.addAppointment(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

}
