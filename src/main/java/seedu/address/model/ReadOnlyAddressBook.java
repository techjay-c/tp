package seedu.address.model;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.person.dentist.Dentist;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Person> getPersonList();

    /**
     * Returns an unmodifiable view of the patients list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Patient> getPatientList();

    /**
     * Returns an unmodifiable view of the dentists list.
     * This list will not contain any duplicate dentists.
     */

    ObservableList<Dentist> getDentistList();
}
