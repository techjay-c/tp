package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.appointments.Appointment;

public class AppointmentCard extends UiPart<Region> {
    private static final String FXML = "AppointmentListCard.fxml";

    public final Appointment appointment;

    @FXML
    private HBox cardPane;
    @FXML
    private Label dentist;
    @FXML
    private Label patient;
    @FXML
    private Label date;
    @FXML
    private Label duration;

    public AppointmentCard(Appointment appointment) {
        super(FXML);
        this.appointment = appointment;
        dentist.setText(appointment.getDentist());
        patient.setText(appointment.getPatient());
        date.setText(appointment.getAppointmentDate().toString());
        duration.setText(appointment.getDuration());

    }
}
