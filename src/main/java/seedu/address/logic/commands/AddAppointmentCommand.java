package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DENTIST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATIENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START;

import java.util.function.Predicate;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;


/**
 * Adds an appointment to ToothTracker.
 */
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
            + PREFIX_DENTIST + "0 "
            + PREFIX_PATIENT + "0 "
            + PREFIX_START + "2023-10-12 16:00 "
            + PREFIX_DURATION + "PT1H30M "
            + PREFIX_SERVICE + "Braces";

    public static final String MESSAGE_SUCCESS = "New Appointment added: %1$s";

    public static final String MESSAGE_CLASHING_APPOINTMENTS = "This Appointment clashes with a current one.";

    private final Appointment toAdd;
    private final long dentistId;
    private final long patientId;

    /**
     * Constructs an AddAppointmentCommand with the specified appointment.
     *
     * @param appointment The appointment to be added.
     */
    public AddAppointmentCommand(Appointment appointment) {
        requireNonNull(appointment);
        toAdd = appointment;
        dentistId = appointment.getDentist();
        patientId = appointment.getPatient();
    }


    /**
     * Executes the command to add the appointment to the model.
     *
     * @param model The model in which the appointment is to be added.
     * @return The result of the command execution.
     * @throws CommandException If the appointment clashes with an existing one.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.hasAppointment(toAdd)) {
            throw new CommandException(MESSAGE_CLASHING_APPOINTMENTS);
        }
        if (dentistId >= 0) {
            Predicate<Dentist> dentistIdPredicate = dentist -> dentist.getId() == dentistId;
            model.updateFilteredDentistList(dentistIdPredicate);

            if (model.getFilteredDentistList().isEmpty()) {
                throw new CommandException("No dentist with ID " + dentistId);
            }

        }

        if (patientId >= 0) {
            Predicate<Patient> patientIdPredicate = patient -> patient.getId() == patientId;
            model.updateFilteredPatientList(patientIdPredicate);

            if (model.getFilteredPatientList().isEmpty()) {
                throw new CommandException("No patient with ID " + dentistId);
            }

        }
        model.addAppointment(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

}
