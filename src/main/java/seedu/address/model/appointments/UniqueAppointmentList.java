package seedu.address.model.appointments;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.dentist.Dentist;

public class UniqueAppointmentList implements Iterable<Appointment> {
    private final ObservableList<Appointment> internalList = FXCollections.observableArrayList();
    private final ObservableList<Appointment> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public void add(Appointment toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);

    }

    public void setAppointments(List<Appointment> appointments) {
        requireAllNonNull(appointments);
        internalList.setAll(appointments);
    }

    public ObservableList<Appointment> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    public boolean contains(Appointment toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameAppointmentTime);
    }

    @Override
    public Iterator<Appointment> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UniqueAppointmentList)) {
            return false;
        }

        UniqueAppointmentList otherUniqueAppointmentList = (UniqueAppointmentList) other;
        return internalList.equals(otherUniqueAppointmentList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

}
