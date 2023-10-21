package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.appointments.AppointmentTime;
import seedu.address.model.person.Name;

/**
 * Jackson-friendly version of {@link Appointment}.
 */
public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String dentist;
    private final String patient;
    private final String start;
    private final String duration;
    private final String treatment;
    private final String id;

    /**
     * Constructs a {@code JsonAdaptedAppointment} with the given appointment details.
     *
     * @param dentist The dentist's name.
     * @param patient The patient's name.
     * @param start The start time of the appointment in string format.
     * @param duration The duration of the appointment in string format.
     * @param treatment The treatment provided during the appointment.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("dentist") String dentist, @JsonProperty("patient") String patient,
                             @JsonProperty("start") String start, @JsonProperty("duration") String duration,
                                  @JsonProperty("treatment") String treatment, @JsonProperty("id") String id) {
        this.dentist = dentist;
        this.patient = patient;
        this.start = start;
        this.duration = duration;
        this.treatment = treatment;
        this.id = id;

    }

    /**
     * Converts a given {@code Appointment} into this class for Jackson use.
     *
     * @param source The source appointment to be adapted.
     */
    public JsonAdaptedAppointment(Appointment source) {
        dentist = String.valueOf(source.getDentist());
        patient = String.valueOf(source.getPatient());
        start = source.getAppointmentTime().startToString();
        duration = source.getAppointmentTime().durationToString();
        treatment = source.getTreatment();
        id = String.valueOf(source.getId());
    }

    /**
     * Converts this Jackson-friendly adapted appointment object into the model's {@code Appointment} object.
     *
     * @return The corresponding {@code Appointment} object.
     * @throws IllegalValueException If there were any data constraints violated in the adapted appointment.
     */
    public Appointment toModelType() throws IllegalValueException {
        if (dentist == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        long did = Long.parseLong(dentist);
        if (patient == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        long pid = Long.parseLong(patient);
        if (start == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (duration == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (treatment == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (id == null) {
            throw new IllegalValueException(
                    "id value does not exist!");
        }
        long lid = Long.parseLong(id);

        final AppointmentTime appointmentTime = new AppointmentTime(start, duration);
        return new Appointment(did, pid, appointmentTime, duration, treatment, lid);
    }
}
