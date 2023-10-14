package seedu.address.model.appointments;

/**
 * Represents an Appointment in ToothTracker.
 */
public class Appointment {
    private final String dentist;
    private final String patient;
    private final AppointmentTime appointmentTime;
    private final String duration;
    private final String treatment;

    /**
     * Constructs an Appointment with the specified details.
     *
     * @param dentist The name of the dentist for the appointment.
     * @param patient The name of the patient for the appointment.
     * @param appointmentTime The time and date of the appointment.
     * @param duration The duration of the appointment.
     * @param treatment The treatment provided.
     */
    public Appointment(String dentist, String patient, AppointmentTime appointmentTime,
                       String duration, String treatment) {
        this.dentist = dentist;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.treatment = treatment;
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

    public String getTreatment() {
        return this.treatment;
    }

    /**
     * Checks whether this appointment clashes with another.
     *
     * @param appointment The other appointment.
     * @return true if this appointment clashes with another
     *         false if it does not clash with another appointment.
     */
    public boolean isSameAppointmentTime(Appointment appointment) {
        return this.appointmentTime.isClashingAppointment(appointment.getAppointmentTime());
    }
}
