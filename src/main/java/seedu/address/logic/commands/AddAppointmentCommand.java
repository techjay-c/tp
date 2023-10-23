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
            + PREFIX_SERVICE + "SERVICE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DENTIST + "0 "
            + PREFIX_PATIENT + "0 "
            + PREFIX_START + "2023-10-12 16:00 "
            + PREFIX_SERVICE + "Braces";

    public static final String MESSAGE_SUCCESS = "New Appointment added: %1$s";

    public static final String MESSAGE_CLASHING_DOCTORS = "This dentist already has a "
            + "current appointment in the same time slot.";

    public static final String MESSAGE_CLASHING_PATIENTS = "This patient already has a "
            + "current appointment in the same time slot.";

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
            throw new CommandException("Service is not provided in this clinic");
        }
        String duration = model.getFilteredTreatmentList().get(0).getTime().toString();
        AppointmentTime appointmentTime;
        try {
            appointmentTime = ParserUtil.parseAppointmentTime(start, duration);
        } catch (ParseException e) {
            throw new CommandException("Appointment start time in wrong format.", e);
        }

        toAdd.setAppointmentTime(appointmentTime);

        if (dentistId >= 0) {
            Predicate<Dentist> dentistIdPredicate = dentist -> dentist.getId() == dentistId;
            model.updateFilteredDentistList(dentistIdPredicate);

            if (model.getFilteredDentistList().isEmpty()) {
                throw new CommandException("No dentist with ID " + dentistId);
            }
            Dentist dentist = model.getFilteredDentistList().get(0);
            toAdd.setDentistName(dentist.getName().fullName);
        }

        if (patientId >= 0) {
            Predicate<Patient> patientIdPredicate = patient -> patient.getId() == patientId;
            model.updateFilteredPatientList(patientIdPredicate);

            if (model.getFilteredPatientList().isEmpty()) {
                throw new CommandException("No patient with ID " + dentistId);
            }
            Patient patient = model.getFilteredPatientList().get(0);
            toAdd.setPatientName(patient.getName().fullName);
        }

        if (model.hasAppointment(toAdd)) {
            Predicate<Appointment> appointmentPredicate = toAdd::isSameAppointmentTime;
            model.updateFilteredAppointmentList(appointmentPredicate);

            if (!model.getFilteredAppointmentList().isEmpty()) {
                for (int i = 0; i < model.getFilteredAppointmentList().size(); i++) {
                    if (model.getFilteredAppointmentList().get(i).getDentistId() == dentistId) {
                        throw new CommandException(MESSAGE_CLASHING_DOCTORS);
                    }
                }
            }

            if (!model.getFilteredAppointmentList().isEmpty()) {
                for (int i = 0; i < model.getFilteredAppointmentList().size(); i++) {
                    if (model.getFilteredAppointmentList().get(i).getPatientId() == patientId) {
                        throw new CommandException(MESSAGE_CLASHING_PATIENTS);
                    }
                }
            }
        }

        model.addAppointment(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

}
