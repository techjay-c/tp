package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

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
            + PREFIX_START + "START_TIME "
            + PREFIX_DURATION + "DURATION "
            + PREFIX_SERVICE + "SERVICE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DENTIST + "TOM "
            + PREFIX_PATIENT + "JOHN "
            + PREFIX_START + "2023-10-12 16:00 "
            + PREFIX_DURATION + "PT1H30M "
            + PREFIX_SERVICE + "Braces";

    public static final String MESSAGE_SUCCESS = "New Appointment added: %1$s";

    public static final String MESSAGE_CLASHING_APPOINTMENTS = "This Appointment clashes with a current one";

    private final Appointment toAdd;

    public AddAppointmentCommand(Appointment appointment) {
        requireNonNull(appointment);
        toAdd = appointment;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (model.hasAppointment(toAdd)) {
            throw new CommandException(MESSAGE_CLASHING_APPOINTMENTS);
        }
        model.addAppointment(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

}
