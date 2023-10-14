package seedu.address.model.appointments;

import seedu.address.model.person.AppointmentDate;

public class Appointment {
    private final String dentist;
    private final String patient;
    private final AppointmentTime appointmentTime;
    private final String duration;

    public Appointment(String dentist, String patient, AppointmentTime appointmentTime, String duration) {
        this.dentist = dentist;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
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

    public AppointmentTime getAppointmentTime() {
        return this.appointmentTime;
    }

    public boolean isSameAppointmentTime(Appointment appointment) {
        return this.appointmentTime.isStartTimeBetween(appointment.getAppointmentTime());
    }
}
