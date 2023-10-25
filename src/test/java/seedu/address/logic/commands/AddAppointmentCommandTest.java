package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.treatment.Treatment;
import seedu.address.testutil.AppointmentBuilder;

public class AddAppointmentCommandTest {

    @Test
    public void constructor_nullAppointment_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddAppointmentCommand(null));
    }

    @Test
    public void execute_appointmentAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingAppointmentAdded modelStub = new ModelStubAcceptingAppointmentAdded();
        Appointment validAppointment = new AppointmentBuilder().build();

        CommandResult commandResult = new AddAppointmentCommand(validAppointment).execute(modelStub);

        assertEquals(String.format(AddAppointmentCommand.MESSAGE_SUCCESS, Messages.format(validAppointment)),
                commandResult.getFeedbackToUser());

        assertEquals(Arrays.asList(validAppointment), modelStub.appointmentAdded);
    }
    
    @Test
    public void execute_duplicateAppointment_throwsCommandException() {
        Appointment validAppointment = new AppointmentBuilder().build();
        AddAppointmentCommand addAppointmentCommand = new AddAppointmentCommand(validAppointment);
        ModelStub modelStub = new ModelStubWithAppointment(validAppointment);

        assertThrows(CommandException.class,
                AddAppointmentCommand.MESSAGE_CLASHING_APPOINTMENT,
                () -> addAppointmentCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Appointment one = new AppointmentBuilder().withDentistId("1").build();
        Appointment two = new AppointmentBuilder().withDentistId("2").build();
        AddAppointmentCommand addOneCommand = new AddAppointmentCommand(one);
        AddAppointmentCommand addTwoCommand = new AddAppointmentCommand(two);

        // same object -> returns true
        assertTrue(addOneCommand.equals(addOneCommand));

        // same values -> returns true
        AddAppointmentCommand addOneCommandCopy = new AddAppointmentCommand(one);
        assertTrue(addOneCommand.equals(addOneCommandCopy));

        // different types -> returns false
        assertFalse(addOneCommand.equals(1));

        // null -> returns false
        assertFalse(addOneCommand.equals(null));

        // different appointments -> returns false
        assertFalse(addOneCommand.equals(addTwoCommand));
    }

    @Test
    public void toStringMethod() {
        //AddAppointmentCommand addAppointmentCommand = new AddAppointmentCommand()
    }

    /**
     * A default model stub that has all of its methods failing.
     */
    private class ModelStub implements Model {

        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteDentist(Dentist dentist) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteAppointment(Appointment appointment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setDentist(Dentist target, Dentist editedDentist) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPatientList(Predicate<Patient> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPatientList(NameContainsKeywordsPredicate predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredDentistList(Predicate<Dentist> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredDentistList(NameContainsKeywordsPredicate predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Patient> getFilteredPatientList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Dentist> getFilteredDentistList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Appointment> getFilteredAppointmentList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addDentist(Dentist dentist) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addAppointment(Appointment appointment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPatient(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasDentist(Dentist dentist) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasAppointment(Appointment appointment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Patient getPatientById(long patientId) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Dentist getDentistById(long dentistId) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Appointment getAppointmentById(long appointmentId) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTreatmentList(Predicate<Treatment> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredAppointmentList(Predicate<Appointment> appointmentPredicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Treatment> getFilteredTreatmentList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTreatment(Treatment treatment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTreatment(Treatment treatment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTreatment(Treatment treatment) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Treatment getTreatmentByName(String treatmentName) {
            throw new AssertionError("This method should not be called.");
        }

    }

    /**
     * A Model stub that contains a single appointment.
     */
    private class ModelStubWithAppointment extends ModelStub {

        private final Appointment appointment;

        ModelStubWithAppointment(Appointment appointment) {
            requireNonNull(appointment);
            this.appointment = appointment;
        }

        @Override
        public boolean hasAppointment(Appointment appointment) {
            requireNonNull(appointment);
            return this.appointment.isSameAppointment(appointment);
        }
    }
    private class ModelStubAcceptingAppointmentAdded extends ModelStub {

        final ArrayList<Appointment> appointmentAdded = new ArrayList<>();

        @Override
        public boolean hasAppointment(Appointment appointment) {
            requireNonNull(appointment);
            return appointmentAdded.stream().anyMatch(appointment::isSameAppointment);
        }

        @Override
        public void addAppointment(Appointment appointment) {
            requireNonNull(appointment);
            appointmentAdded.add(appointment);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }
}
