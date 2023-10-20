package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDentists.DENTIST_ALICE;

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
import seedu.address.testutil.DentistBuilder;

public class AddDentistCommandTest {

    @Test
    public void constructor_nullDentist_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddDentistCommand(null));
    }

    @Test
    public void execute_dentistAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingDentistAdded modelStub = new ModelStubAcceptingDentistAdded();
        Dentist validDentist = new DentistBuilder().build();

        CommandResult commandResult = new AddDentistCommand(validDentist).execute(modelStub);

        assertEquals(
            String.format(AddDentistCommand.MESSAGE_SUCCESS, Messages.format(validDentist)),
            commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validDentist), modelStub.dentistAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Dentist validDentist = new DentistBuilder().build();
        AddDentistCommand addDentistCommand = new AddDentistCommand(validDentist);
        ModelStub modelStub = new ModelStubWithDentist(validDentist);

        assertThrows(CommandException.class,
            AddDentistCommand.MESSAGE_DUPLICATE_DENTIST, () -> addDentistCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Dentist alice = new DentistBuilder().withName("Alice").build();
        Dentist bob = new DentistBuilder().withName("Bob").build();
        AddDentistCommand addAliceCommand = new AddDentistCommand(alice);
        AddDentistCommand addBobCommand = new AddDentistCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddDentistCommand addAliceCommandCopy = new AddDentistCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    @Test
    public void toStringMethod() {
        AddDentistCommand addDentistCommand = new AddDentistCommand(DENTIST_ALICE);
        String expected =
            AddDentistCommand.class.getCanonicalName() + "{toAdd=" + DENTIST_ALICE + "}";
        assertEquals(expected, addDentistCommand.toString());
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
        public void updateFilteredTreatmentList(Predicate<Treatment> predicate) {
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

    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithDentist extends ModelStub {

        private final Dentist dentist;

        ModelStubWithDentist(Dentist dentist) {
            requireNonNull(dentist);
            this.dentist = dentist;
        }

        @Override
        public boolean hasDentist(Dentist dentist) {
            requireNonNull(dentist);
            return this.dentist.isSamePerson(dentist);
        }
    }

    /**
     * A Model stub that always accept the dentist being added.
     */
    private class ModelStubAcceptingDentistAdded extends ModelStub {

        final ArrayList<Dentist> dentistAdded = new ArrayList<>();

        @Override
        public boolean hasDentist(Dentist dentist) {
            requireNonNull(dentist);
            return dentistAdded.stream().anyMatch(dentist::isSameDentist);
        }

        @Override
        public void addDentist(Dentist dentist) {
            requireNonNull(dentist);
            dentistAdded.add(dentist);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
