package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DENTIST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATIENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TREATMENT;

import java.util.function.Predicate;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.appointments.AppointmentTime;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.treatment.Treatment;


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
            + PREFIX_TREATMENT + "TREATMENT \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DENTIST + "1 "
            + PREFIX_PATIENT + "1 "
            + PREFIX_START + "2023-10-12 16:00 "
            + PREFIX_TREATMENT + "Braces";

    public static final String MESSAGE_SUCCESS = "New Appointment added: %1$s";

    public static final String MESSAGE_CLASHING_APPOINTMENT = "Dentist or patient already has" +
            " existing appointment in this time slot.";

    private final Appointment toAdd;
    private final long dentistId;
    private final long patientId;
    private final String treatmentName;
    private final String start;

    /**
     * Constructs an AddAppointmentCommand with the specified appointment.
     *
     * @param appointment The appointment to be added.
     */
    public AddAppointmentCommand(Appointment appointment) {
        requireNonNull(appointment);
        toAdd = appointment;
        dentistId = appointment.getDentistId();
        patientId = appointment.getPatientId();
        treatmentName = appointment.getTreatment();
        start = appointment.getStart();
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
        Predicate<Treatment> treatmentPredicate = treatment -> treatment.getName().toString()
                .equalsIgnoreCase(treatmentName);
        model.updateFilteredTreatmentList(treatmentPredicate);

        if (model.getFilteredTreatmentList().isEmpty()) {
            throw new CommandException("Treatment is not provided in this clinic");
        }
        String duration = model.getFilteredTreatmentList().get(0).getTime().toString();
        AppointmentTime appointmentTime;
        try {
            appointmentTime = ParserUtil.parseAppointmentTime(start, duration);
        } catch (ParseException e) {
            throw new CommandException("Appointment start time in wrong format.", e);
        }

        toAdd.setAppointmentTime(appointmentTime);

        String cost = model.getFilteredTreatmentList().get(0).getCost().toString();
        toAdd.setCost(cost);

        checkValidPersons(model);


        if (model.hasAppointment(toAdd)) {
            throw new CommandException(MESSAGE_CLASHING_APPOINTMENT);
        }

        model.addAppointment(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    /**
     * Checks the validity of dentist and patient IDs in the given model and
     * updates the corresponding names in the Appointment to be added.
     *
     * @param model The model containing dentist and patient information.
     * @throws CommandException If an invalid dentist or patient ID is encountered.
     */
    public void checkValidPersons(Model model) throws CommandException {
        if (dentistId >= 0) {

            Dentist dentist = model.getDentistById(dentistId);

            if (dentist == null) {
                throw new CommandException("No dentist with ID " + dentistId);
            }
            toAdd.setDentistName(dentist.getName().fullName);
        } else {
            throw new CommandException("Dentist ID must be a valid input: ID must be positive.");
        }

        if (patientId >= 0) {
            Patient patient = model.getPatientById(patientId);
            if (patient == null) {
                throw new CommandException("No patient with ID " + patientId);
            }
            toAdd.setPatientName(patient.getName().fullName);
        } else {
            throw new CommandException("Patient ID must be valid: ID must be positive.");
        }
    }

}
