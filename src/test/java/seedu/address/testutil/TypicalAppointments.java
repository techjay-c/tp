package seedu.address.testutil;

import seedu.address.model.appointments.Appointment;

/**
 * A utility class containing a list of {@code Appointment} objects to be used in tests.
 */
public class TypicalAppointments {

    public static final Appointment APPOINTMENT_ONE = new AppointmentBuilder()
            .withDentistId("1")
            .withPatientId("2")
            .withDentistName("Tom")
            .withPatientName("Mary")
            .withAppointmentTime("2023-10-19T16:00", "PT1H30M")
            .withTreatment("Braces")
            .withCost("100").build();

    public static final Appointment APPOINTMENT_TWO = new AppointmentBuilder()
            .withDentistId("3")
            .withPatientId("2")
            .withDentistName("John")
            .withPatientName("Mary")
            .withAppointmentTime("2023-10-20T12:00", "PT2H00M")
            .withTreatment("Tooth Extraction")
            .withCost("150").build();
}
