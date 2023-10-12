package seedu.address.model.appointments;

import seedu.address.model.person.AppointmentDate;

public class Appointment {
    private final String dentist;
    private final String patient;
    private final AppointmentDate appointmentDate;
    private final String duration;

    public Appointment(String dentist, String patient, AppointmentDate appointmentDate, String duration) {
        this.dentist = dentist;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.duration = duration;
    }

    public String getDentist() {
        return this.dentist;
    }

    public String getPatient() {
        return this.patient;
    }

    public String getDuration() {
        return this.duration;
    }

    public AppointmentDate getAppointmentDate() {
        return this.appointmentDate;
    }
}
