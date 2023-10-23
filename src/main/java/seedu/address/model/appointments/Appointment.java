package seedu.address.model.appointments;

/**
 * Represents an Appointment in ToothTracker.
 */
public class Appointment {
    private final long dentistId;
    private final long patientId;
    private String dentistName;
    private String patientName;
    private final AppointmentTime appointmentTime;
    private final String duration;
    private final String treatment;
    private long id;

    /**
     * Constructs an Appointment with the specified details.
     *
     * @param dentistId The ID of the dentist for the appointment.
     * @param patientId The ID of the patient for the appointment.
     * @param appointmentTime The time and date of the appointment.
     * @param duration The duration of the appointment.
     * @param treatment The treatment provided.
     */
    public Appointment(long dentistId, long patientId, AppointmentTime appointmentTime,
                       String duration, String treatment) {
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.treatment = treatment;
        this.id = -1;
    }

    /**
     * Constructs an Appointment with the specified details.
     *
     * @param dentistId The ID of the dentist for the appointment.
     * @param patientId The ID of the patient for the appointment.
     * @param appointmentTime The time and date of the appointment.
     * @param duration The duration of the appointment.
     * @param treatment The treatment provided.
     * @param id The appointment id.
     */
    public Appointment(long dentistId, long patientId, AppointmentTime appointmentTime,
                       String duration, String treatment, long id) {
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.treatment = treatment;
        this.id = id;
    }

    public long getDentistId() {
        return this.dentistId;
    }

    public long getPatientId() {
        return this.patientId;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDentistName() {
        return this.dentistName;
    }

    public String getPatientName() {
        return this.patientName;
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
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
