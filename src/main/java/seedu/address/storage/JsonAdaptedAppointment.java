package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.appointments.AppointmentTime;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Name;

public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String dentist;
    private final String patient;
    private final String start;
    private final String duration;

    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("dentist") String dentist, @JsonProperty("patient") String patient,
                             @JsonProperty("start") String start, @JsonProperty("duration") String duration) {
        this.dentist = dentist;
        this.patient = patient;
        this.start = start;
        this.duration = duration;

    }

    public JsonAdaptedAppointment(Appointment source) {
        dentist = source.getDentist();
        patient = source.getPatient();
        start = source.getAppointmentTime().startToString();
        duration = source.getAppointmentTime().durationToString();

    }

    public Appointment toModelType() throws IllegalValueException {
        if (dentist == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (patient == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (start == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (duration == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        final AppointmentTime appointmentTime = new AppointmentTime(start, duration);
        return new Appointment(dentist, patient, appointmentTime, duration);
    }
}
