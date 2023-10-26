package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTreatments.WISDOM;

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
import seedu.address.model.treatment.TreatmentName;
import seedu.address.testutil.TreatmentBuilder;

public class AddTreatmentCommandTest {

    @Test
    public void constructor_nullTreatment_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddTreatmentCommand(null));
    }

    @Test
    public void execute_treatmentAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingTreatmentAdded modelStub = new ModelStubAcceptingTreatmentAdded();
        Treatment validTreatment = new TreatmentBuilder().build();

        CommandResult commandResult = new AddTreatmentCommand(validTreatment).execute(modelStub);

        assertEquals(
            String.format(AddTreatmentCommand.MESSAGE_SUCCESS, Messages.format(validTreatment)),
            commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validTreatment), modelStub.treatmentAdded);
    }

    @Test
    public void execute_duplicateTreatment_throwsCommandException() {
        Treatment validTreatment = new TreatmentBuilder().build();
        AddTreatmentCommand addTreatmentCommand = new AddTreatmentCommand(validTreatment);
        ModelStub modelStub = new ModelStubWithTreatment(validTreatment);

        assertThrows(CommandException.class,
            AddTreatmentCommand.MESSAGE_DUPLICATE_TREATMENT, () -> addTreatmentCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Treatment alice = new TreatmentBuilder().withName("Alice").build();
        Treatment bob = new TreatmentBuilder().withName("Bob").build();
        AddTreatmentCommand addAliceCommand = new AddTreatmentCommand(alice);
        AddTreatmentCommand addBobCommand = new AddTreatmentCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddTreatmentCommand addAliceCommandCopy = new AddTreatmentCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different Treatment -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    @Test
    public void toStringMethod() {
        AddTreatmentCommand addTreatmentCommand = new AddTreatmentCommand(WISDOM);
        String expected =
            AddTreatmentCommand.class.getCanonicalName() + "{toAdd=" + WISDOM + "}";
        assertEquals(expected, addTreatmentCommand.toString());
    }

    /**
     * A default model stub that have all of the methods failing.
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
        public boolean hasTreatmentName(TreatmentName treatmentName) {
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
     * A Model stub that contains a single Treatment.
     */
    private class ModelStubWithTreatment extends ModelStub {

        private final Treatment treatment;

        ModelStubWithTreatment(Treatment dentist) {
            requireNonNull(dentist);
            this.treatment = dentist;
        }

        @Override
        public boolean hasTreatment(Treatment treatment) {
            requireNonNull(treatment);
            return this.treatment.isSameTreatment(treatment);
        }
    }

    /**
     * A Model stub that always accept the dentist being added.
     */
    private class ModelStubAcceptingTreatmentAdded extends ModelStub {

        final ArrayList<Treatment> treatmentAdded = new ArrayList<>();

        @Override
        public boolean hasTreatment(Treatment treatment) {
            requireNonNull(treatment);
            return treatmentAdded.stream().anyMatch(treatment::isSameTreatment);
        }

        @Override
        public void addTreatment(Treatment treatment) {
            requireNonNull(treatment);
            treatmentAdded.add(treatment);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
