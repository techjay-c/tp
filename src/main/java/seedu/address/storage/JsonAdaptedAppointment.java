package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Person;

public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String dentist;
    private final String patient;
    private final String date;
    private final String duration;

    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("dentist") String dentist, @JsonProperty("patient") String patient,
                             @JsonProperty("date") String date, @JsonProperty("duration") String duration) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
        this.duration = duration;

    }

    public JsonAdaptedAppointment(Appointment source) {
        dentist = source.getDentist();
        patient = source.getPatient();
        date = source.getAppointmentDate().toString();
        duration = source.getDuration();

    }

    public Appointment toModelType() throws IllegalValueException {
        final AppointmentDate appointmentDate = new AppointmentDate(date);
        return new Appointment(dentist, patient, appointmentDate, duration);
    }
}
